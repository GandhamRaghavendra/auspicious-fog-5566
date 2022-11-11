package tms.Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import tms.Been.BiderBeen;
import tms.Been.ProjectBeen;
import tms.Been.VendorBeen;
import tms.Exception.VendorException;
import tms.Utility.DbUtil;

public class VendorDaoImpl implements VendorDao{

	@Override
	public VendorBeen vendorLogin(String mail, int pass) throws VendorException {
		VendorBeen v=null;
		try(Connection con = DbUtil.ConnectionProvider()){
			PreparedStatement ps = con.prepareStatement("Select * From Vendor Where Email=? And Pass=?");
			
			ps.setString(1, mail);
			ps.setInt(2, pass);
			
			ResultSet rs = ps.executeQuery();
			
			if(rs.next()) {
				v=new VendorBeen(rs.getInt("Vid"),rs.getString("Vname"),rs.getString("Email"),rs.getInt("Pass"),rs.getString("ComName"),rs.getString("Address"));
			}
			else {
				throw new VendorException("Wrong Mail OR Pass");
			}
		} 
		catch (SQLException e) {
			throw new VendorException(e.getMessage());
		}
		
		return v;
	}

	@Override
	public boolean vendorRegistration(VendorBeen v) throws VendorException {
		try(Connection con = DbUtil.ConnectionProvider()){
			PreparedStatement ps = con.prepareStatement("Insert Into Vendor (Vname,Email,Pass,ComName,Address) Values(?,?,?,?,?)");
			
			ps.setString(1,v.getName());
			ps.setString(2,v.getMail());
			ps.setInt(3,v.getPass());
			ps.setString(4,v.getCname());
			ps.setString(5,v.getAdd());
			
			int x = ps.executeUpdate();
			
			if(x>0) return true;
		} 
		catch (SQLException e) {
		   throw new VendorException(e.getMessage());	
		}
		return false;
	}

	@Override
	public VendorBeen updateVendorDetails(int Vid, int pass, VendorBeen v) throws VendorException {
		VendorBeen newv=null;
		try (Connection con = DbUtil.ConnectionProvider()){
			PreparedStatement ps1 = con.prepareStatement("Select * From Vendor Where Vid=? And Pass=?");
			
			ps1.setInt(1,Vid);
			ps1.setInt(2,pass);
			
			ResultSet rs = ps1.executeQuery();
			
			if(rs.next()) {
				PreparedStatement ps2 = con.prepareStatement("Update Vendor Set(Vname,Email,Pass,ComName,Address) Values(?,?,?,?,?)");
				
				ps2.setString(1,v.getName());
				ps2.setString(2,v.getMail());
				ps2.setInt(3,v.getPass());
				ps2.setString(4,v.getCname());
				ps2.setString(5,v.getAdd());
				
				int x = ps2.executeUpdate();
				
				if(x>0) {
					PreparedStatement ps3 = con.prepareStatement("Select * From Vendore Where Vid=?");
					
					ps3.setInt(1,Vid);
					
					ResultSet rs2 = ps3.executeQuery();
					
					if(rs2.next()) {
						newv=new VendorBeen(rs2.getInt("Vid"),rs2.getString("VName"),rs2.getString("Email"),rs2.getInt("Pass"),rs2.getString("ComName"),rs.getString("Address"));
					}
					else throw new VendorException("Vendor Not Found");
				}
				else throw new VendorException("Update Failed");
			}
			else throw new VendorException("Wrong Vid OR Pass");
			
		} 
		catch (SQLException e) {
			throw new VendorException(e.getMessage());
		}
		
		return newv;
	}

	@Override
	public List<ProjectBeen> getAllProjects() throws VendorException {
		List<ProjectBeen> list =new ArrayList<>();
		
		try(Connection con = DbUtil.ConnectionProvider()) {
			PreparedStatement ps = con.prepareStatement("Select * From Projects");
			
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				list.add(new ProjectBeen(rs.getString("Pid"),rs.getString("PName"),rs.getString("Ptype"),rs.getInt("BasePrice"),rs.getString("Pdesc"),rs.getString("Ploc"),rs.getString("DeadLine")));
			}
		} 
		catch (SQLException e) {
			throw new VendorException(e.getMessage());
		}	
		return list ;
	}

	@Override
	public String BidOnProject(BiderBeen b) throws VendorException {
		String mes="Failed";
		try (Connection con = DbUtil.ConnectionProvider()){
			PreparedStatement ps = con.prepareStatement("Insert Into Bider (Vid,Pid,BidAmount,Status) Values(?,?,?,?)");
			ps.setInt(1,b.getVendorId());
			ps.setString(2,b.getPId());
			ps.setInt(3,b.getBidAmount());
			ps.setString(4,"Waiting");
			
			int x = ps.executeUpdate();
			
			if(x>0) mes="Successfully Bid Placed";
		} 
		catch (SQLException e) {
			throw new VendorException(e.getMessage());
		}
		return mes;
		
	}

	@Override
	public String updateBidAmount(int BId, int NewBid) throws VendorException {
		String mes="Failed";
		try(Connection con = DbUtil.ConnectionProvider()) {
			PreparedStatement ps = con.prepareStatement("Update Bider Set BidAmount=? Where Bid=?");
			
		    ps.setInt(1, NewBid);
		    ps.setInt(2,BId);
		    
		    int x = ps.executeUpdate();
		    if(x>0) mes="Amount Updated";
		} 
		catch (SQLException e) {
			throw new VendorException(e.getMessage());
		}
		return mes;
	}

}

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
import tms.Exception.AdminException;
import tms.Exception.VendorException;
import tms.Utility.DbUtil;

public class AdminDaoImpl implements AdminDao{

	@Override
	public boolean adminLogin(String mail, int pass) throws AdminException {
	try (Connection con = DbUtil.ConnectionProvider();){
		PreparedStatement ps = con.prepareStatement("Select * from Admin Where Email=? AND Pass=?");
		
		ps.setString(1, mail);
		ps.setInt(2,pass);
		
		ResultSet rs = ps.executeQuery();
		
		if(rs.next()) {
			return true;
		}
		else {
			return false;
		}
		
	} 
	catch (SQLException e) { 
        //e.printStackTrace();
		throw new AdminException(e.getMessage());
	}	
	}

	@Override
	public String addProject(ProjectBeen p) {
		String mes="Not Added";
	     try(Connection con=DbUtil.ConnectionProvider()) {
			PreparedStatement ps = con.prepareStatement("insert into projects values(?,?,?,?,?,?,?)");
			
			ps.setString(1,p.getId());
			ps.setString(2,p.getName());
			ps.setString(3,p.getType());
			ps.setInt(4,p.getBasePrice());
			ps.setString(5,p.getDesc());
			ps.setString(6,p.getLocation());
			ps.setString(7,p.getDeadLine());
			
			int x = ps.executeUpdate();
			
			if(x>0) mes="Project Added";
		} 
	     catch (SQLException e) {
			e.printStackTrace();
		}
	     return mes;
	}

	@Override
	public String removeProject(String PId) throws AdminException {
		String mes="Failed";
		
		try (Connection con = DbUtil.ConnectionProvider()){
			PreparedStatement ps = con.prepareStatement("Delete From Projects Where Pid=?");
			
			ps.setString(1, PId);
			
			int x = ps.executeUpdate();
			
			if(x>0) mes="Project Deleted";
			
			else mes="Invalid Project Id";
		} 
		catch (SQLException e) {
			throw new AdminException(e.getMessage());
		}
		
		return mes;
	}

	@Override
	public String addVendor(VendorBeen v) {
		String mes="Failed";
		
		try (Connection con = DbUtil.ConnectionProvider()){
			PreparedStatement ps = con.prepareStatement("Insert into Vendor (Vname,Email,Pass,ComName,Address) Values(?,?,?,?,?)");
			
			ps.setString(1,v.getName());
			ps.setString(2,v.getMail());
			ps.setInt(3,v.getPass());
			ps.setString(4,v.getCname());
			ps.setString(5,v.getAdd());
			
			int x = ps.executeUpdate();
			
			if(x>0) mes="New Vendor Added";
		} 
		catch (SQLException e) {
			e.printStackTrace();
		}
		return mes;
	}

	@Override
	public String removeVendor(int VId) throws VendorException {
		String mes="Failed";
		try (Connection con = DbUtil.ConnectionProvider()){
			PreparedStatement ps = con.prepareStatement("Delete From Vendor Where Vid=?");
			ps.setInt(1, VId);
			
			int x = ps.executeUpdate();
			
			if(x>0) mes="Vendor Removed";
		} 
		catch (SQLException e) {
			throw new VendorException(e.getMessage());
		}
		return mes;
	}

	@Override
	public List<ProjectBeen> getAllProjects() throws AdminException {
		List<ProjectBeen> list =new ArrayList<>();
		
		try (Connection con = DbUtil.ConnectionProvider()){
			PreparedStatement ps = con.prepareStatement("Select * From Projects");
			
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				list.add(new ProjectBeen(rs.getString("Pid"),rs.getString("PName"),rs.getString("Ptype"),rs.getInt("BasePrice"),rs.getString("Pdesc"),rs.getString("Ploc"),rs.getString("Deadline")));
			}
			if(list.size()==0) throw new AdminException("No Project Available");
		} 
		catch (SQLException e) {
			throw new AdminException(e.getMessage());
		}
		
		return list;
	}

	@Override
	public List<VendorBeen> getAllVendors() throws VendorException {
		List<VendorBeen> list =new ArrayList<>();
		
		try(Connection con = DbUtil.ConnectionProvider()){
			PreparedStatement ps = con.prepareStatement("Select * From Vendor");
			
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				list.add(new VendorBeen(rs.getInt("Vid"),rs.getString("Vname"),rs.getString("Email"),rs.getInt("Pass"),rs.getString("Comname"),rs.getString("Address")));
			}
			if(list.size()==0) throw new VendorException("Empty Table");
		} 
		catch (SQLException e) {
			throw new VendorException(e.getMessage());
		}
		
		return list;
	}

	@Override
	public List<BiderBeen> getAllBids() throws AdminException {
		List<BiderBeen> list =new ArrayList<>();
		
		try (Connection con = DbUtil.ConnectionProvider()){
			PreparedStatement ps = con.prepareStatement("Select * From Bider");
			
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				list.add(new BiderBeen(rs.getInt("Bid"),rs.getInt("Vid"),rs.getString("Pid"),rs.getInt("BidAmount"),rs.getString("Status")));
			}
			if(list.size()==0) throw new AdminException("Bid Table is Empty");
		} 
		catch (SQLException e) {
			throw new AdminException(e.getMessage());
		}
		
		return list;
	}

	@Override
	public String approveBid(int BId) throws AdminException {
		String mes="Failed";
		
		try (Connection con = DbUtil.ConnectionProvider()){
			PreparedStatement ps = con.prepareStatement("Update Bider Set Status='Approved' Where Bid=?");
			ps.setInt(1, BId);
			
			int x = ps.executeUpdate();
			
			if(x>0) mes="Bid approved";
		} 
		catch (SQLException e) {
			throw new AdminException(e.getMessage());
		}
		
		return mes;
	}

	@Override
	public List<BiderBeen> getAllApprovedBids() throws AdminException {
		List<BiderBeen> list =new ArrayList<>();
		try (Connection con = DbUtil.ConnectionProvider()){
			PreparedStatement ps = con.prepareStatement("Select * From Bider Where Status='approved'");
			
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				list.add(new BiderBeen(rs.getInt("Bid"),rs.getInt("Vid"),rs.getString("Pid"),rs.getInt("BidAmount"),rs.getString("Status")));
			}
			if(list.size()==0) throw new AdminException("Not Bids Approved");
			
		} 
		catch (SQLException e) {
			throw new AdminException(e.getMessage());
		}
		return list;
	}

	@Override
	public void getAdmin(String mail, int pass) throws AdminException {
	     try (Connection con = DbUtil.ConnectionProvider()){
			PreparedStatement ps = con.prepareStatement("Select * From Admin Where Email=? AND Pass=?");
			
			ps.setString(1, mail);
			ps.setInt(2, pass);
			
			ResultSet rs = ps.executeQuery();
			
			if(rs.next()) {
				System.out.println("Admin Details");
				System.out.println("Id: "+rs.getInt("Id"));
				System.out.println("Name: "+rs.getString("Name"));
				System.out.println("Mail: "+rs.getString("Email"));
				System.out.println("Pass: "+rs.getInt("Pass"));
			}
			else throw new AdminException("Invalid Mail OR Pass");
		} 
	     catch (SQLException e) {
			throw new AdminException(e.getMessage());
		}
		
	}

}

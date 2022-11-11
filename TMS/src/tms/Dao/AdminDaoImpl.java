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
		PreparedStatement ps = con.prepareStatement("Select * from Admin Where Email=?,Pass=?");
		
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
	public String removeProject(int PId) throws AdminException {
		String mes="Failed";
		
		try (Connection con = DbUtil.ConnectionProvider()){
			PreparedStatement ps = con.prepareStatement("Delete From Projects Where Pid=?");
			
			ps.setInt(1, PId);
			
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
		} 
		catch (SQLException e) {
			throw new AdminException(e.getMessage());
		}
		
		return list;
	}

	@Override
	public List<VendorBeen> getAllVendors() throws VendorException {
		List<VendorBeen> list =new ArrayList<>();
		
		
		
		return list;
	}

	@Override
	public List<BiderBeen> getAllBids() throws AdminException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String approveBid(int BId) throws AdminException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<BiderBeen> getAllApprovedBids() throws AdminException {
		// TODO Auto-generated method stub
		return null;
	}

}
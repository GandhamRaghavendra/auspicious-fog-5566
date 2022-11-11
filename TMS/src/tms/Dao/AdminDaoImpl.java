package tms.Dao;

import java.util.List;

import tms.Been.BiderBeen;
import tms.Been.ProjectBeen;
import tms.Been.VendorBeen;
import tms.Exception.AdminException;
import tms.Exception.VendorException;

public class AdminDaoImpl implements AdminDao{

	@Override
	public void adminLogin(String mail, int pass) throws AdminException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public String addProject(ProjectBeen p) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String removeProject(int PId) throws AdminException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String addVendor(VendorBeen v) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String removeVendor(int VId) throws VendorException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<ProjectBeen> getAllProjects() throws AdminException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<VendorBeen> getAllVendors() throws VendorException {
		// TODO Auto-generated method stub
		return null;
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

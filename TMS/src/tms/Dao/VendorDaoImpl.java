package tms.Dao;

import java.util.List;

import tms.Been.BiderBeen;
import tms.Been.ProjectBeen;
import tms.Been.VendorBeen;
import tms.Exception.VendorException;

public class VendorDaoImpl implements VendorDao{

	@Override
	public VendorBeen vendorLogin(String mail, int pass) throws VendorException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String vendorRegistration(VendorBeen v) throws VendorException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public VendorBeen updateVendorDetails(int Vid, int pass, VendorBeen v) throws VendorException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<ProjectBeen> getAllProjects() throws VendorException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String BidOnProject(BiderBeen b) throws VendorException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<BiderBeen> getAllApprovedBids() throws VendorException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String updateBidAmount(int BId, int pass, int NewBid) throws VendorException {
		// TODO Auto-generated method stub
		return null;
	}

}

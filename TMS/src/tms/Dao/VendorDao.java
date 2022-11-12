package tms.Dao;

import java.util.List;

import tms.Been.BiderBeen;
import tms.Been.ProjectBeen;
import tms.Been.VendorBeen;
import tms.Exception.VendorException;

public interface VendorDao {
public VendorBeen vendorLogin(String mail,int pass) throws VendorException;

public boolean vendorRegistration(VendorBeen v) throws VendorException;

public VendorBeen getVendor(String mail,int pass) throws VendorException;

public VendorBeen updateVendorDetails(int Vid,int pass,VendorBeen v) throws VendorException;

public List<ProjectBeen> getAllProjects() throws VendorException;

public String BidOnProject(BiderBeen b) throws VendorException;

public String updateBidAmount(int BId,int NewBid) throws VendorException;
}
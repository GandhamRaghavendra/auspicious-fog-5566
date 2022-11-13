package tms.Dao;

import java.util.List;

import tms.Been.BiderBeen;
import tms.Been.ProjectBeen;
import tms.Been.VendorBeen;
import tms.Exception.AdminException;
import tms.Exception.VendorException;

public interface AdminDao {
	
public boolean adminLogin(String mail,int pass) throws AdminException;

public void getAdmin(String mail,int pass) throws AdminException;
	
public String addProject(ProjectBeen p);

public String removeProject(String PId) throws AdminException;

public String addVendor(VendorBeen v);

public String removeVendor(int VId) throws VendorException;

public List<ProjectBeen> getAllProjects() throws AdminException;

public List<VendorBeen> getAllVendors() throws VendorException;

public List<BiderBeen> getAllBids() throws AdminException;

public String approveBid(String Pid) throws AdminException;

public List<BiderBeen> getAllApprovedBids() throws AdminException;

}

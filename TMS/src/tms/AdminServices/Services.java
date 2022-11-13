package tms.AdminServices;

import java.util.List;
import java.util.Scanner;

import tms.Been.BiderBeen;
import tms.Been.ProjectBeen;
import tms.Been.VendorBeen;
import tms.Dao.AdminDaoImpl;
import tms.Exception.AdminException;
import tms.Exception.VendorException;

public class Services {
	public static void addProject() {
		AdminDaoImpl Adao = new AdminDaoImpl();
		
		Scanner s=new Scanner(System.in);
		
		System.out.println("Enter Project Id");
		String pid=s.next();
		
		System.out.println("Enter Project Name");
		String pname=s.next();
		
		System.out.println("Enter Type Of Project");
		String ptype=s.next();
		
		System.out.println("Enter Base Price Of the Project");
		int price=s.nextInt();
		
		System.out.println("Enter Project Desc");
		String desc=s.next();
		
		System.out.println("Enter Project Location");
		String loc=s.next();
		
		System.out.println("Enter DeadLine Date");
		System.out.println("Please Enter The Date in YYYY-MM-DD Formate");
		
		String date=s.next();
		
		String mes = Adao.addProject(new ProjectBeen(pid, pname, ptype, price, desc, loc, date));
		
		System.out.println(mes);
		
		// s.close();
		
	}
	
	public static void removeProject() {
        AdminDaoImpl Adao = new AdminDaoImpl();
		
		Scanner s=new Scanner(System.in);
		System.out.println("Enter Project Id To Delete");
		String pid=s.next();
		
		try {
			String mes = Adao.removeProject(pid);
			System.out.println(mes);
		} 
		catch (AdminException e) {
			System.out.println(e.getMessage());
		}
		// s.close();
		
	}
	
	public static void addVendor() {
        AdminDaoImpl Adao = new AdminDaoImpl();
		
		Scanner s=new Scanner(System.in);
		System.out.println("Enter Name");
		String name=s.next();
		
		System.out.println("Enter Email");
		String mail=s.next();
		
		System.out.println("Enter Pass");
		int pass=s.nextInt();
		
		System.out.println("Enter Company Name");
		String cname=s.next();
		
		System.out.println("Enter Address");
		String add=s.next();
		
		String mes = Adao.addVendor(new VendorBeen(0, name, mail, pass, cname, add));
		
		System.out.println(mes);
		
		// s.close();
		
	}
	
	public static void removeVendor() {
        AdminDaoImpl Adao = new AdminDaoImpl();
		
		Scanner s=new Scanner(System.in);
		
		System.out.println("Enter Vendor Id");
	    int vid=s.nextInt();
	    
	    try {
			String mes = Adao.removeVendor(vid);
			System.out.println(mes);
		} 
	    catch (VendorException e) {
			System.out.println(e.getMessage());
		}
	    // s.close();	
	}
	
	public static void getAllProjects() {
		AdminDaoImpl Adao = new AdminDaoImpl();
		
		try {
			List<ProjectBeen> allProjects = Adao.getAllProjects();
			
			allProjects.forEach(e->System.out.println(e));
			
		} catch (AdminException e) {
			System.out.println(e.getMessage());
		}
	}
	
	public static void getAllVendors() {
		AdminDaoImpl Adao = new AdminDaoImpl();
		
		try {
			List<VendorBeen> allVendors = Adao.getAllVendors();
			
			allVendors.forEach(e->System.out.println(e));
			
		} catch (VendorException e) {
		  System.out.println(e.getMessage());
		}
	}
	
	public static void getAllBids(){	
		AdminDaoImpl Adao = new AdminDaoImpl();
		
		try {
			List<BiderBeen> allBids = Adao.getAllBids();
			allBids.forEach(e->System.out.println(e));
			
		} 
		catch (AdminException e) {
			System.out.println(e.getMessage());
		}
	}
	
	public static void approveBid() {
        AdminDaoImpl Adao = new AdminDaoImpl();
		
		Scanner s=new Scanner(System.in);
		System.out.println("Enter Project Id");
		String pid=s.next();
		
		try {
			String mes = Adao.approveBid(pid);
			System.out.println(mes);
		}
		catch (AdminException e) {
			System.out.println(e.getMessage());
		}
	// s.close();	
	}
	
	public static void getAllApprovedBids() {
        AdminDaoImpl Adao = new AdminDaoImpl();
        
        try {
			List<BiderBeen> allApprovedBids = Adao.getAllApprovedBids();
			allApprovedBids.forEach(e->System.out.println(e));
			
		} catch (AdminException e) {
			System.out.println(e.getMessage());
		}
	}
	
	public static void getAdmin() {
        AdminDaoImpl Adao = new AdminDaoImpl();
        
        Scanner s=new Scanner(System.in);
        
        System.out.println("Enter Email");
        String mail=s.next();
        
        System.out.println("Enter Pass");
        int pass=s.nextInt();
        
        try {
			Adao.getAdmin(mail, pass);
		} catch (AdminException e) {
			System.out.println(e.getMessage());
		}
        
      // s.close();
        }	
}


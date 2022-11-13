package tms.Usecases;

import java.util.Scanner;

import tms.Been.VendorBeen;
import tms.Dao.*;
import tms.Exception.VendorException;
import tms.Main.Application;
import tms.Main.Vendor;

public class VendorLoginUsecase {

	public static void main(String[] args) {
		VendorDao vDao = new VendorDaoImpl();
		
		Scanner s=new Scanner(System.in);
		System.out.println("Enter Your Registered Mail");
		String mail=s.next();
		
		System.out.println("Enter Your Pass");
		int pass=s.nextInt();
		
//		s.close();
		
		try {
			VendorBeen vendor = vDao.vendorLogin(mail, pass);
			
			System.out.println("\nCongrats " + vendor.getName() + " You logged in sucessfully.");
			System.out.println(vendor);
			Vendor.main(null);
			
		} 
		catch (VendorException e) {
			System.out.println(e.getMessage());
			Application.main(null);
		}
		

	}

}

package tms.Usecases;

import java.util.Scanner;

import tms.Been.VendorBeen;
import tms.Dao.*;
import tms.Exception.VendorException;

public class UpdateVendorDetailsUsecase {

	public static void main(String[] args) {
		VendorDao vDao = new VendorDaoImpl();
		
		Scanner s=new Scanner(System.in);
		
		System.out.println("Enter Vendor Id");
		int Id=s.nextInt();
		
		System.out.println("Enter Old Pass");
		int oldPass=s.nextInt();
		
		System.out.println("Enter New Name");
		String name=s.next();
		
		System.out.println("Enter New Pass");
		int newPass=s.nextInt();
	
		System.out.println("Enter New Mail");
		String mail=s.next();
		
		System.out.println("Enter New CName");
		String cname=s.next();
		
		System.out.println("Enter New Address");
		String add=s.next();
		
//		s.close();
		
		try {
			VendorBeen newv = vDao.updateVendorDetails(Id,oldPass,new VendorBeen(0, name, mail, newPass, cname, add));
			System.out.println("New Updated Data");
			System.out.println(newv);
			
		} 
		catch (VendorException e) {
			System.out.println(e.getMessage());
			
		}
		
		
		

	}

}

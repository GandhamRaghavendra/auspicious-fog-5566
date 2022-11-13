package tms.Usecases;

import java.util.Scanner;

import tms.Been.VendorBeen;
import tms.Dao.*;
import tms.Exception.VendorException;

public class VendorRegisterUsecase {

	public static void main(String[] args) {
		VendorDao vDao = new VendorDaoImpl();
		Scanner s=new Scanner(System.in);
		
		 System.out.println("Enter Name");
		 String name=s.next();
		 
		 System.out.println("Enter Mailid");
		 String mail=s.next();
		 
		  System.out.println("Enter Pass");
		  int pass=s.nextInt();
		  
		  System.out.println("Enter Company Name");
		  String cname=s.next();
		  
		  System.out.println("Enter Address");
		  String add=s.next();
		  
//		  s.close();
		  
		  try {
			boolean mes = vDao.vendorRegistration(new VendorBeen(0, name, mail, pass, cname, add));
			
			if(mes) System.out.println("Registor Successfully");
			
			else System.out.println("Failed");
		} 
		  catch (VendorException e) {
			System.out.println(e.getMessage());
		}
		 
	}

}

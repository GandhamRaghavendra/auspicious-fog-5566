package tms.Main;

import java.util.Scanner;

import tms.Usecases.AdminLoginUsecase;
import tms.Usecases.VendorLoginUsecase;
import tms.Usecases.VendorRegisterUsecase;

public class Application {

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		
		System.out.println("*****************************************");

		System.out.println("Welcome to Raghu's Tneder Management System");

		System.out.println("*****************************************");


		System.out.println("\nLogin as a Admin/Customer to continue : ");
		System.out.println("1. Login as Admin");
		System.out.println("2. Login as Vendor");
		System.out.println("3. Register as a Vendor.");
		System.out.println("85. Exit");

		System.out.print("\nEnter choice : ");
		
		int choice = s.nextInt();
		
		switch (choice) {
		case(1):{
			AdminLoginUsecase.AdminLogin();
			break;
		}
		case(2):{
			VendorLoginUsecase.main(null);
			break;
		}
	    case(3):{
			VendorRegisterUsecase.main(null);
			Application.main(null);
			break;
		}
	    case(85):{
			System.out.println("Thank You For Using Our Application");
			break;
		}
	    default :{
	    	System.out.println("Chose Curctly");
	    	Application.main(null);
	    	break;
	    }
		}
	}

}

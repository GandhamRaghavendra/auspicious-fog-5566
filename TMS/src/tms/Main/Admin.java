package tms.Main;

import java.util.Scanner;

import tms.AdminServices.Services;

public class Admin {
	public static void main(String[] args) {
        Scanner s=new Scanner(System.in);
		
		System.out.println("<><><><>---- Admin Menu ----<><><><>\n");
		System.out.println("1. Add New Project");
		System.out.println("2. Remove Project");
		System.out.println("3. Add New Vendor");
		System.out.println("4. Remove Vendor");
		System.out.println("5. Get All Project");
		System.out.println("6. Get All Vendors");
		System.out.println("7. Get All Bids");
		System.out.println("8. Approve Bid");
		System.out.println("9. Get All Approved Bids");
		System.out.println("10. Get Profile Details");
		System.out.println("99. Return to main menu.");
		
		System.out.print("\nEnter choice : ");
		int choice = s.nextInt();
		
		switch(choice) {
		case 1:
	        Services.addProject();
	        Admin.main(null);
			break;
		case 2:
			Services.removeProject();
			Admin.main(null);
			break;
		case 3:
			Services.addVendor();
			Admin.main(null);
			break;
		case 4:
			Services.removeVendor();
			Admin.main(null);
			break;
		case 5:
			Services.getAllProjects();
			Admin.main(null);
			break;
		case 6:
			Services.getAllVendors();
			Admin.main(null);
			break;
		case 7:
			Services.getAllBids();
			Admin.main(null);
			break;
		case 8:
			Services.approveBid();
			Admin.main(null);
			break;
		case 9:
			Services.getAllApprovedBids();
			Admin.main(null);
			break;
		case 10:
			Services.getAdmin();
			Admin.main(null);
			break;
		case 99:
			System.out.println("Returned To Main Menu");
			Application.main(null);
			break;
		default :
			System.out.println("Chose Right Option");
			Admin.main(null);
			break;
		}
//		s.close();
	}
}

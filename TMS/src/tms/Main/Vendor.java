package tms.Main;

import java.util.Scanner;

import tms.Usecases.BidOnProjectUsecase;
import tms.Usecases.UpdateVendorDetailsUsecase;
import tms.Usecases.getAllProjectsUsecase;
import tms.Usecases.updateBidAmountUsecase;

public class Vendor {

	public static void main(String[] args) {
		Scanner s=new Scanner(System.in);
		
		System.out.println("<><><><>---- Customer Menu ----<><><><>\n");
		System.out.println("1. Update Vendor Profile");
		System.out.println("2. Get All Available Project");
		System.out.println("3. Bid On Project");
		System.out.println("4. Update Bid Amount");
		System.out.println("99. Return to main menu.");
		
		System.out.print("\nEnter choice : ");
		int choice = s.nextInt();
	
		switch(choice) {
		case 1:
			UpdateVendorDetailsUsecase.main(null);
			break;
		case 2:
			getAllProjectsUsecase.main(null);
			
			break;
		case 3:
			BidOnProjectUsecase.main(null);
			break;
		case 4:
			updateBidAmountUsecase.main(null);
			break;
		case 99:
			System.out.println("Returned To Main Menu");
			Application.main(null);
			break;
		default:
			System.out.println("Chose Right Option");
			Vendor.main(null);
			break;	
		}
		
		s.close();
	}

}

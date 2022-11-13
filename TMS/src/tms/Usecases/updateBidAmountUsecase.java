package tms.Usecases;

import java.util.Scanner;

import tms.Dao.VendorDao;
import tms.Dao.VendorDaoImpl;
import tms.Exception.VendorException;

public class updateBidAmountUsecase {

	public static void main(String[] args) {
        VendorDao vdao = new VendorDaoImpl();
		
		Scanner s=new Scanner(System.in);
		System.out.println("Enter Bid Id");
		int Bid =s.nextInt();
		
		System.out.println("Enter New Amount");
		int newAmount=s.nextInt();
		
//		s.close();
		
		try {
			String mes = vdao.updateBidAmount(Bid,newAmount);
			System.out.println(mes);
		} catch (VendorException e) {
			System.out.println(e.getMessage());
		}
		
		

	}

}

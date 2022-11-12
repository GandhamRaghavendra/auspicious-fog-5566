package tms.Usecases;

import java.util.Scanner;

import tms.Been.BiderBeen;
import tms.Dao.VendorDao;
import tms.Dao.VendorDaoImpl;
import tms.Exception.VendorException;

public class BidOnProjectUsecase {

	public static void main(String[] args) {
		VendorDao vdao = new VendorDaoImpl();
		
		Scanner s=new Scanner(System.in);
	    
		System.out.println("Enter Vendor Id");
		int Vid =s.nextInt();
		
		System.out.println("Enter Project Id");
		String Pid=s.next();
		
		System.out.println("Enter BidAmount");
		int Amount=s.nextInt();
		
		s.close();
		
		try {
			String mes = vdao.BidOnProject(new BiderBeen(0, Vid, Pid, Amount,null));
			System.out.println(mes);
		} catch (VendorException e) {
			System.out.println(e.getMessage());
		}

	}

}

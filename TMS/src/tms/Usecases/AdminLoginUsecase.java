package tms.Usecases;

import java.util.Scanner;

import tms.Dao.*;
import tms.Exception.AdminException;
import tms.Main.Admin;
import tms.Main.Application;

public class AdminLoginUsecase {

	public static void AdminLogin() {
		AdminDao dao = new AdminDaoImpl();
		
		Scanner s=new Scanner(System.in);
		System.out.println("Enter Your Registered Mail");
		String mail=s.next();
		
		System.out.println("Enter Your Pass(NO Characters Allowed)");
		int pass=s.nextInt();
		
		
		try {
			boolean mes = dao.adminLogin(mail, pass);
			if(mes) {
				System.out.println(">>>>>Welcome Admin<<<<<");
				dao.getAdmin(mail, pass);
				Admin.main(null);				
			}
			else {
				System.out.println("Wrong Credential");
				Application.main(null);
			}
		} 
		catch (AdminException e) {
			System.out.println(e.getMessage());
		}

//		s.close();
	}

}

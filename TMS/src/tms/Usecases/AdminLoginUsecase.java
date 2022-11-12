package tms.Usecases;

import java.util.Scanner;

import tms.Dao.*;
import tms.Exception.AdminException;

public class AdminLoginUsecase {

	public static void main(String[] args) {
		AdminDao dao = new AdminDaoImpl();
		
		Scanner s=new Scanner(System.in);
		System.out.println("Enter Your Registered Mail");
		String mail=s.next();
		
		System.out.println("Enter Your Pass");
		int pass=s.nextInt();
		
		s.close();
		
		try {
			boolean mes = dao.adminLogin(mail, pass);
			if(mes) {
				dao.getAdmin(mail, pass);
				
				
			}
			else {
				
			}
		} 
		catch (AdminException e) {
			System.out.println(e.getMessage());
		}

	}

}

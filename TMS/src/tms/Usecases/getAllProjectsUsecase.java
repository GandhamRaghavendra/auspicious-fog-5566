package tms.Usecases;

import java.util.List;

import tms.Been.ProjectBeen;
import tms.Dao.*;
import tms.Exception.VendorException;

public class getAllProjectsUsecase {

	public static void main(String[] args) {
		VendorDao vdao = new VendorDaoImpl();
		
		try {
			List<ProjectBeen> allProjects = vdao.getAllProjects();
			
			allProjects.forEach(e-> System.out.println(e));
			
		} 
		catch (VendorException e) {
			System.out.println(e.getMessage());
		}

	}

}

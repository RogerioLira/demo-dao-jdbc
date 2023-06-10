package application;

import java.util.List;
import java.util.Scanner;

import model.dao.DaoFactory;
import model.dao.DepartmentDao;

import model.entities.Department;


public class Program2 {

	public static void main(String[] args) {
	
		Scanner sc = new Scanner(System.in);
		
		DepartmentDao departmentDao = DaoFactory.createDepartmentDao();
		
        Department department = departmentDao.findById(3);
        System.out.println("===   Test1: Department findByID  ===");
        System.out.println(department);
        
        
        System.out.println("\n===   Test2: Department findAll  ===");
   
        List<Department> list = departmentDao.findAll();
        
        for (Department obj : list) {
        	System.out.println(obj);
        }
        
        System.out.println("\n===   Test4: Department insert  ===");
        Department newDepartment = new Department(null, "Foods");
	    departmentDao.insert(newDepartment);
	    System.out.println("Inserted! New id = "+ newDepartment.getId());
	
	    System.out.println("\n===   Test5: Department update  ===");
	    department = departmentDao.findById(1);
	    department.setName("Test");
	    departmentDao.update(department);
	    System.out.println("Update Completed!");
	    
	    System.out.println("\n===   Test6: Department delete  ===");
	    System.out.print("Enter id for delete test: ");
	    int id = sc.nextInt();
	    departmentDao.deleteById(id);
	    System.out.println("Delete completed! ");
	    
	    sc.close();
	}

}

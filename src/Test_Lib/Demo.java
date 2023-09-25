package Test_Lib;

import java.util.UUID;

import org.apache.commons.lang3.RandomStringUtils;

import Entities.Employees;
import Models.Auth.SendMailModel;
import Models.Employees.EmployeeModel;

public class Demo {

	public static void main(String[] args) {

//		SendMailModel.sendConfirmEmail("nguyenminhthan1308@gmail.com", "test412300asdjaskdjkasjdlsacmlxzmclzxcx");
		String string = RandomStringUtils.random(10, true, true);
		System.out.println(string);
//		UUID uuid = UUID.randomUUID();
//		System.out.println(uuid);
		EmployeeModel employeeModel = new EmployeeModel();
		Employees employees = employeeModel.FindByEmployeeName("admin");
		System.out.println(employees.getStart_working());
		
	}

}

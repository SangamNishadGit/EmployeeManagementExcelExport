package com.sangam.runner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.sangam.bean.Employee;
import com.sangam.repo.EmployeeRepository;
import com.sangam.service.IEmployeeService;

@Component
public class TestRunner implements CommandLineRunner {

	@Autowired
	private IEmployeeService services;

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		Employee emp = new Employee();
		emp.setEmpName("Sangam");
		emp.setEmpFee(12.34);
		emp.setEmpCourse("fsdf");
		emp.setEmpFeeDisc(6.67);
		emp.setEmpFeeGst(67.67);
		
		
		services.saveEmployee(emp);
	}

}

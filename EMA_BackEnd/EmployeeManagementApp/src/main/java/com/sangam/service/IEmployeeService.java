package com.sangam.service;

import java.io.IOException;
import java.util.List;

import com.sangam.bean.Employee;

import jakarta.servlet.http.HttpServletResponse;

public interface IEmployeeService {

	Integer saveEmployee(Employee emp);

	void updateEmployee(Employee emp);

	void deleteEmployee(Integer id);

	Employee getEmployeeById(Integer id);

	List<Employee> getListOfEmployees();

}

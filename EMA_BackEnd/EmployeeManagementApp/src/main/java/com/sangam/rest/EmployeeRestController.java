package com.sangam.rest;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sangam.bean.Employee;
import com.sangam.service.IEmployeeService;
import com.sangam.util.ExcelExportService;

@RestController
@RequestMapping("/employee")
@CrossOrigin(origins = "http://localhost:4200")
public class EmployeeRestController {

	@Autowired
	private IEmployeeService service;
	
	@Autowired
	private ExcelExportService excelExport;

	// 1. save
	@PostMapping("/create")
	public ResponseEntity<String> saveEmployee(@RequestBody Employee employee) {

		Integer id = service.saveEmployee(employee);
		String body = "Employee saved with Id : " + id;
		return ResponseEntity.ok(body);

	}

	// 2. fetch all
	@GetMapping("/all")
	public ResponseEntity<List<Employee>> getListOfEmployee() {
		List<Employee> lEmployee = service.getListOfEmployees();
		return ResponseEntity.ok(lEmployee);
	}

	// 3. fetch one

	@GetMapping("/one/{id}")
	public ResponseEntity<Employee> getStudentById(@PathVariable Integer id) {
		Employee emp = service.getEmployeeById(id);
		return ResponseEntity.ok(emp);
	}
	// 4. delete

	@DeleteMapping("/remove/{id}")
	public ResponseEntity<String> deleteEmployee(@PathVariable Integer id) {
		service.deleteEmployee(id);
		String body = "Employee Deleted : " + id;
		return ResponseEntity.ok(body);
	}

	// 5. update
	@PutMapping("/update")
	public ResponseEntity<String> updateEmployee(@RequestBody Employee emp) {
		service.updateEmployee(emp);
		String body = "Employee Updated : " + emp.getEmpId();
		return ResponseEntity.ok(body);
	}
	
	@GetMapping(value = "/excel")
	public ResponseEntity<byte[]> downloadXlsFile() throws IOException {
	    byte[] fileBytes = excelExport.excelExport();

	    HttpHeaders headers = new HttpHeaders();
	    headers.setContentType(MediaType.APPLICATION_OCTET_STREAM);
	    headers.setContentDispositionFormData("attachment", "data.xls");

	    return ResponseEntity.ok()
	            .headers(headers)
	            .body(fileBytes);
	}

}

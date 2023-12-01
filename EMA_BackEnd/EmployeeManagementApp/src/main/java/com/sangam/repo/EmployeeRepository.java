package com.sangam.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sangam.bean.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
//dynamic proxy class + object
}

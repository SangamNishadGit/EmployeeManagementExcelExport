package com.sangam.util;

import org.springframework.stereotype.Component;

import com.sangam.bean.Employee;


public interface EmployeeUtils {

	public static void calculationDetails(Employee emp) {
		// calculation
		// JDK 10 LocalVariable Type Interface

		var fee = emp.getEmpFee();
		var disc = fee * 10 / 100.0;
		var gst = fee * 12 / 100.0;

		emp.setEmpFeeDisc(disc);
		emp.setEmpFeeGst(gst);
	}

}

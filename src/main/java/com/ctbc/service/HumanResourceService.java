package com.ctbc.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ctbc.dao.DeptDAO;
import com.ctbc.dao.EmpDAO;

@Service
public class HumanResourceService {

	@Autowired
	private DeptDAO deptDAO;
	
	@Autowired
	private EmpDAO empDAO;
	
}

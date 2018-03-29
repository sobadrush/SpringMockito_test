package com.ctbc.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ctbc.dao.DeptDAO;
import com.ctbc.dao.EmpDAO;
import com.ctbc.vo.DeptVO;

@Service
public class HumanResourceService {

	@Autowired
	private DeptDAO deptDAO;
	
	@Autowired
	private EmpDAO empDAO;
	
	
	public void dismissDept(int empId) {
		
		int deptNo = empDAO.getDeptNoByEmpId(empId);
		DeptVO deptVO = deptDAO.getDeptById(deptNo);
		System.out.println("該員工編號對應的部門為 : " + deptVO);
		System.out.println("======= 解散此部門 ======");
	}
}

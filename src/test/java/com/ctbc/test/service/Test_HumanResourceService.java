package com.ctbc.test.service;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.ctbc.dao.EmpDAO;
import com.ctbc.service.HumanResourceService;

import _00_config.RootConfig;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = { RootConfig.class })
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class Test_HumanResourceService {

	@InjectMocks 
	@Autowired  
    private HumanResourceService humanResourceService;
  
    @Mock  
    private EmpDAO empDAO; 
  

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		System.out.println("================= mockito測試 ===================");
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
		System.out.println("=============== setUp() =================");
		MockitoAnnotations.initMocks(this);  ;
		Mockito.when(empDAO.getDeptNoByEmpId(Mockito.any(Integer.class))).thenReturn(10);
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void test_001() {
		System.out.println("============ test_001 ============");
		humanResourceService.dismissDept(10);
	}

}

package com.ctbc.test.jdbctemplate;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcOperations;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.ctbc.vo.DeptVO;

import _00_config.RootConfig;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = { RootConfig.class })
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class Test_jdbcTemplate {

	@Autowired
	private JdbcOperations jdbcTemp;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void test_001() {
		System.out.println(jdbcTemp);
		List<DeptVO> dList = jdbcTemp.query("SELECT * FROM z40180_deptTB", new RowMapper<DeptVO>() {
			@Override
			public DeptVO mapRow(ResultSet rs, int idx) throws SQLException {
				DeptVO vo = new DeptVO();
				vo.setDeptNo(rs.getInt("deptno"));
				vo.setDeptName(rs.getString("dname"));
				vo.setDeptLoc(rs.getString("loc"));
				return vo;
			}
		});

		for (DeptVO deptVO : dList) {
			System.out.println(deptVO.toString());
		}
	}

}

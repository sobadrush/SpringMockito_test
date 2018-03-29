package com.ctbc.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.ctbc.vo.DeptVO;

@Repository
public class DeptDAO {

	@Autowired
	private JdbcTemplate jdbc;

	public DeptVO getDeptById(Integer deptId) {
		DeptVO deptVO = jdbc.queryForObject("SELECT * FROM z40180_deptTB WHERE deptno = ? ", new DeptRowMApper(), deptId);
		return deptVO;
	}

	private static class DeptRowMApper implements RowMapper<DeptVO> {
		@Override
		public DeptVO mapRow(ResultSet rs, int rowNum) throws SQLException {
			DeptVO vo = new DeptVO();
			vo.setDeptNo(rs.getInt("deptno"));
			vo.setDeptName(rs.getString("dname"));
			vo.setDeptLoc(rs.getString("loc"));
			return vo;
		}
	}

}

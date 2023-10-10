package com.student.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.student.model.Student;

@Repository
public class StudentDaoImpl implements StudentDao{

	@Autowired
	JdbcTemplate jdbc;
	@Override
	public List<Student> loadStudents() {
		List<Student> studentList = new ArrayList<Student>();
		
		String sql = "select * from students";
		
		RowMapper<Student> rowMapper = new RowMapper<Student>() {

			@Override
			public Student mapRow(ResultSet rs, int rowNum) throws SQLException {
				
				Student student = new Student();
				student.setId(rs.getInt("id"));
				student.setName(rs.getString("name"));
				student.setMobile(rs.getLong("mobile"));
				student.setCountry(rs.getString("country"));
				studentList.add(student);
				return student;		}
			
		};
		
		jdbc.query(sql, rowMapper);
		
		
		return studentList;
	}

}

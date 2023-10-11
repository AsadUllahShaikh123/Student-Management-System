package com.student.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.student.model.Student;

@Repository
public class StudentDaoImpl implements StudentDao {

	@Autowired
	JdbcTemplate jdbc;

	private RowMapper<Student> getRowMapper() {
		RowMapper<Student> rowMapper = new RowMapper<Student>() {

			@Override
			public Student mapRow(ResultSet rs, int rowNum) throws SQLException {

				Student student = new Student();
				student.setId(rs.getInt("id"));
				student.setName(rs.getString("name"));
				student.setMobile(rs.getLong("mobile"));
				student.setCountry(rs.getString("country"));

				return student;
			}

		};
		return rowMapper;
	}

	@Override
	public List<Student> loadStudents() {

		String sql = "select * from students";

		List<Student> studentList = jdbc.query(sql, getRowMapper());

		return studentList;
	}

	@Override
	public void saveStudent(Student student) {

		Object[] sqlParameters = { student.getName(), student.getMobile(), student.getCountry() };

		String sql = "insert into students(name,mobile,country) values(?,?,?)";

		jdbc.update(sql, sqlParameters);
		System.out.println("1.. record updated ");

	}

	public Student getStudent(int id) {

		String sql = "select * from students where id = ? ";

		Student student = jdbc.queryForObject(sql, getRowMapper(), id);

		return student;
	}

}

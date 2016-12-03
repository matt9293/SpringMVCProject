package kr.ac.hansung.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import kr.ac.hansung.model.Subject;

public class SubjectMapper implements RowMapper<Subject> {
	public Subject mapRow(ResultSet rs, int rowNum) throws SQLException {

		Subject subject = new Subject();
		
		subject.setYear(rs.getInt("year"));
		subject.setSemester(rs.getInt("semester"));
		subject.setCode(rs.getString("code"));
		subject.setName(rs.getString("name"));
		subject.setClassify(rs.getString("classify"));
		subject.setGrade(rs.getInt("grade"));

		
		
		return subject;
	}
}

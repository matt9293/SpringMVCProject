package kr.ac.hansung.dao;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import kr.ac.hansung.model.Subject;

@Repository
public class SubjectDAO {

	private JdbcTemplate jdbcTemplateObject;

	@Autowired
	public void setDataSource(DataSource dataSource) {
		this.jdbcTemplateObject = new JdbcTemplate(dataSource);
	}

	public int getRowCount() {
		String sqlStatement = "select count(*) from subject";
		return jdbcTemplateObject.queryForObject(sqlStatement, Integer.class);
	}

	// querying and returning a single object
	public Subject getSubject(String code) {
		String sqlStatement = "select * from subject where code=?";

		return jdbcTemplateObject.queryForObject(sqlStatement, new Object[] { code }, new SubjectMapper());
	}

	// querying and returning multiple object
	public List<Subject> getSubject() {
		String sqlStatement = "select * from subject";
		return jdbcTemplateObject.query(sqlStatement, new SubjectMapper());
	}

	public List<Subject> getYearSemesterDetail(int year, int semester) {
		String sqlStatement = "select * from subject where year=" + year + " and semester=" + semester;
		return jdbcTemplateObject.query(sqlStatement, new SubjectMapper());
	}

	public List<Subject> getNewSemester() {
		String sqlStatement = "select * from subject where year=2017";
		return jdbcTemplateObject.query(sqlStatement, new SubjectMapper());
	}

	public boolean insert(Subject Subject) {
		int year = Subject.getYear();
		int semester = Subject.getSemester();
		String code = Subject.getCode();
		String name = Subject.getName();
		String classify = Subject.getClassify();
		int grade = Subject.getGrade();

		String sqlStatement = "insert into subject (year, semester, code, name, classify, grade) values (?,?,?,?,?,?)";
		return (jdbcTemplateObject.update(sqlStatement,
				new Object[] { year, semester, code, name, classify, grade}) == 1);
	}

	public boolean update(Subject Subject) {
		int year = Subject.getYear();
		int semester = Subject.getSemester();
		String code = Subject.getCode();
		String name = Subject.getName();
		String classify = Subject.getClassify();
		int grade = Subject.getGrade();

		String sqlStatement = "update subject set year=?, semester=?, name=?, classify=?, grade=? where code=?";
		return (jdbcTemplateObject.update(sqlStatement,
				new Object[] { year, semester, code, name, classify, grade }) == 1);
	}

	public boolean delete(String code) {
		String sqlStatement = "delete from subject where code=?";
		return (jdbcTemplateObject.update(sqlStatement, new Object[] { code }) == 1);
	}
}

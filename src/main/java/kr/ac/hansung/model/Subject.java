package kr.ac.hansung.model;

import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;

public class Subject {

	private int year;
	private int semester;

	@NotEmpty(message = "The code cannot be empty")
	private String code = "";

	@Size(min = 1, max = 50, message = "Name must be between 1 and 50 charaters")
	private String name = "";

	@Size(min = 1, max = 10, message = "Section must be between 1 and 10 charaters")
	private String classify = "";

	private int grade;

	public Subject() {

	}

	public Subject(String classify) {
		this.classify = classify;
	}

	public Subject(int year, int semester, String classify, int grade) {
		this.year = year;
		this.semester = semester;
		this.classify = classify;
		this.grade = grade;
	}

	public Subject(int year, int semester, String code, String name,
			String classify, int grade) {
		this.year = year;
		this.semester = semester;
		this.code = code;
		this.name = name;
		this.classify = classify;
		this.grade = grade;
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

	public int getSemester() {
		return semester;
	}

	public void setSemester(int semester) {
		this.semester = semester;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getClassify() {
		return classify;
	}

	public void setClassify(String classify) {
		this.classify = classify;
	}

	public int getGrade() {
		return grade;
	}

	public void setGrade(int grade) {
		this.grade = grade;
	}

	@Override
	public String toString() {
		return "Subject [year=" + year + ", semester=" + semester + ", code=" + code + ", name=" + name + ", classify="
				+ classify + ", grade=" + grade + "]";
	}

}

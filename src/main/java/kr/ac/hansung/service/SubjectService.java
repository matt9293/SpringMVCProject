package kr.ac.hansung.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.ac.hansung.dao.SubjectDAO;
import kr.ac.hansung.model.Subject;

@Service
public class SubjectService {

	private SubjectDAO subjectDao;
	
	@Autowired
	public void setSubjectDAO(SubjectDAO subjectDao) {
		this.subjectDao = subjectDao;
	}
	
	public List<Subject> getCurrent() {
			
		return subjectDao.getSubject();
	}
	

	public void insert(Subject subject) {
		subjectDao.insert(subject);
	}
	
	public List<Subject> getNumOne(int year, int semester) {
		return subjectDao.getYearSemesterDetail(year, semester);
	}
	
	public List<Subject> getNewYearHaksa() {
		return subjectDao.getNewSemester();
	}
	
}

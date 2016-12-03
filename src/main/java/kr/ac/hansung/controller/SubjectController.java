package kr.ac.hansung.controller;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.RequestMapping;

import kr.ac.hansung.model.Subject;
import kr.ac.hansung.model.SubjectCalculator;
import kr.ac.hansung.service.SubjectService;

@Controller
public class SubjectController {

	
	private SubjectService subjectService;
	
	@Autowired
	public void setSubjectService(SubjectService subjectService){
		this.subjectService = subjectService;
	}
	
	@RequestMapping("/home")
	public String goHome(Model model) {
		return "home";
	}
	
	@RequestMapping("/semestershow")
	public String showSemester(Model model) {
		SubjectCalculator yearSemester = new SubjectCalculator();
		List<Subject> subjects = subjectService.getCurrent();
		ArrayList<Integer> list = yearSemester.getYearSemesterArray(subjects);
		model.addAttribute("list", list);
		return "semestershow";
	}
	

	@RequestMapping("/sectionshow")
	public String showSection(Model model) {

		SubjectCalculator sc = new SubjectCalculator();
		List<Subject> subjects = subjectService.getCurrent();

		ArrayList<Integer> gradeList = sc.getSectionGrade(subjects);

		model.addAttribute("gradeList", gradeList);
		return "sectionshow";
	}

	@RequestMapping("/registercourse")
	public String registerCourse(Model model) {
		
		model.addAttribute(new Subject());
		
		return "registercourse";
	}
	
	@RequestMapping("/docreate")
	public String doCreate(Model model, @Valid Subject subject, BindingResult result) {
		
		if (result.hasErrors()) {
			System.out.println("Form data does not validate");
			List<ObjectError> errors = result.getAllErrors();
			for (ObjectError error : errors) {
				System.out.println(error.getDefaultMessage());
			}
			return "registercourse";
		}
		
		subjectService.insert(subject);
		
		return "offercreated";
	}

	@RequestMapping("/checkcource")
	public String checkSource(Model model) {
		
		List<Subject> subjects = subjectService.getNewYearHaksa();
		
		model.addAttribute("subject", subjects);
		
		return "checkcource";
	}

	@RequestMapping("/re20121")
	public String connectRe20121(Model model) {
		List<Subject> subject= subjectService.getNumOne(2012, 1);
		model.addAttribute("subjects", subject);
		return "re20121";
	}

	@RequestMapping("/re20122")
	public String connectRe20122(Model model) {
		List<Subject> subject = subjectService.getNumOne(2012, 2);
		model.addAttribute("subjects", subject);
		return "re20122";
	}

	@RequestMapping("/re20151")
	public String connectRe20151(Model model) {
		List<Subject> subject = subjectService.getNumOne(2015, 1);
		model.addAttribute("subjects", subject);
		return "re20151";
	}

	@RequestMapping("/re20152")
	public String connectRe20152(Model model) {
		List<Subject> subject = subjectService.getNumOne(2015, 2);
		model.addAttribute("subjects", subject);
		return "re20152";
	}

	@RequestMapping("/re20161")
	public String connectRe20161(Model model) {
		List<Subject> subject = subjectService.getNumOne(2016, 1);
		model.addAttribute("subjects", subject);
		return "re20161";
	}
	
}

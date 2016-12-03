package kr.ac.hansung.model;

import java.util.ArrayList;
import java.util.List;

public class SubjectCalculator {

	public ArrayList<Integer> getYearSemesterArray(List<Subject> subject) {
		ArrayList<Integer> list = new ArrayList<Integer>();

		int cnt1, cnt2, cnt3, cnt4, cnt5;
		cnt1 = cnt2 = cnt3 = cnt4 = cnt5 = 0;

		for (int i = 0; i < subject.size(); i++) {
			if (subject.get(i).getYear() == 2012
					&& subject.get(i).getSemester() == 1) {

				cnt1 += subject.get(i).getGrade();
			} else if (subject.get(i).getYear() == 2012
					&& subject.get(i).getSemester() == 2) {

				cnt2 += subject.get(i).getGrade();
			} else if (subject.get(i).getYear() == 2015
					&& subject.get(i).getSemester() == 1) {

				cnt3 += subject.get(i).getGrade();
			} else if (subject.get(i).getYear() == 2015
					&& subject.get(i).getSemester() == 2) {

				cnt4 += subject.get(i).getGrade();
			} else if (subject.get(i).getYear() == 2016
					&& subject.get(i).getSemester() == 1) {

				cnt5 += subject.get(i).getGrade();
			}
		}

		list.add(cnt1);
		list.add(cnt2);
		list.add(cnt3);
		list.add(cnt4);
		list.add(cnt5);

		return list;
	}

	public ArrayList<Integer> getSectionGrade(List<Subject> subject) {
		ArrayList<Integer> gradeList = new ArrayList<Integer>();

		int cnt1, cnt2, cnt3, cnt4, cnt5, cnt6, cnt7, cnt8, total;
		cnt1 = cnt2 = cnt3 = cnt4 = cnt5 = cnt6 = cnt7 = cnt8 = total = 0;

		for (int i = 0; i < subject.size(); i++) {
			if (subject.get(i).getClassify().contains("핵교A")) {
				cnt1 += subject.get(i).getGrade();
			} else if (subject.get(i).getClassify().contains("핵교B")) {
				cnt2 += subject.get(i).getGrade();
			} else if (subject.get(i).getClassify().contains("교필")) {
				cnt3 += subject.get(i).getGrade();
			} else if (subject.get(i).getClassify().contains("일교")) {
				cnt4 += subject.get(i).getGrade();
			} else if (subject.get(i).getClassify().contains("전기")) {
				cnt5 += subject.get(i).getGrade();
			} else if (subject.get(i).getClassify().contains("전지")) {
				cnt6 += subject.get(i).getGrade();
			} else if (subject.get(i).getClassify().contains("전선")) {
				cnt7 += subject.get(i).getGrade();
			} else if (subject.get(i).getClassify().contains("인재")) {
				cnt8 += subject.get(i).getGrade();
			}
		}

		total = cnt1 + cnt2 + cnt3 + cnt4 + cnt5 + cnt6 + cnt7 + cnt8;

		gradeList.add(cnt1);
		gradeList.add(cnt2);
		gradeList.add(cnt3);
		gradeList.add(cnt4);
		gradeList.add(cnt5);
		gradeList.add(cnt6);
		gradeList.add(cnt7);
		gradeList.add(cnt8);
		gradeList.add(total);

		return gradeList;
	}
	
	
	
}

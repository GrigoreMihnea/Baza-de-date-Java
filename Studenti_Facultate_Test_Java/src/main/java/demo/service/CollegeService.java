package demo.service;

import demo.dao.CollegeDao;
import demo.entity.StudentEntity;
import demo.entity.CollegeEntity;


public class CollegeService {
	
	public static CollegeDao collegeDao = new CollegeDao();
	
	public static void addCollege(String name, StudentEntity student) {
		
		CollegeEntity college = new CollegeEntity();
		college.setName(name);
		college.setStudent(student);
		
		collegeDao.saveCollege(college);
		
	}

}

package demo;

import java.util.List;

import demo.dao.StudentDao;
import demo.dao.CollegeDao;
import demo.dto.CollegeDto;
import demo.service.StudentService;
import demo.service.CollegeService;

public class HibernateDemo {
	
	public static void main(String[] args) {
		
		StudentService studentService = new StudentService();
		CollegeService collegeService = new CollegeService();
		
		
		StudentDao studentDao = new StudentDao();
		CollegeDao collegeDao = new CollegeDao();
		
		
		System.out.println("College = " + collegeDao.getCollegeById(7));
		
		
		StudentService.addStudent("John", "Smith", true);
		CollegeService.addCollege("IESC", StudentDao.getLatestStudent());
		
		List<CollegeDto> collegelist = CollegeDao.getCollegeList();
		
		
	}

}

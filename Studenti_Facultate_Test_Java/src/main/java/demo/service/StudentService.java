package demo.service;

import demo.dao.StudentDao;
import demo.entity.StudentEntity;

public class StudentService {
	
public static StudentDao studentDao = new StudentDao();
	
	public static void addStudent(String first_name, String last_name, Boolean admission) {
		
		StudentEntity student = new StudentEntity();
		student.setFirst_name(first_name);
		student.setLast_name(last_name);
		student.setAdmission(admission);
		
		studentDao.saveStudentEntity(student);
		
	}

}

package demo.dao;

import org.hibernate.Session;

import demo.entity.StudentEntity;
import demo.utils.HibernateUtil;

public class StudentDao {
	
	public static Session session = HibernateUtil.getSessionFactory().openSession();
	
	public void saveStudentEntity(StudentEntity student) {
		session.beginTransaction();
		
		session.save(student);
		session.getTransaction().commit();
		
		session.evict(student);
		
	}
	
	public static StudentEntity getLatestStudent() {
		StringBuilder sb = new StringBuilder();
		
		sb.append(" select s from ").append(StudentEntity.class.getName()).append(" s order by s.id desc");
		
		StudentEntity result = (StudentEntity) session.createQuery(sb.toString()).setMaxResults(1).uniqueResult();
		
		return result;
		
	}

}

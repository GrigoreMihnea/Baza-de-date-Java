package demo.dao;

import java.util.List;

import org.hibernate.Session;

import demo.entity.CollegeEntity;
import demo.entity.StudentEntity;
import demo.dto.CollegeDto;
import demo.utils.HibernateUtil;

public class CollegeDao {

	public static Session session = HibernateUtil.getSessionFactory().openSession();
	
	public void saveCollege(CollegeEntity college) {
		session.beginTransaction();
		session.save(college);
		
		session.getTransaction().commit();
	}
	
	public CollegeEntity getCollegeById(int collegeId) {
		
		StringBuilder sb = new StringBuilder();
		
		sb.append(" select c from ").append(CollegeEntity.class.getName()).append(" c where c.id = :collegeId ");
		CollegeEntity result = (CollegeEntity) session.createQuery(sb.toString()).setParameter("collegeId", collegeId).uniqueResult();
		 
		return result;
		
	}
	
	@SuppressWarnings("unchecked")
	public static List<CollegeDto> getCollegeList(){
		
		StringBuilder sb = new StringBuilder();
		
		sb.append("select new demo.dto.CollegeDto(s.first_name, s.last_name, s.admission, c.name) ")
        .append(" from ")
        .append(CollegeEntity.class.getName()).append(" c, ")
		.append(StudentEntity.class.getName()).append(" s ")
		.append(" where ")
		.append(" c.student.id = s.id ");
		
		return session.createQuery(sb.toString()).list();
		
	}
	
}

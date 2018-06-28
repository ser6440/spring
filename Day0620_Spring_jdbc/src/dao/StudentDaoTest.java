package dao;

import java.util.List;
import java.util.Map;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

import model.Student;

public class StudentDaoTest {
	public static void main(String[] args) {
		ApplicationContext context = new GenericXmlApplicationContext("dao/applicationContext.xml");
		
		iStudentDao dao = context.getBean("studentDao", iStudentDao.class);
		
		//insert를 위해 모델 클래스 준비
//		Student student = new Student();
//		student.setSnum(5);
//		student.setSname("dlfj");
//		student.setSgrade(2);
//		
//		dao.insertStudent(student);
		
		System.out.println("select One : " + dao.selectOne(2));
		System.out.println("-------------------------------------");
		
		List<Map<String,Object>> studentList = dao.selectAll();
		
		for(Map<String, Object> student:studentList) {
			System.out.println("이름: " + student.get("sname"));
			System.out.println("학년 : " + student.get("sgrade"));
			System.out.println("번호 : " + student.get("snum"));
			
		}
	}
}

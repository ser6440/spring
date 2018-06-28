package dao;

import model.Student;

public class StudentTest {
	public static void main(String[] args) {
		StudentDao dao = new StudentDao();
		Student student = new Student();
		
		student.setSnum(6);
		student.setSname("신사임당");
		student.setSgrade(2);
//		dao.insertStudent(student);
		dao.updateStudent(student);
		
		
//		for(Student s : dao.selectAll()) {
//			System.out.println(s);
//		}
		System.out.println("종료");
	}
}

package dao;

import model.Student;

public class DaoTest {
	public static void main(String[] args) {
		StudentDaoImp studentDao = new StudentDaoImp();
		Student student = new Student();
		
		student.setSname("호오옹옹ㅇ");
		student.setSgrade(2);
		student.setSnum(12);
//		studentDao.insertStudent(student);
//		studentDao.updateStudent(student);
//		System.out.println(studentDao.selectOne(12));
		System.out.println(studentDao.selectAll());
		
	}
}

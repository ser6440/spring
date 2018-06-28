package dao;

import model.Student;

public class DaoTest {
	public static void main(String[] args) {
		StudentDao dao = new StudentDao();
//		Student s = new Student();
		Student s = dao.selectOne(10);
		
//		s.setNum(10);
//		s.setSname("오아아");
//		s.setSgrade(1);
		
//		dao.insertStudent(s);
		System.out.println("dd");
	}
}

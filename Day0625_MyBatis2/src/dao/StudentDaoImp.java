package dao;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import model.Student;

public class StudentDaoImp implements StudentDao{
	private SqlSessionFactory sessionFactory;
	
	public StudentDaoImp() {
		InputStream is = null;
		try {
			is = Resources.getResourceAsStream("configuration.xml");
			sessionFactory = new SqlSessionFactoryBuilder().build(is);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Override
	public int insertStudent(Student student) {
		SqlSession session = sessionFactory.openSession();
		try{
			return session.getMapper(StudentDao.class).insertStudent(student);
		}finally {
			session.close();
		}
	}

	@Override
	public int updateStudent(Student student) {
		SqlSession session = sessionFactory.openSession();
		try{
			return session.getMapper(StudentDao.class).updateStudent(student);
		}finally {
			session.close();
		}
	}

	@Override
	public int deleteStudent(int snum) {
		SqlSession session = sessionFactory.openSession();
		try{
			return session.getMapper(StudentDao.class).deleteStudent(snum);
		}finally {
			session.close();
		}
	}

	@Override
	public Student selectOne(int snum) {
		SqlSession session = sessionFactory.openSession();
		try{
			return session.getMapper(StudentDao.class).selectOne(snum);
		}finally {
			session.close();
		}
	}

	@Override
	public List<Student> selectAll() {
		SqlSession session = sessionFactory.openSession();
		try{
			return session.getMapper(StudentDao.class).selectAll();
		}finally {
			session.close();
		}
	}

}

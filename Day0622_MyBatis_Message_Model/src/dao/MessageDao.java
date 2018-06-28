package dao;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import model.Message;

public class MessageDao {
	SqlSessionFactory sqlSessionFactory;
	
	public MessageDao() {
		
		InputStream is = null;
		try {
			is = Resources.getResourceAsStream("configuration.xml");
			sqlSessionFactory = new SqlSessionFactoryBuilder().build(is);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public int insertMessage(Message message) {
		SqlSession session = sqlSessionFactory.openSession();
		
		try{
			return session.insert("dao.messageMapper.insertMessage",message);
		}finally {
			session.close();
		}
	}
	public int deleteMessage(int id) {
		SqlSession session = sqlSessionFactory.openSession();
		
		try{
			return session.delete("dao.messageMapper.deleteMessage",id);
		}finally {
			session.close();
		}
	}
	public int updateMessage(Message message) {
		SqlSession session  = sqlSessionFactory.openSession();
		try{
			return session.update("dao.messageMapper.updateMessage",message);
		}finally {
			session.close();
		}
	}
	public Message selectOne(int id) {
		SqlSession session = sqlSessionFactory.openSession();
		try{
			return session.selectOne("dao.messageMapper.selectOne",id);
		}finally {
			session.close();
		}
	}
	public List<Message> selectAll(){
		SqlSession session = sqlSessionFactory.openSession();
		try{
			return session.selectList("dao.messageMapper.selectAll");
		}finally {
			session.close();
		}
	}
}

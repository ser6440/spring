package dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component("boardDao")
public class BoardDaoImp implements BoardDao{
	
	@Autowired
	SqlSession sqlSession;
	
	public void setSqlSession(SqlSession sqlSession) {
		this.sqlSession = sqlSession;
	}
	
	
	@Override
	public int insertBoard(Map<String, Object> params) {
		
		return sqlSession.getMapper(BoardDao.class).insertBoard(params);
	}

	@Override
	public int updateBoard(Map<String, Object> params) {
		return sqlSession.getMapper(BoardDao.class).updateBoard(params);
	}

	@Override
	public int deleteBoard(int num) {
		return sqlSession.getMapper(BoardDao.class).deleteBoard(num);
	}

	@Override
	public Map<String, Object> selectOne(int num) {
		return sqlSession.getMapper(BoardDao.class).selectOne(num);
	}

	@Override
	public List<Map<String, Object>> selectAll() {
		return sqlSession.getMapper(BoardDao.class).selectAll();
	}

}

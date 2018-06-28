package test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

import dao.BoardDao;

public class DaoTest {
	public static void main(String[] args) {
		ApplicationContext context = new GenericXmlApplicationContext("applicationContext.xml");
		
		BoardDao dao = context.getBean("boardDao", BoardDao.class);
		
//		Map<String, Object> board = new HashMap<String,Object>();
		
//		board.put("TITLE", "mybatis-spring board");
//		board.put("NAME", "홍니나");
//		board.put("PASS", "1111");
//		board.put("EMAIL", "1212@email.com");
//		board.put("CONTENT", "dfasdf");
//		
//		dao.insertBoard(board);
		
		Map<String, Object> params = new HashMap<String,Object>();
		
//		0. 검색하지 않음, 전체선택
//		1. 제목검색	title
//		2. 이름검색	name
//		3. 제목+이름검색	title, name
//		4. 내용검색	content
		
		params.put("type", 0);
		params.put("TITLE", "임");
		
		List<Map<String, Object>> result = dao.searchBoard(params);
		
		for(Map<String, Object> board : result) {
			System.out.println("TITLE : " + board.get("TITLE"));
			System.out.println("NAME : " + board.get("NAME"));
			System.out.println("CONTENT : " + board.get("CONTENT"));
		}
	}

}

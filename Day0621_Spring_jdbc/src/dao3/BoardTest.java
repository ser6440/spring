package dao3;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

import model.Board;

public class BoardTest {
	public static void main(String[] args) {
		ApplicationContext context = new GenericXmlApplicationContext("dao3/applicationContext.xml");
		
		IBoardDao dao = context.getBean("boardDao", IBoardDao.class);
//		BoardDao dao = context.getBean("boardDao",BoardDao.class);
	
		Board board = new Board();
		board.setTitle("sdfasdf");
		board.setName("홍길길길동");
		board.setPass("123456");
		board.setEmail("hong@email.com");
		board.setContent("ㅇ러마ㅣㄴ얼ㄴㄹㄴㅇ");
		board.setNum(72);
//		dao.insertBoard(board);
		dao.updateBoard(board);
	}
	
}

package dao;

import model.Message;

public class MessageDaoTest {
	public static void main(String[] args) {
		MessageDao dao = new MessageDao();
		Message message = new Message();
		
		
		message.setPassword("1111");
		message.setName("홍길길길");
		message.setMessage("메시지지징ㅇ");
		dao.insertMessage(message);
		
		System.out.println("ddd");
	}
}

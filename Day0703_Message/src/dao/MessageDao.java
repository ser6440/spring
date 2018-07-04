package dao;

import java.util.List;
import java.util.Map;

import model.Message;

public interface MessageDao {
	public Message selectOne(int id);
	public int deleteMessage(int id);
	public int selectTotalCount();
	public List<Message> selectList(Map<String, Object> params);
	public int insertMessage(Message message);
}

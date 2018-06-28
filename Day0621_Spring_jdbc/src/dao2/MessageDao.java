package dao2;

import java.util.List;
import java.util.Map;

public interface MessageDao {
	//insert, update, delete, selectOne, selectAll
	//단, model 만들지 말고 Map으로 하기
	
	public int insertMessage(Map<String, Object> param);
	public int updateMessage(Map<String, Object> param);
	public int deleteMessage(int id);
	public  Map<String, Object> selectOne(int id);
	public List<Map<String, Object>> selectAll();
	
}

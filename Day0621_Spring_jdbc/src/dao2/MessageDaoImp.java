package dao2;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;


@Component("messageDao")
public class MessageDaoImp implements MessageDao{
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
//	public MessageDaoImp(JdbcTemplate jdbcTemplate) {
//		this.jdbcTemplate = jdbcTemplate;
//	}
	
//	public void setMessageDaoImp(JdbcTemplate jdbcTemplate) {
//		this.jdbcTemplate = jdbcTemplate;
//	}

	@Override
	public int insertMessage(Map<String, Object> param) {
		String sql = "insert into message values(message_seq.nextval,?,?,?)";
		
		return jdbcTemplate.update(sql,param.get("password"),param.get("name"),param.get("message"));
	}

	@Override
	public int updateMessage(Map<String, Object> param) {
		String sql = "update message set "
				+ " password = ?, "
				+ " name = ?, "
				+ " message = ? ";
		return jdbcTemplate.update(sql,param.get("password"),param.get("name"),param.get("message"));
	}

	@Override
	public int deleteMessage(int id) {
		String sql = "delete from message where id = ?";
		return jdbcTemplate.update(sql,id);
	}

	@Override
	public Map<String, Object> selectOne(int id) {
		String sql = "select * from message where id = ? ";
//		return jdbcTemplate.queryForObject(sql, messageMapper, id);
		return jdbcTemplate.queryForMap(sql, messageMapper, id);
	}

	@Override
	public List<Map<String, Object>> selectAll() {
		String sql = "select * from message";
//		return jdbcTemplate.query(sql, messageMapper);
		return jdbcTemplate.queryForList(sql, messageMapper);
		
	}
	
	RowMapper<Map<String, Object>> messageMapper = new RowMapper<Map<String,Object>>() {

		@Override
		public Map<String, Object> mapRow(ResultSet rs, int rowNum) throws SQLException {
			Map<String, Object> message = new HashMap<String,Object>();
			message.put("id", rs.getInt("id"));
			message.put("password", rs.getString("password"));
			message.put("name", rs.getString("name"));
			message.put("message", rs.getString("message"));
			return message;
		}
	};
	
}

package dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import model.Member;

public class MemberDao implements IMemberDao{
	
	private JdbcTemplate jdbcTemplate;
	
	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}
	
	@Override
	public int insertMember(Member member) {
		String sql = "insert into member2 values(member2_seq.nextval,?,?,?,?,sysdate)";
		
		return jdbcTemplate.update(sql,member.getId(),member.getPw(),member.getName(),member.getEmail());
	}

	@Override
	public int updateMember(Member member) {
		String sql = "update member2 set id = ?, pw = ?, name = ?, email = ?, regDate = ? where num = ?";
		return jdbcTemplate.update(sql,member.getId(),member.getPw(),member.getName(),member.getEmail(),member.getRegDate(),member.getNum());
	}

	@Override
	public int deleteMember(int num) {
		String sql = "delete from member2 where num = ?";
		return jdbcTemplate.update(sql,num);
		
	}

	@Override
	public Member selectOne(int num) {
		String sql = "select * from member2 where num = ?";
		return jdbcTemplate.queryForObject(sql, memberMapper,num);
	}

	@Override
	public List<Map<String, Object>> selectAll() {
		String sql = "select * from member2";
		return jdbcTemplate.query(sql, memberMapper2);
	}

	RowMapper<Member> memberMapper = new RowMapper<Member>() {

		@Override
		public Member mapRow(ResultSet rs, int rowNum) throws SQLException {
			Member member = new Member();
			
			member.setNum(rs.getInt("num"));
			member.setId(rs.getString("id"));
			member.setPw(rs.getString("pw"));
			member.setName(rs.getString("name"));
			member.setEmail(rs.getString("email"));
			member.setRegDate(rs.getDate("regDate"));
			
			return member;
		}
	};
	
	RowMapper<Map<String,Object>> memberMapper2 = new RowMapper<Map<String,Object>>() {

		@Override
		public Map<String, Object> mapRow(ResultSet rs, int rowNum) throws SQLException {
			Map<String, Object> result = new HashMap<String,Object>();
			result.put("num", rs.getInt("num"));
			result.put("id", rs.getString("id"));
			result.put("pw", rs.getString("pw"));
			result.put("name", rs.getString("name"));
			result.put("email", rs.getString("email"));
			result.put("regDate", rs.getDate("regDate"));
			
			return result;
		}

	
	};
}

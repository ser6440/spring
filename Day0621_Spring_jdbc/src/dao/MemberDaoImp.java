package dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import model.Member;

public class MemberDaoImp implements MemberDao {
	
	//연결생성, 드라이버 로딩, 구문객체 생성, 결과 실행, 예외처리 : spring
	//JdbcTemplate 
	//sql작성, 결과매핑, db 파라미터 작성 : 개발자
	
	JdbcTemplate jdbcTemplate;
	//생성자 또는 setter가 필요, 이번에는 생성자를 통한 의존성 주입
	public MemberDaoImp(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}
	
	@Override
	public int insertMember(Member member) {
		String sql = "insert into member3 values(?,?,?,?,sysdate)";
		
		return jdbcTemplate.update(sql,member.getId(),member.getPw(),member.getName(),member.getEmail());
	}

	@Override
	public int updateMember(Member member) {
		String sql = "update member3 set pw = ?, name = ?, email = ? where id = ?";
		return jdbcTemplate.update(sql,member.getPw(),member.getName(),member.getEmail(),member.getId());
	}

	@Override
	public int deleteMember(String id) {
		String sql = "delete from member3 where id = ?";
		return jdbcTemplate.update(sql,id);
	}

	@Override
	public Member selectOne(String id) {
		String sql = "select * from member3 where id = ?";
		return jdbcTemplate.queryForObject(sql, memberMapper,id);
	}

	@Override
	public List<Member> selectAll() {
		String sql = "select * from member3";
		return jdbcTemplate.query(sql, memberMapper);
	}
	
	RowMapper<Member> memberMapper = new RowMapper<Member>() {

		@Override
		public Member mapRow(ResultSet rs, int rowNum) throws SQLException {
			Member member = new Member();
			//resultset이 가지고 있는 칼럼의 값을 가지고 와서 model에 넣기
			member.setId(rs.getString("id"));
			member.setPw(rs.getString("pw"));
			member.setName(rs.getString("name"));
			member.setEmail(rs.getString("email"));
			member.setDate(rs.getDate("regDate"));
			return member;
		}
	};
	
//	RowMapper<Member> memberMapper2
}

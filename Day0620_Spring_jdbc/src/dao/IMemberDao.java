package dao;

import java.util.List;
import java.util.Map;

import model.Member;

public interface IMemberDao {
	//회원가입 처리를 위해서 int로 바꿈
	public int insertMember(Member member);
	public int updateMember(Member member);
	public int deleteMember(int num);
	public Member selectOne(int num);
	public List<Map<String, Object>> selectAll();
}

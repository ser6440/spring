package dao;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import model.Member;

public interface MemberMapper {
	
	@Insert("insert "
			+ " into member3"
			+ " values(#{id},#{pw},#{name},#{email},sysdate)")
	public int insertMember(Member member);
	
	@Update("UPDATE member3" + 
			"			SET pw = #{pw}," + 
			"				 name = #{name}" +
			"                email = #{email}" + 
			"	   WHERE id = #{id}")
	public int updateMember(Member member);
	
	@Delete("delete"
			+ " 	from member3"
			+ " where id = #{id}")
	public int deleteMember(String id);
	
	@Select("select *"
			+ " 	from member3"
			+ " where id = #{id}")
	public Member selectOne(String id);
	
	@Select("select *"
			+ " 	from member3")
	public List<Member> selectAll();
}

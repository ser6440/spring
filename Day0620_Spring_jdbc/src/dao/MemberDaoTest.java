package dao;

import java.util.List;
import java.util.Map;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

import model.Member;

public class MemberDaoTest {
	public static void main(String[] args) {
		ApplicationContext context = new GenericXmlApplicationContext("dao/applicationContext.xml");
		
		IMemberDao dao = context.getBean("memberDao", IMemberDao.class);
		
//		Member member = new Member();
//		member.setId("qwer");
//		member.setPw("1111");
//		member.setName("김길길");
//		member.setEmail("gil@email.com");
//		dao.insertMember(member);
		
		System.out.println("select One : " + dao.selectOne(1));
		
		List<Map<String, Object>> memberList = dao.selectAll();
		
		for(Map<String, Object> member : memberList) {
			System.out.println("아이디 : " + member.get("id"));
			System.out.println("이름 : " + member.get("name"));
			System.out.println("이메일 : " + member.get("email"));
			System.out.println("가입일 : " + member.get("regDate"));
		}
	}
}

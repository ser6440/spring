package dao;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

import model.Member;

public class DaoTest {
	public static void main(String[] args) {
		ApplicationContext context = new GenericXmlApplicationContext("dao/applicationContext.xml");
		
		MemberDao dao = context.getBean("memberdao", MemberDao.class);
		
		Member member = new Member();
		member.setId("id1");
		member.setPw("123");
		member.setName("홍길길동동동");
		member.setEmail("hong@email.com");
//		dao.insertMember(member);
//		dao.updateMember(member);
		
		System.out.println(dao.selectOne("id1"));
	}
}

package dao;

import java.util.Map;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

import common.Constant;

public class DaoTest2 {
	public static void main(String[] args) {
		ApplicationContext context = new GenericXmlApplicationContext("dao/applicationContext.xml");
		
		MemberDao dao = context.getBean("memberDao3", MemberDao.class);
		
		Map<String, Object> member = dao.selectOne("id1");
		
		System.out.println("이름 : " + member.get(Constant.Member.NAME));
		System.out.println("아이디 : " + member.get(Constant.Member.ID));
		System.out.println("이메일 : " + member.get(Constant.Member.EMAIL));
		
		
	}
}

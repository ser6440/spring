package dao;

import model.Member;

public class DaoTest {
	public static void main(String[] args) {
		MemberDao dao = new MemberDao();
		Member member  = new Member();
		
		member.setId("임당ㅇ");
		member.setName("임다수르");
		member.setPw("1111");
		member.setEmail("dlae@email.com");
		dao.insertMember(member);
		
	}
}

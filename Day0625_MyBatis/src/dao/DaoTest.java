package dao;

import model.Member;

public class DaoTest {
	public static void main(String[] args) {
		MemberDaoImp memberDao = new MemberDaoImp();
		
		Member member = new Member();
		member.setId("id2");
		member.setPw("1111");
		member.setName("인앙");
		member.setEmail("dsdf@email.com");
		
//		memberDao.insertMember(member);
//		memberDao.deleteMember("id1");
		memberDao.updateMember(member);
		
		
	}
}

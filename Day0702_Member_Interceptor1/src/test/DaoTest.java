package test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import dao.MemberDao;
import model.Member;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:WebContent/WEB-INF/spring/root-context.xml")
public class DaoTest {
	
	@Autowired
	private MemberDao memberDao;
	
	@Test
	public void memberDaoTest() {
		Member member = new Member();
		member.setId("id11");
		member.setName("이호호");
		member.setPw("1111");
		member.setEmail("gjgjg@email.com");
		
		memberDao.insertMember(member);
	}
}

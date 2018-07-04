package controller;

import java.util.Map;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import model.Member;
import service.MemberService;

@Controller
@RequestMapping("/member")
public class MemberController {
	

	@Autowired
	private MemberService memberService;
	
	@ResponseBody
	@RequestMapping("/memberList")
	public String memberList(Model model) {
		System.out.println("memberList 요청 받음");
		
		model.addAttribute("memberList", memberService.getAllMembers());
		
		return "memberList";
	}


	@RequestMapping("/main")
	public String main() {
		return "main";
	}
	
	@RequestMapping("/updateForm")
	public String updateForm(HttpSession session, Model model) {
		String id = (String)session.getAttribute("userid");
		model.addAttribute("member", memberService.getMemberById(id));
		return "memberUpdate";
	}
	
	@RequestMapping(value = "/join", method = RequestMethod.GET)
	public String joinForm() {
		return "join";
	}

	@RequestMapping(value = "/join", method = RequestMethod.POST)
	public String join(HttpServletRequest request, Member member) {
		//회원가입 진행하기...
//		System.out.println("id : " + request.getParameter("id"));
//		System.out.println("pw : " + request.getParameter("pw"));
//		System.out.println("name : " + request.getParameter("name"));
//		System.out.println("email : " + request.getParameter("email"));
		
		if(memberService.join(member)) {
			//회원가입 성공
			return "redirect:login";
		}else {
			//회원가입 실패 >> 성공할때까지 join으로
			return "redirect:join";
		}
	}
	
	@RequestMapping(value = "/login", method = RequestMethod.GET )
	public String loginForm() {
		return "login";
	}
	
	@RequestMapping(value = "/login", method = RequestMethod.POST)
//	public String login(@RequestParam Map<String, Object> params) {
		public String login(HttpSession session, Member member, RedirectAttributes ra) {
		//login.jsp에서 넘겨주는 form 요소를 받아서
		//로그인 진행
//		System.out.println("userid : " + member.getId());
//		System.out.println("userpw : " + member.getPw());
		
		boolean result = memberService.login(member.getId(), member.getPw());
		
		if(result) {
			//세션에 아이디를 담고 메인으로 이동
			session.setAttribute("userid", member.getId());
			return "redirect:main";
		}else {
			//로그인 실패니까...로그인 페이지로 이동
			//로그인 페이지 이동할 때 실패 메시지 전달하고 싶음 model을 하나 받아와서
			//redirect는 요청이 새로 만들어지기 때문에... model에 담아도 데이터 전달 불가
			
			//redirect(새로운 요청을 만들어 낼 때) 메시지를 전달하려고 한다.
			//RedirectAttribute를 이용
			
//			model.addAttribute("msg", "로그인 실패");		>> 이렇게 못 씀.
			
			ra.addFlashAttribute("msg", "로그인 실패");
			return "redirect:login";
		}
		
//		System.out.println("userid : " + params.get("id"));
//		System.out.println("userpw : " + params.get("pw"));
		
	}
	
	@RequestMapping("/logout")
	public String logout(HttpSession session) {
		session.removeAttribute("userid");
		return "redirect:login";
	}
	
	@RequestMapping("/update")
	public String update() {
		return null;
	}
}


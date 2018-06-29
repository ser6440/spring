package controller;

import java.util.Date;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MyController {
	
	@RequestMapping("/test.do")
	public String test(Model model) {
		System.out.println("test.do요청입니다.111");
		
		//이렇게 .jsp등 경로없이
		//사용하기 위해서 viewResolver설정 바꿔줘야 함
		model.addAttribute("msg", "test 요청 받았습니다.");
		
		return "test";
	}
	
	//whatTime.do 요청받아서
	//화면에 현재 시각 출력하기
	@RequestMapping("/whatTime.do")
	public String whatTime(Model model) {
		model.addAttribute("msg", new Date());
		
		return "time";
	}
}	

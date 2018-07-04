package controller;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import model.Message;
import service.MessageService;

@Controller
public class MessageController {
	
	private static final Logger logger = Logger.getLogger(MessageController.class);
	
	
	@Autowired
	private MessageService messageService;
	
	
	@RequestMapping("/messageList")
	public String messageList(Model model,
			@RequestParam(value = "page",defaultValue="1")int currentPage) {
		//messageList를 요청 받아서 화면으로 이동
		//화면으로 이동할 때 리스트를 보여줘야 한다. 
		logger.info("messageList 진입");
		model.addAttribute("viewData", messageService.getMessageViewData(currentPage));
		return "messageList";
	}
	
	@RequestMapping("/write")
	public String write(Message message,Model model) {
		model.addAttribute("url","messageList");
		if(messageService.writeMessage(message)) {
			model.addAttribute("msg", "메시지 등록 성공");
		}else {
			model.addAttribute("msg", "메시지 등록 실패");
		}
		return "result";
	}
	
	@RequestMapping("/confirmDeletion")
	public String confirmDeletion() {
		return "confirmDeletion";
	}
	
	@RequestMapping("/pwCheck")
	public String pwCheck(int id, String password, Model model) {
			//서비스에 삭제 서비스 만들기 
			model.addAttribute("url","messageList");
			if(messageService.removeMessage(id, password)) {
				model.addAttribute("msg", "메시지 삭제 완료");
			}else {
				model.addAttribute("msg", "메시지 삭제 실패");
			}
			return "result";
		}
	}

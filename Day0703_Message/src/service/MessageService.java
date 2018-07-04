package service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dao.MessageDao;
import model.Message;
import model.MessageViewData;

@Service
public class MessageService {
	
	@Autowired
	private MessageDao messageDao;
	
	//message목록 가져오기 
	
	public MessageViewData getMessageViewData(int currentPage) {
		MessageViewData messageViewData = new MessageViewData(currentPage);
		//리스트를 얻어와서 MessageViewData에 넣어줘야 함
		Map<String, Object> params = new HashMap<String,Object>();
		params.put("firstRow", messageViewData.getFirstRow());
		params.put("endRow", messageViewData.getEndRow());
		
		List<Message> messageList = messageDao.selectList(params);
		
		messageViewData.setMessageList(messageList);
		//페이지 토탈 카운트 셋팅
		messageViewData.setPageTotalCount(messageDao.selectTotalCount());
		
		return messageViewData;
	}
	public boolean writeMessage(Message message) {
		int result = messageDao.insertMessage(message);
		if(result > 0) {
			return true;
		}else {
			return false;
		}
	}
	
	public boolean removeMessage(int id, String password) {
		//비밀번호 확인후 일치하면  dao에서 delete 호출
				Message message = messageDao.selectOne(id);
				if(message !=null && message.getPassword().equals(password)) {
					//비밀번호 일치
					if(messageDao.deleteMessage(id) >0) {
						return true;
					}else {
						return false;
					}
				}else {
					return false;
				}
	}

}







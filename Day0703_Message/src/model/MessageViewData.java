package model;

import java.util.List;

public class MessageViewData {
	//currentPage : 현재 페이지 정보
	//messageList : 현재 페이지에 표시될 list
	//pageTotalCount : 총 페이지 수
	//startPage : 시작 페이지 
	//endPage : 종료 페이지 
	private static final int NUM_OF_MESSAGE_PER_PAGE = 10;
	//한번에 표시될 네비게이션의 개수
	private static final int NUM_OF_NAVI_PAGE = 10;
	
	
	public int getCurrentPage() {
		return currentPage;
	}


	public int getPageTotalCount() {
		return pageTotalCount;
	}

	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}

	public int getStartPage() {
		return startPage;
	}


	public void setStartPage(int startPage) {
		this.startPage = startPage;
	}


	public int getEndPage() {
		return endPage;
	}


	public void setEndPage(int endPage) {
		this.endPage = endPage;
	}


	public List<Message> getMessageList() {
		return messageList;
	}


	public void setMessageList(List<Message> messageList) {
		this.messageList = messageList;
	}
	private int currentPage;
	private List<Message> messageList;
	private int pageTotalCount;
	private int startPage;
	private int endPage;
	
	public MessageViewData(int currentPage) {
		this.currentPage = currentPage;
		setStartPage();
		setEndPage();
		//list와 pageTotalCount 는 서비스에서 처리
	}
	
	
	public void setPageTotalCount(int totalCount) {
		
		pageTotalCount = 0;
		if(totalCount != 0) {
			pageTotalCount = (int)Math.ceil(
					((double)totalCount / NUM_OF_MESSAGE_PER_PAGE));
		}
	}
	public void setStartPage() {
		//6  >>> 1
		//16 >>> 11
		//30 >> 21 
		//현재페이지 >> 시작페이지
		
		//현재 페이지 6이라고 가정, 네비게이션은 5개씩
		//6부터 시작
		startPage = 
				((currentPage-1)/NUM_OF_NAVI_PAGE)*NUM_OF_NAVI_PAGE + 1;
		
	
	}
	public void setEndPage() {
		/*6  >>  10
		  10 >> 10*/
		/*11 >> 15*/
		// (16 - 1) / 5 >>> (3 + 1 ) * 5 =  20;
		endPage = (((currentPage-1)/NUM_OF_NAVI_PAGE)+1)* NUM_OF_NAVI_PAGE;
		
	}
	public int getFirstRow() {
		return (currentPage-1)*NUM_OF_MESSAGE_PER_PAGE +1;
	}
	public int getEndRow() {
		return currentPage*NUM_OF_MESSAGE_PER_PAGE;
	}
	
	
}

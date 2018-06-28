package di05;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class Driver {
	public static void main(String[] args) {
		//스프링 컨테이너 로딩
		ApplicationContext context = new GenericXmlApplicationContext("di05/applicationContext.xml");
		
		Car myCar = context.getBean("car",Car.class);	//클래스에서 클래스이름의 첫글자를 소문자로 바꾼게 빈의 아이디
		myCar.drive();
	}
}

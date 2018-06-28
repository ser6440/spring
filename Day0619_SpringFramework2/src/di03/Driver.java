package di03;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class Driver {
	public static void main(String[] args) {
	//스프링 컨테이너 로딩
		ApplicationContext context = new GenericXmlApplicationContext("di03/applicationContext.xml");
		
		Car myCar = context.getBean("myCar",Car.class);
		myCar.drive();
	}
}

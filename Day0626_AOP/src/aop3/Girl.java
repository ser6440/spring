package aop3;

import java.util.Random;

import org.springframework.stereotype.Component;


@Component
public class Girl implements Person{
	public String doSomething()  throws Exception {
		
		System.out.println("쇼핑몰에서 쇼핑을 한다.");
		if(new Random().nextBoolean()) {
			throw new Exception("엄마 호출!!");
		}
		return "정상종료 : Girl";
		//aop를 이용하여 타겟의 리턴값을 받아서 결과에 따른 프로그래밍
	}
}

package di05;

import org.springframework.stereotype.Component;

//@Component
public class ChinaTire implements Tire{
	public void roll() {
		System.out.println("중국 타이어 잘굴러갑니다.");
	}
}

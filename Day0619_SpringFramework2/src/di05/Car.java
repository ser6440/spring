package di05;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class Car {
	//Autowired는 타입우선매칭, 의존성 주입대상 타입의 bean 존재하지 않을경우
	//예외 발생 bean 자체가 생성이 안됨, 단, required=false 속성을 지정하면
	//의존성 주입 객체가 존재하지 않으면 의존성 주입하지 않고 bean 생성
	
	@Autowired(required=false)
	Tire tire;
	
//	public Car() {
//		this.tire = new KoreaTire();
//	}
	
	@Qualifier("kTire")
	@Autowired
	public void setTire(Tire tire) {
		this.tire = tire;
	}
	
	public void drive() {
		//실제로 수정된것은 타이어인데, car 역시도 수정해야 한다.
		//>> Car가 KoreaTire 객체의 제어권을 가지고 있기 때문이다.
		//>> 해결하기 위한 방법: 제어역전 사용하는 객체를 직접 만들지 않고, 상위객체(Driver)에서 만들어서 전달
//		KoreaTire tire = new KoreaTire("굴러갑니다.");
		tire.roll();
	}

}

package di01;

public class Driver {
	public static void main(String[] args) {
		Car car = new Car();
		
//		KoreaTire tire = new KoreaTire("굴러갑니다.");
//		ChinaTire tire = new ChinaTire();
		Tire tire = new ChinaTire();
		
		car.setTire(tire);
		car.drive();
		//Tire가 수정되면 Car는 수정될 필요가 없다. 다만 객체를 만들어주는 상위 클래스에서 수정된 방식을 가지고 사용
	}
}

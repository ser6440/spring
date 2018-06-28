package robot;

import org.springframework.stereotype.Component;

@Component
public class TaekwonV extends Robot {
	
	public TaekwonV(Attackable attack,Moveable move) {
		this.name = "태권브이";
		this.attack = attack;
		this.move = move;
	}
//	public void attack() {
//		attack.attack();
//	}
//	
//	
//	
//	public void move() {
//		move.move();
//	}
}

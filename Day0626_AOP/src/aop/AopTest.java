package aop;

public class AopTest {
	public static void main(String[] args) {
//		Boy boy = new Boy();
//		Girl girl = new Girl();
//		boy.doSomething();
//		girl.doSomething();
		
		PersonProxy personProxy = new PersonProxy(new Boy());
		personProxy.callPerson();
	}
}

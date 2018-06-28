package aop2;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;


@Component
@Aspect
public class MyAspect {
	
	//pintcut 정의하기, public void 타입의 body가 없는 
	//메서드 위에 pointcut 정의, 메서드 이름이 pointcut의 id 
	@Pointcut("execution(public * * .doSomething(..))")
	public void mypt() {
		
	}
	
	/* 공통 관심사항 모듈이 작성될 클래스 
	실제로 작성되는 내용(코드) >> advice
	advice의 종류 :
	          before : taget 수행 전 실행될 코드 
               	after :  target 수행 후 실행될 코드
	after-returning : target이 정상적으로 종료되면 실행될 코드
	after-throwing : target이 비정상적으로 종료되면 실행될 코드
	         around : target 앞뒤로 실행 될 코드를 정의
	         
	    지하철을 탑니다. >> before
	    피시방에가서 게임을 합니다.	>> 핵심관심사항
	    계산을 하고 집에 옵니다.
	    씻고 잠을 잡니다.
	    
    */
	
	@Before("mypt()")
	public void before(JoinPoint jp) {
		//JoinPoint를 이용해서 Target 정보를 가져올 수 있다.
		//JoinPoint >> advice들이 적용될수 있는 정보, 반환값을 받으려면 두번째 파라미터로 반환값 받아올수있음
		System.out.println("Target : " + jp.getTarget());
		System.out.println("지하철을 탑니다.");
	}
	
	@After("mypt()")
	public void after(JoinPoint jp) {
		//target 메서드 실행 후
		//정상종료든, 비정상 종료든 항상 실행
		System.out.println("씻고 잠을 잔다.");
	}
	
	@AfterReturning(pointcut = "mypt()", returning = "msg")
	public void afterReturning(JoinPoint jp, String msg) {
		//target메서드 정상 종료 후 
		System.out.println(msg + " : 계산하고 집에 온다.");
	}
	
	@AfterThrowing(pointcut = "mypt()", throwing = "th")
	public void afterThrowing(JoinPoint jp, Throwable th) {
		//target메서드 비정상 종료 후
		System.out.println(th.getMessage() + " : 하던일을 멈추고 집에 온다.");
	}
	
//	public void around(ProceedingJoinPoint jp) {
//		//타겟메서드 실행 전후를 직접 관리
//		//타겟메서드를 직접 실행함 : 타겟을 접근할 수 있어야 한다.
//		
//		try {
//			before(jp);
//			String msg = (String)jp.proceed();		//타겟 메서드 실행
//			afterReturning(jp, msg);
//		} catch (Throwable e) {
//			e.printStackTrace();
//			afterThrowing(jp,e);
//		}finally {
//			after(jp);
//		}
//	}
}

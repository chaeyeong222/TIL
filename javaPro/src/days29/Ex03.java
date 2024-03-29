package days29;
/**
 * @author 이채영
 * @date 2022. 3. 30. - 오전 10:51:22
 * @subject p. 722 Chapter 13 스레드thread
 * @content 
 */
public class Ex03 {

	public static void main(String[] args) {
		/*
		 * 1. 프로세스 process
		 *    작업관리자 ==
		 *   OS운영체제로부터 실행에 필요한 자원(메모리, 전원, CPU, 디스크)을 할당받아서 실행중인 프로그램
		 *   calc.exe 실행파일 -> 실행(더블클릭, cmd에 입력) -> 실행중인 프로그램(=프로세스1)
		 *   calc.exe 실행파일 -> 실행(더블클릭, cmd에 입력) -> 실행중인 프로그램(=프로세스2)
		 * (작업관리자에서 스레드 확인 : 성능-> 리소스모니터-> cpu )
		 * 
		 * 2.스레드Thread
		 *   -프로세스 내에서 독립적으로 실행되는 메서드(기능)
		 *   -최소한 기본1개의 스레드는 가지고 있음(main 스레드)
		 *   -여러개의 스레드(멀티 스레드) 가 존재할 수 있다.
		 *   
		 * 3.멀티스레드와 멀티태스킹
		 *    ㄴ 멀티스레드 : 여러 개의 스레드  
		 *    ㄴ 멀티태스킹 : 여러 개의 프로세스 
		 *    
		 *    CPU 중앙처리장치 = 시분할 멀티태스킁  -- -(자동)os가 관리
		 *     "OS" 자동 관리 =  멀티태스킹(멀티 스레드)
		 *     개발자 스레드 처리 어렵다
		 * 5. 자바에서 스레드 사용방법(구현)
		 *    ㄱ. Runnable 인터페이스 사용
		 *    ㄴ. Thread  클래스 사용
		 *   
		 */

	}

}

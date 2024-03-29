package days29;
/**
 * @author 이채영
 * @date 2022. 3. 30. - 오전 11:33:54
 * @subject  
 * @content 
 * 
 *  메인스레드 확인
 *  
 *  장보는 스레드 생성
 *  
 * 
 */
public class Ex04 {

	public static void main(String[] args) {
     	//main스레드 (1개 기본) ==일꾼
		Thread t = Thread.currentThread();
		String tName = t.getName(); 
		System.out.println(tName);  //스레드이름:main

		//독립적으로 스레드(일꾼)을 만들어서 장보기 시키기
		Runnable target = new ShoppingWorker();
		Thread 장보기일꾼 = new Thread(target);
		장보기일꾼.setName("shopping");
		장보기일꾼.start(); // run() 메서드 호출됨.

		//ㄱ. 방청소 main스레드
		/*
		for (int i = 0; i <100; i++) {
			System.out.printf(">%s -방청소 : %d %%\n",tName,i);
		}//for
		 */
		Thread 방청소일꾼 = new CleaningWorker("cleaning");
		//방청소일꾼.setName("cleaning");
		방청소일꾼.start();


		//ㄴ. 마트 쇼핑 
		/*
		for (int i = 0; i <100; i++) {
			System.out.printf(">%s -장보기 : %d %%\n",tName,i);
		}//for   -> main이 방청소 끝내고 마트쇼핑함
		 */

		System.out.println("END");


	}//main  실행중인 프로그램 종료 == 프로세스 종료

}//class

//청소하는 일꾼
class CleaningWorker extends Thread {
	public CleaningWorker(String name) {
		super(name);  //
	}

	@Override
	public void run() {
		Thread t = Thread.currentThread();
		String tName = t.getName(); 
		for (int i = 0; i <100; i++) {
			System.out.printf(">%s - 방청소 : %d %%\n",tName,i);
		}//for
	}//run
}//class

// 장보는 일꾼 = 스레드 생성
class ShoppingWorker implements Runnable{

	@Override
	public void run() {
		//run() 메서드 : 이 스레드가 독립적으로 해야할 일(기능)을 구현 -업무지시 -항상 오버라이딩해야함
		Thread t = Thread.currentThread();
		String tName = t.getName(); 
		for (int i = 0; i <100; i++) {
			System.out.printf(">%s - 장보기 : %d %%\n",tName,i);
		}//for
	}//run


}//class 
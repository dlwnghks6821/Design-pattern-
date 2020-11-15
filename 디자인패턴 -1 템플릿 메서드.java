
public class testfor {
  

	public static void main(String[] args) {
		System.out.println("자율주행자동차");
		Car myCar = new AIcar();
		myCar.run();
		
		System.out.println("사람이 운전하는 자동차");
		Car hisCar = new ManualCar();
		hisCar.run();
		
}
}
abstract class Car{
	protected abstract void drive();
	protected abstract void stop();
	protected void startCar() {
		System.out.println("시동을 켭니다.");
	}
	protected void turnOff() {
		System.out.println("시동을 끕니다.");
	}
	final protected void run() {
		//template method//
		//공통부분 ==>시동켜고 끄기//
		//공통 ==>자율주행자동차나 사람이 주행하는자동차나 결국//
		//시동을 켜고 끄는것은 똑같다.//
		//공통되는 부분을 final 을 통해서 공통의 로직을 변경할수없게 해준다.//
		//이것이 템플릿 메서드의 역할이다.//
		startCar();
		turnOff();
		//여기부분 부터는 재정의(overriding 의 부분이다.)//
		//즉, 주행(drive)와 정지(stop)부분은 추상 메서드 이므로 //
		//필요로 하는 클래스 에 상속을 받아서 그 클래스의 스타일(내용)대로 재정의해서 사용할수있게 한다.//
		//그러나 본질은 똑같다(주행과 멈춤 이라는 시나리오가 똑같다.)//
		drive();
		stop();
	}
}
class AIcar extends Car{
	@Override
	protected void drive() {
		System.out.println("자율주행합니다.");
		System.out.println("자동차가 알아서방향을 전환합니다.");
	}
	@Override
	protected void stop() {
		System.out.println("스스로 멈춘다.");
	}
}
class ManualCar extends Car{
	@Override
	protected void drive() {
		System.out.println("사람이 운전을한다.");
		System.out.println("사람이 핸들을 조작한다.");
	}
	@Override
	protected void stop() {
		System.out.println("브레이크로 정지한다.");
	}
}
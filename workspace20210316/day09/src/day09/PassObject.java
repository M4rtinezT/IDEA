package day09;

public class PassObject {
	public static void main(String[] args) {
		PassObject P1 = new PassObject();
		P1.printAreas(new Circle(), 5);
	}
	public void printAreas(Circle c , int time) {
		System.out.println("Radius\t\tArea");
		//设置圆的半径
		for (int i = 1 ; i <= time ; i++) {
			c.radius = i;
			System.out.println(i+"\t\t"+c.findArea());
		}
	}
}

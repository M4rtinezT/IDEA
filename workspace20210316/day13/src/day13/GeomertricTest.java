package day13;

public class GeomertricTest {
	
	public static void main(String[] args) {
		GeomertricTest test = new GeomertricTest();
		
		Circle c1 = new Circle(2.3, "white", 1.0);
		test.displayGeometricObject(c1);
		Circle c2 = new Circle(3.3, "white", 1.0);
		test.displayGeometricObject(c2);
	}
	
	
	
	
	
	public boolean equalsArea(GeometricObject o1 ,GeometricObject o2 ) {
		return o1.findArea() == o2.findArea();
	}
	public void displayGeometricObject(GeometricObject o) {
		System.out.println("面积为："+o.findArea());
	}
}

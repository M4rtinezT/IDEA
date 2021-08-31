package day12;

public class Circle {
	private double radius;
	public Circle() {
		radius = 1.0;
	}
	public double getRadius() {
		return radius;
	}
	public void setRadius(double radius) {
		this.radius = radius;
	}
	public double findArea() {
		return radius * radius * Math.PI ;
	}
}

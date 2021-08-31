package Test3;

public class Test{
	public static void main(String[] args) {
//		System.out.println(B.get());
		B b = new B();
		System.out.println(b.get());
	}
	
	
}


class B{
	public int a;
	public int get() {
		return 1;
	}
}
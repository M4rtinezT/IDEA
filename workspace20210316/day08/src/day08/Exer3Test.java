package day08;

public class Exer3Test {
	public static void main(String[] args) {
	Exer3Test test = new Exer3Test();
	System.out.print(test.Pating(12,10));
	}
	
	public int Pating(int m ,int n) {
		for (int i =0 ; i < m ; i++) {
			for (int j = 0 ; j < n ; j++) {
				System.out.print("*");
			}
			System.out.println();
		}
		return m * n ;
	}
}
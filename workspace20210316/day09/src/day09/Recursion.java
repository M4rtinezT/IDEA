package day09;
import java.util.Scanner;
public class Recursion {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		System.out.println("请出入斐波那契的N:");
		int q1 = scan.nextInt();
		Recursion r1 = new Recursion();
		System.out.println(r1.sum1(10));
		System.out.println(r1.sum2(11));
		System.out.println(r1.sum3(q1));
		for (int i = 1 ; i <= q1 ; i++) {
			System.out.print(r1.sum3(i)+" ");
		}
		
	}
	
	
	
	
	
	
	//数列1
	public int sum1(int n) {
		if(n == 0) {
			return 1;
		}
		else if(n == 1) {
			return 4;
		}
		else {
			return 2*sum1(n-1)+sum1(n-2);
		}
	}
	//数列2
	public int sum2(int n) {
		if(n == 20) {
			return 1;
		}
		else if (n == 21) {
			return 4;
		}
		else {
			return sum2(n+2)-2*sum2(n+1);
		}
	}
	//斐波那契数列
	public int sum3(int n) {
		if(n == 1) {
			return 1;
		}
		else if (n == 2) {
			return 1;
		}
		else {
			return sum3(n-1)+sum3(n-2);
		}
	}
}



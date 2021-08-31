package day13;

import java.util.Scanner;
import java.util.Vector;

public class ScoreTest {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int maxScore = 0;
		Vector v = new Vector();
		for(;;) {
			System.out.println("请输入学生成绩（以负数未结束）：");
			int score = scan.nextInt();
			if(score < 0) {
				break;
			}
			v.addElement(score);//自动装箱
			if(maxScore < score) {
				maxScore = score;
			}
		}
		char level;
		for(int i = 0 ; i < v.size() ; i++) {
			Object obj = v.elementAt(i);
			
			int score = (int) obj;
			
			if (maxScore - score <= 10) {
				level = 'A';
			}else if(maxScore - score <= 20) {
				level = 'B';
			}else if(maxScore - score <= 30) {
				level = 'C';
			}else {
				level = 'D';
			}
			System.out.println(level);
		}
	}
}

import java.util.Scanner;
class lotteryTest
{
	public static void main(String[] args) 
	{
		int Lnum = (int)(Math.random()*90+10);  // 中奖号码
		System.out.println(Lnum);
		Scanner scan = new Scanner(System.in);
		System.out.println("请输入一个两位数");
		int Pnum = scan.nextInt();  //个人号码
		if (Pnum == Lnum)
		{	
			System.out.println("奖金10000美元");
		}
		else if (Pnum / 10 == Lnum % 10 && Lnum / 10 == Pnum % 10)
		{
			System.out.println("奖金3000美元");
		}
		else if (Pnum / 10 == Lnum / 10 || Lnum % 10 == Pnum % 10)
		{
			System.out.println("奖金1000美元");
		}
		else if (Pnum / 10 == Lnum % 10 || Lnum / 10 == Pnum % 10)
		{
			System.out.println("奖金500美元");
		}
		else
		{
			System.out.println("未中奖");
		}
	}
}

import java.util.Scanner;
class lotteryTest
{
	public static void main(String[] args) 
	{
		int Lnum = (int)(Math.random()*90+10);  // �н�����
		System.out.println(Lnum);
		Scanner scan = new Scanner(System.in);
		System.out.println("������һ����λ��");
		int Pnum = scan.nextInt();  //���˺���
		if (Pnum == Lnum)
		{	
			System.out.println("����10000��Ԫ");
		}
		else if (Pnum / 10 == Lnum % 10 && Lnum / 10 == Pnum % 10)
		{
			System.out.println("����3000��Ԫ");
		}
		else if (Pnum / 10 == Lnum / 10 || Lnum % 10 == Pnum % 10)
		{
			System.out.println("����1000��Ԫ");
		}
		else if (Pnum / 10 == Lnum % 10 || Lnum / 10 == Pnum % 10)
		{
			System.out.println("����500��Ԫ");
		}
		else
		{
			System.out.println("δ�н�");
		}
	}
}

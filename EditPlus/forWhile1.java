import java.util.Scanner;
class  forWhile1
{
	public static void main(String[] args) 
	{
		Scanner scan = new Scanner(System.in);
		int positiveNumber =0;
		int negativeNumber =0;
		while(true)
		{
			int i = scan.nextInt();
			if (i >0)
			{
				 positiveNumber++;
			}
			else if (i <0)
			{
				negativeNumber++;
			}
			else
			{
				System.out.println("输入的整数的正数个数为："+positiveNumber);
				System.out.println("输入的整数的负数个数为："+negativeNumber);
				break;
			}
		}
	}
}

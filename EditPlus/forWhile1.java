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
				System.out.println("�������������������Ϊ��"+positiveNumber);
				System.out.println("����������ĸ�������Ϊ��"+negativeNumber);
				break;
			}
		}
	}
}

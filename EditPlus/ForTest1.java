import java.util.Scanner;
class ForTest1 
{
	public static void main(String[] args) 
	{
		Scanner scan = new Scanner(System.in);
		System.out.println("�������һ��������");
		int m = scan.nextInt();
		System.out.println("������ڶ���������");
		int n = scan.nextInt();
		int min = (m<=n)? m : n;
		int max = m*n;
		for (int i =1;i<= max ;i++ )
		{
			if (i %	m == 0 && i % n == 0)
			{
				System.out.println("����"+m+"������"+n+"����С��������:"+i);
				break;
			}
		}
		
		for (int i =min;i>= 1 ;i-- )
		{
			if (m %	i == 0 && n % i == 0)
			{
				System.out.println("����"+m+"������"+n+"�����Լ����:"+i);
				break;
			}
		}
		
		
	}
}


import java.util.Scanner;
class ForTest1 
{
	public static void main(String[] args) 
	{
		Scanner scan = new Scanner(System.in);
		System.out.println("请输入第一个整数：");
		int m = scan.nextInt();
		System.out.println("请输入第二个整数：");
		int n = scan.nextInt();
		int min = (m<=n)? m : n;
		int max = m*n;
		for (int i =1;i<= max ;i++ )
		{
			if (i %	m == 0 && i % n == 0)
			{
				System.out.println("数字"+m+"和数字"+n+"的最小公倍数是:"+i);
				break;
			}
		}
		
		for (int i =min;i>= 1 ;i-- )
		{
			if (m %	i == 0 && n % i == 0)
			{
				System.out.println("数字"+m+"和数字"+n+"的最大公约数是:"+i);
				break;
			}
		}
		
		
	}
}


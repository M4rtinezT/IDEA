import java.util.Scanner
class DogAge 
{
	public static void main(String[] args) 
	{
		Scanner scan= new Scanner(System.in);
		System.out.println("请输入狗的年龄：");
		int dogAge = scan.nextInt();
		if (dogAge <= 0)
		{
			System.out.println("输入错误，请重试");
		}
		else if (dogAge < = 2)
		{
			int humAge = dogAge * 10.5;
			System.out.println("相当于人的年龄：" + humAge );
		}
		else
		{
			int humAge = 21 + (dogAge -2)*4;
			System.out.println("相当于人的年龄：" + humAge );
		}
	}
}

import java.util.Scanner
class DogAge 
{
	public static void main(String[] args) 
	{
		Scanner scan= new Scanner(System.in);
		System.out.println("�����빷�����䣺");
		int dogAge = scan.nextInt();
		if (dogAge <= 0)
		{
			System.out.println("�������������");
		}
		else if (dogAge < = 2)
		{
			int humAge = dogAge * 10.5;
			System.out.println("�൱���˵����䣺" + humAge );
		}
		else
		{
			int humAge = 21 + (dogAge -2)*4;
			System.out.println("�൱���˵����䣺" + humAge );
		}
	}
}

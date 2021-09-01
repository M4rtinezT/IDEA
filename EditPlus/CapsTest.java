import java.util.Scanner; 
class CapsTest 
{
	public static void main(String[] args) 
	{
		Scanner scan = new Scanner(System.in);
		String word = scan.next();
		char c =word.charAt(0);
		switch(c)
		{
		case 'a':
			System.out.println("A");
			break;
		case 'b':
			System.out.println("B");
			break;
		case 'c':
			System.out.println("C");
			break;
		case 'd':
			System.out.println("D");
			break;
		case 'e':
			System.out.println("E");
			break;
		}
		
	}
}

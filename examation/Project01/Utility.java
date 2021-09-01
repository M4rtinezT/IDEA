import java.util.Scanner;
public class Utility 
{ 
	private static Scanner scanner = new Scanner(System.in);
	public static char readMenuSelection()
	{
		char c;
		for (; ; )
		{ 
			String str = readKeyboard();
			c = str.charAt(0);
			if (c!='1'&&c!='2'&&c!='3'&&c!='4')
			{
				System.out.print("ѡ��������������룺");
			}
			else
			{
				break;
			}
		}
		return c;
	}
	public static int readNumber()
	{
		int n;
		for (; ; )
		{
			String str=readKeyboard();
			try
			{
				n=Integer.parseInt(str);
				break;
			}
			catch (NumberFormatException e)
			{
				System.out.print("��������������������룺");
			}
		}

		return n;
	}
	public static String readString()
	{
		String str = readKeyboard();
		return str;
	}
	public static char readConfirmSelection()
	{
		char c;
		for (; ; )
		{
			String str = readKeyboard().toUpperCase();
			c=str.charAt(0);
			if (c=='Y'||c=='N')
			{
				break;
			}
			else
			{
				System.out.print("ѡ��������������룺");
			}
		}
		return c;
	}
	public static String readKeyboard()
	{
		String str = scanner.next();
		return str;
	}
	
}

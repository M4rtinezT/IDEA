import java.util.Scanner;
class CalDate 
{
	public static void main(String[] args) 
	{
		System.out.println("��������ݣ�");
		Scanner scan = new Scanner(System.in);
		int year = scan.nextInt();
		System.out.println("�������·ݣ�");
		int month = scan.nextInt();
		System.out.println("���������ӣ�");
		int date = scan.nextInt();
		int sumDays = 0 ;
		switch(month)
		{
		case 12:
			sumDays += 31;
		case 11:
			sumDays += 30;
		case 10:
			sumDays += 31;
		case 9:
			sumDays += 30;
		case 8:
			sumDays += 31;
		case 7:
			sumDays += 31;
		case 6:
			sumDays += 30;
		case 5:
			sumDays += 31;
		case 4:
			sumDays += 30;
		case 3:
			sumDays += 31;
		case 2:
			if((year%4 ==0 && year%100!=0)||year%400==0)
			{
				sumDays += 29;
			}
			else
			{
				sumDays += 28;
			}
			
		case 1:
			sumDays += date;
			System.out.println("��Ԫ" +year+ "��"+month+"��"+date+"���ǵ���ĵ�"+sumDays+"��");

		}
	}
}

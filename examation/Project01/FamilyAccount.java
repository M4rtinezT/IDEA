class FamilyAccount 
{
	public static void main(String[] args) 
	{
		boolean isFalg = true;
		String details="��֧\t�˻����\t��֧���\t˵    ��\n";
		int balance = 10000;
		while (isFalg)
		{
			System.out.println("-----------------��ͥ��֧�������-----------------\n");
			System.out.println("                   1.��֧��ϸ                       ");
			System.out.println("                   2.�Ǽ�����                       ");
			System.out.println("                   3.�Ǽ�֧��                       ");
			System.out.println("                   4.��    ��\n"                     );
			System.out.print("                  ��ѡ��(1-4):");

		char selection = Utility.readMenuSelection();
		switch (selection)
		{
		case '1':
			System.out.println("-----------------��ǰ��֧��ϸ��¼-----------------\n");
			System.out.println(details);
			System.out.println("----------------------------------------------------");
			break;
		case '2':
			System.out.print("����������:");
			int money = Utility.readNumber();
			System.out.print("��������˵��:");
			String info = Utility.readString();
			balance+=money;
			details+=("����\t"+ balance+"\t\t"+money+"\t\t"+info+"\n");
			System.out.print("-------------------�Ǽ����-------------------\n");
			break;
		case '3':
			System.out.print("����֧�����:");
			int money1 = Utility.readNumber();
			System.out.print("����֧��˵��:");
			String info1 = Utility.readString();
			if (balance>=money1)
			{
				balance-=money1;
				details+=("֧��\t"+ balance+"\t\t"+money1+"\t\t"+info1+"\n");
				System.out.print("-------------------�Ǽ����-------------------\n");
			}
			else
			{
				System.out.println("֧��������ȣ�֧��ʧ�ܣ�");
			}
			break;
		case '4':
			System.out.print("ȷ���Ƿ��˳�(Y/N)��");
			char isExit=Utility.readConfirmSelection();
			if (isExit=='Y')
			{
				isFalg = false;
			}
		}
		}
	}
}

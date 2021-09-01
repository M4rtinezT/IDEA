class PrimeNumberTest	  
{
	public static void main(String[] args) 
	{
		boolean isFalg = true;
		for (int i=2;i<=100;i++)
		{
			for (int j=2;j<math.sqrt(i);j++)
			{
				if (i % j == 0)
				{
					isFalg = false;
					break;
				}
			}
			while(isFalg)
			{
				System.out.println(i);
				break;
			}
			isFalg=true;
		}
	}
}

package day07;

/**
 * 	@Description
 * 	@author TJ Email:mr.tjvin@foxmail.com
 *	@version
 * 	@date 2021年3月17日下午9:00:29
 *	随机不相同数
 */

public class ArrayTest3 {
	public static void main(String[] args) 
	{
		for(int k=0;k<40;k++)	
		{
			int [] array = new int [6];
			array[0]=(int)(Math.random()*30+1);
			for(int i =1 ;i < array.length ; i++)
			{
				array[i]=(int)(Math.random()*30+1);
				for (int j = 0;j<i;j++)
				{
					if (array[j]==array[i])
					{
						i--;
						break;
					}
				}
			}
			for (int i =0 ;i < array.length ; i++)
			{
				System.out.println(array[i]);
				for(int j =0;j<i;j++)
				{
					if(array[j]==array[i]) 
					{
						System.out.println("出错了");
					}
				}
			}
		}
	}

}

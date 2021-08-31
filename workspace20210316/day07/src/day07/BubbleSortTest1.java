package day07;

/**
 * 	@Description
 * 	@author TJ Email:mr.tjvin@foxmail.com
 *	@version
 * 	@date 2021年3月22日下午2:20:26
 *	冒泡算法的简单算法
 */
public class BubbleSortTest1 
{
	public static void main(String[] args) 
	{
		int [] arr = new int[] {34,5,22,-98,6,-76,0,-3};
		boolean isFalg = false ;
		int temp = 0 ;
		do
		{
			isFalg = false ;
			for (int i = 0 ; i < arr.length-1 ; i++)
			{
				if(arr[i] >= arr[i+1])
				{
					temp = arr [i];
					arr[i] = arr [i+1];
					arr [i+1] = temp ;
					isFalg  = true ;
				}
			}
				
		}while(isFalg);
		int temp1 = 0 ;
		for (int i = 0 ; i< arr.length/2 ; i++)
		{
			temp = arr[i];
			arr[i] = arr [arr.length-i-1];
			arr [arr.length-i-1] = temp ;	
		}
		
		
		for (int j = 0 ; j < arr.length ; j++)
		{
			System.out.print(arr[j]+" ");
		}
		
	}

}

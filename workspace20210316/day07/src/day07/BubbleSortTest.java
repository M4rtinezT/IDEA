package day07;

/**
 * 	@Description
 * 	@author TJ Email:mr.tjvin@foxmail.com
 *	@version
 * 	@date 2021年3月18日下午8:47:52
 *  数组的冒泡排序的实现
 */
public class BubbleSortTest {
	public static void main(String[] args) 
	{
		int[] arr = new int[] {5,8,7,-5,-7,-8,10,3,4,5,2,4,5,48,2,3,4,-99,-2,-23,0};
		int temp = 0;
		boolean isFalg = false;
		do
		{
			isFalg = false;
			for (int i = 0; i < arr.length-1 ; i++)
			{
				if (arr[i]> arr[i+1])
				{
					temp=arr[i];
					arr[i]=arr[i+1];
					arr[i+1]=temp;
					isFalg = true;
				}
			}
		}while(isFalg);
		
		for (int i = 0; i < arr.length ; i++)
		{
			System.out.print(arr[i]+" ");
		}
	}
}

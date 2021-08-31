package day07;

/**
 * 	@Description
 * 	@author TJ Email:mr.tjvin@foxmail.com
 *	@version
 * 	@date 2021年3月17日下午10:19:51
 *	随机数组的最大值，最小值，平均值和总和
 */
public class ArrayTest5 
{
	public static void main(String[] args) 
	{
		int[] array = new int[10];
		for (int i =0 ; i <array.length ; i++)
		{
			array[i]=(int)((Math.random()*90)+10);
		}
		int sum=0;
		double avg = 0.0;
		int max = 0;
		int min=array[0];
		for (int i = 0 ; i <array.length ; i++ )
		{
			if (array[i] > max )
			{
				max = array[i];
			}
			if (array[i] < min ) 
			{
				min=array[i];
			}
			sum+=array[i];
		}
		avg = sum / 10;	
		System.out.println("所有元素的最大值是:"+max);
		System.out.println("所有元素的最小值是:"+min);
		System.out.println("所有元素的和是:"+sum);
		System.out.println("所有元素的平均值:"+avg);
	}

}

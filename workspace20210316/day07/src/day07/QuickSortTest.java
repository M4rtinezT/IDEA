package day07;

/**
 * 	@Description
 * 	@author TJ Email:mr.tjvin@foxmail.com
 *	@version
 * 	@date 2021年3月22日下午2:20:07
 *	快速排序的简单迭代算法
 */
public class QuickSortTest 
{
	public static void quickSort(int[] arr,int low, int high)
	{
		int i,j,temp,t;
		if(low>high)
		{
			return;
		}
		i = low ;
		j = high;
		//temp是基准位
		temp = arr[low];
		while(i < j)
		{
			while(temp <= arr[j]&&i<j)
			{
				j--;
			}
			while(temp >= arr[i]&&i<j)
			{
				i++;
			}
			if(i < j)
			{
				t = arr[j];
				arr[j] = arr[i];
				arr[i] = t;	
			}
		}
		arr[low] = arr [i];
		arr[i] = temp;
		quickSort(arr,low,j-1);
		quickSort(arr,j+1,high);	
	}
	public static void main(String[] args)
	{
        int[] arr = {10,7,2,4,7,62,3,4,2,1,8,9,19};
        quickSort(arr, 0, arr.length-1);
    }

}

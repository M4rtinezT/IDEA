package day07;
/**
 * 	@Description
 * 	@author TJ Email:mr.tjvin@foxmail.com
 *	@version
 * 	@date 2021年3月17日下午10:22:08
 *	数组的复制、反转、查找
 */
public class ArreyTest6 
{
	public static void main(String[] args) 
	{
		int [] array1;
		int [] array2;
		array1 = new int[] {2,3,5,7,11,13,17,19};
		for (int i =0 ; i <array1.length;i++)
		{
			System.out.print(array1[i]+"\t");
		}
		array2 = array1;//只是赋了一个地址值，相当于快捷方式
		int [] array3 = new int [array1.length]; // 复制数组
		for (int i =0 ; i<array1.length;i++)
		{
			array3[i] = array1[i];
		}
	    //数组的反转
		for (int i=0;i<array1.length/2;i++)
		{
			int temp = array1[i];
			array1[i]=array3[array1.length-1];
			array3[array1.length-1]=temp;
		}
		
		//查找（搜索）
		//线性查找：
		int [] array = new int[] {2,3,5,7,11,13,17,19};
		int dest = 7;
		for (int i =0;i<array.length;i++)
		{
			if(dest==array[i])
			{
				System.out.print(dest+" "+(i+1));
				break;
			}
			
		}
		System.out.println();
		//二分法查找：数组必须有序；
		int [] array5 = new int[] {-3,-1,0,2,3,5,7,11,13,17,19};
		int dest1 = 5;
		int head = 0;//初始的首索引
		int end = array5.length - 1;  //初始的末索引
		while (head <= end)
		{
			int middle = (head + end )/2;
			if (dest1 == array5[middle])
			{
				System.out.print("找到了指定元素位置为第"+(middle +1) +"个");
				break;
			}
			else if (dest1 > array5[middle])
			{
				head = middle + 1;
			}
			else
			{
				end = middle - 1;
			}
			
		}
		//排序算法
		
		
	}

}

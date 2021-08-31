package day07;

import java.util.Scanner;
/**
 * 	@Description
 * 	@author TJ Email:mr.tjvin@foxmail.com
 *	@version
 * 	@date 2021年3月17日下午10:20:37
 *	回形数组的输出
 */
public class ArreyTest4 
{
	public static void main(String[] args) 
	{
		Scanner scan =new Scanner(System.in);
		System.out.print("请输入一个自然数：");
		int number = scan.nextInt();
		int [][] array = new int [number][number];
		int count = 1 ;
		for(int t =0;t<(number+1)/2;t++)	
		{
			for (int i = t ; i < number-t;i++)
			{
				array[t][i]=count;
				count++;
			}
			for (int i = t ; i < number-1-t;i++)
			{
				array[i+1][number-1-t]=count;
				count++;
			}
			for (int i = t ; i < number-1-t;i++)
			{
				array[number-t-1][number-i-2]=count;
				count++;
			}
			for (int i = t ; i < number-2-t;i++)
			{
				array[number-i-2][t]=count;
				count++;
			}
		}
		
		for (int i = 0; i < array.length ; i++)
		{
			for (int j = 0 ; j < array.length ; j++)
			{
				System.out.print(array[i][j]+" ");
			}
			System.out.println();
		}
	}
	

}

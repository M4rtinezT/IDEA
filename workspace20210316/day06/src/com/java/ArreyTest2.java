package com.java;
import java.util.Scanner;
public class ArreyTest2 
{
	public static void main(String[] args) 
	{
		Scanner scan = new Scanner(System.in);
		System.out.println("请输入学生个数：");
		int count=scan.nextInt();
		int[] score  = new int[count];
		System.out.println("请输入"+count+"个成绩");
		int max = 0;
		for (int i = 0;i<count;i++)
		{
			score[i]=scan.nextInt();
			if (score[i]>max)
			{
				max=score[i];
			}
		}
		String grade = "";
		for (int i = 0;i<count;i++)
		{
			if(max-score[i]<=10)
			{
				grade = "A";
			}
			else if (max-score[i]<=20)
			{
				grade = "B";
			}
			else if (max-score[i]<=30)
			{
				grade = "C";
			}
			else
			{
				grade = "D";
			}
			System.out.println("Student "+(i+1)+" score is "+score[i]+" grade is "+grade);
		}
	}
}

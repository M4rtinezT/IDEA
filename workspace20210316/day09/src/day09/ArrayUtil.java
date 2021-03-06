package day09;

public class ArrayUtil {
	//求数组的最大值
	public int Max(int[] arr) {
		int max = arr[0];
		for (int i = 0 ; i < arr.length ; i++) {
			if(arr[i]>=max) {
				max = arr[i];
			}
		}
		System.out.println("最大值是："+max);
		return max;
	}
	
	//求数组的最小值
	public int Min(int[] arr) {
		int min = arr[0];
		for (int i = 0 ; i < arr.length ; i++) {
			if(arr[i]<=min) {
				min = arr[i];
			}
		}
		System.out.println("最小值是："+min);
		return min;
	}	
	
	//求数组的总和
	public int Sum(int[] arr) {
		int sum = 0;
		for (int i = 0 ; i < arr.length ; i++) {
			sum+= arr[i];
		}
		System.out.println("总和是："+sum);
		return sum;
	}
	
	//求数组的平均值
	public int Average(int[] arr) {
		int average;
		ArrayUtil Temp = new ArrayUtil();
		average = Temp.Sum(arr) / arr.length;
		System.out.println("平均值是："+average);
		return average;
	}
	
	//反转数组
	public void Reverse(int [] arr) {
		int temp;
		for (int i = 0 ; i < arr.length/2 ; i++) {
			temp = arr[i];
			arr[i] = arr[arr.length-1-i];
			arr[arr.length-1-i] = temp;
		}
	}
	
	//复制数组
	public int[] Copy(int[] arr) {
		int [] copy = new int [arr.length];
		for(int i = 0 ; i < arr.length/2 ; i++) {
			copy[i] = arr[i];
		}
		return copy;
	}
	
	//数组排序
	public void Sort(int[] arr) {
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
	}
	
	//遍历数组
	public void Traverse(int[] arr) {
		for(int i = 0 ; i < arr.length ; i++) {
			System.out.print(arr[i]+" ");
		}
		System.out.println();
	}
	//查找指定元素
	public int Search(int[] arr, int dest) {
		for(int i = 0 ; i < arr.length ; i++) {
			if(arr[i] == dest) {
				System.out.print("元素"+dest+"找到了,在数组的第"+i+"位置");
				System.out.println();
				return i;
			}
		}
		System.out.print("未找到指定元素");
		System.out.println();
		return -1;			
	}	
}

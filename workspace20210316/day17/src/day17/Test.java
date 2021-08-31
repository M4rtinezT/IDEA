package day17;

public class Test {
	public static void main(String[] args) {
		int a = 12;
		String str = String.valueOf(a);
		System.out.println(str.length());
		int[] arr = new int[10];
		System.out.println(arr.length);
	}
}

class Solution {
    /**
     * 	@Description leetcode 7
     * 	@author TJ 
     * 	@date 2021年4月14日下午7:35:53
     *	@param x
     *	@return
     */
    public int reverse(int x) {
        if(x > Math.pow(2,31) -1 || x < -Math.pow(2,31) || x ==0){
            return 0;
        }else{
            String temp = String.valueOf(Math.abs(x));
            int num = temp.length();
            String ans = "";
            for (int i = 0 ; i < num ; i++) {
            	ans = ans + temp.charAt(num - 1 -i);
            }
            return (int)Long.parseLong(ans);
        }
//        System.out.println("asdad");
    }
}

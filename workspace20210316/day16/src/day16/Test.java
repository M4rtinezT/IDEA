package day16;

public class Test {
	public static void main(String[] args) {
		String str = "asdasd";
		char a = 'a';
		System.out.println(str+a);
	}
}

class Solution {
    public String replaceSpace(String s) {
        String temp = null;
        for(int i = 0 ; i < s.length() ; i++){
            if(s.charAt(i) != ' '){
                temp+= s.charAt(i);
            }else{
                temp+= "%20";
            }
        }
        return temp;
    }
}
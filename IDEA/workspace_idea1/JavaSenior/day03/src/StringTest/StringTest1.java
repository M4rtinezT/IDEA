package StringTest;
/**
 * 字符串习题
 * @author TJ
 * 2021-04-30  21:26
 */

public class StringTest1 {
    public static void main(String[] args) {
        String str1 = "asd ada sda sd";
        String str2 = "    asd ad";
        String str3 = "as dad     ";
        String str4 = "asd ad";
        System.out.println(Test.trimTest(str1));
        System.out.println(Test.trimTest(str2));
        System.out.println(Test.trimTest(str3));
        System.out.println(Test.trimTest(str4));
        System.out.println(Test.reverseTest(str4));
        System.out.println(Test.timesTest(str1, "asd"));
        System.out.println("**************************");
        System.out.println(Test.sameString("jadhadhjakldhjkhakdhkadhl", "jakl"));
        System.out.println(Test.sameString("acaaaaaaaaaab", "ac"));
    }
}
class Test{
    //模拟一个trim()方法，去除字符串两端的空格
    public static String trimTest(String str){
        char[] chars = str.toCharArray();
        int start = 0 ;
        int end = chars.length;
        for(int i = 0 ; i < chars.length ; i++){
            if(chars[i] == ' '){
                start = i + 1 ;
            }
            else{
                break;
            }
        }
        for(int j = chars.length - 1  ; j > 0 ; j--){
            if(chars[j] == ' '){
                end = j ;
            }
            else{
                break;
            }
        }
        char[] ans = new char[end - start];
        int count = 0 ;
        for (int i = start ; i < end ; i++){
            ans[count] = chars[i];
            count++;
        }
        return new String(ans);
    }
    //将一个字符串进行反转，将指定部分反转
    public static String reverseTest(String str){
        char[] chars = str.toCharArray();
        char[] ans = new char[chars.length];
        for(int i = 0 ; i < chars.length ; i++){
            ans[i] = chars[chars.length - i - 1];
        }
        return new String(ans);
    }
    //获取一个字符串在另一个字符串中出现的次数
    public static int timesTest(String target,String sub){
        char[] targetArray = target.toCharArray();
        char[] subArray = sub.toCharArray();
        int count = 0 ;
        for(int i = 0 ; i < target.length(); i++){
            if(subArray[0] == targetArray[i]){
                if(sub.length() == 1){
                    count++;
                }else{
                    for(int j = 1 ; j < sub.length(); j++){
                        if(subArray[j] == targetArray[i+j]){
                            if(j == sub.length() - 1 ){
                                count++;
                            }
                        }else{
                            break;
                        }
                    }
                }
            }
        }
        return count;
    }
    //获取两个字符串的最大相同子字符串
    public static String sameString(String str,String anotherStr){//str长字符串
        if(str.contains(anotherStr)){
            return anotherStr;
        }else{
            for(int i = anotherStr.length() - 1; i > 0  ; i--){//长度i
                for(int j = 0 ; j < anotherStr.length() - i ; j++){//起始j
                    String substring = anotherStr.substring(j , j + i  );
                    if(str.contains(substring)){
                        return substring;
                    }
                }
            }
            return "不含有相同字符";
        }
    }
}
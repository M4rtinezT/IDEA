package day17;

public class Main {
    public static void main(String[] args) {
//		System.out.println(test(1000000, 1000000));
//		System.out.println(test(0, 1000000));
//		System.out.println(test(1000000, 0));
//		System.out.println(test(-1000000, -1000000));
//		System.out.println(test(0, 0));
//		System.out.println(test(999999, 999999));
//		System.out.println(test(999999, -999999));
		System.out.println(test(999999, 0));
		System.out.println(test(0, -1000000));
		System.out.println(test(0, 456));
		System.out.println(test(0, 7892));
		System.out.println(test(0, 1));
		System.out.println(test(00, -1));
		System.out.println(test(00, -546));
		
		
	}
	
	
	
	public static String test(int a,int b) {
        
        int sum = a + b ;
 
        if(sum > 0){
            return getCommas(String.valueOf(sum));
        }else if (sum == 0){
            return "0";
        }
        else{
            sum = Math.abs(sum);
            return "-"+getCommas(String.valueOf(sum));
        }
    }
    public static String getCommas(String str){
        String answer = "";
        if(str.length() <= 3){
            return str;
        }else{
            for (int i = 0 ; i < 3 ; i++){
                answer = str.charAt(str.length() - i - 1) + answer;
            }
            answer = "," + answer ; 
            if(str.length() <= 6){
                for (int i = 3 ; i < str.length() ; i++){
                    answer = str.charAt(str.length() - i - 1) + answer;
                }
                return answer;
            }
            else{
                for (int i = 3 ; i < 6 ; i++){
                    answer = str.charAt(str.length() - i - 1) + answer;
                }
                answer = "," + answer ; 
                answer = str.charAt(0) + answer;  
                return answer;
            }
        }
    }
}

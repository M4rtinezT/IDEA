package javaTest;

import java.text.DecimalFormat;

/**
 * @author TJ
 * @create 2021-05-08  21:55
 */
public class SolutionTest {
    public static void main(String[] args) {
        double a = Solution.myPow(5, -1);
        System.out.println(a);
    }

}


class Solution {
    public static double myPow(double x, int n) {
        double res = 1.0;
        if(n == 0){
            return 1.00000;
        }
        if( n > 0){
            for(int i = 0 ; i < n ; i++){
                res *= x ;
            }
            return res ;
        }
        n = -n ;
        DecimalFormat dF = new DecimalFormat("0.00000");
        x = Double.parseDouble(dF.format((float)1/x));
        for(int i = 0 ; i < n ; i++){
            res = res * x ;
            System.out.println(res);
        }
        return res ;

    }
}
package day17;
import java.util.Scanner;
/**
 * 	@Description
 * 	@author TJ Email:mr.tjvin@foxmail.com
 *	@version
 * 	@date 2021年4月21日下午10:10:56
 *
 */
class Callatz{
    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        int a = scan.nextInt();
        int count = 0;
        for(;;){
            if(a % 2 == 0){
                a = a / 2;
                count+=1;
            }else if(a != 1){
                a = (3*a+1)/2;
                count+=1;
            }else{
                break;
            }
        }
        System.out.println(count);
    } 
}
package exer.test;

import org.junit.Test;

import java.util.Arrays;
import java.util.function.Function;

/**
 * @author TJ
 * @create 2021-05-27  19:07
 */
public class ArrayRefTest {
    //数组引用
    //Function中的R apply(T t)
    @Test
    public void test1() {
        Function<Integer,String[]> func1 = length -> new String[length];
        String[] arr1 = func1.apply(5);
        System.out.println(Arrays.toString(arr1));

        System.out.println("************************************************");

        Function<Integer,String[]> func2 = String[] :: new;
        String[] arr2 = func2.apply(5);
        System.out.println(Arrays.toString(arr2));
    }
}

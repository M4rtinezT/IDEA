package exer.test;

import org.junit.Test;

import java.util.Optional;

/**
 * @author TJ
 * @create 2021-05-27  20:40
 */
public class OptionalTest {
    @Test
    public void test1(){
        Optional<Object> op1 = Optional.empty();
        if(!op1.isPresent()){//Optional封装的数据是否包含数据
            System.out.println("数据为空");
        }
    }

    @Test
    public void test2(){
        String str = "Hello";
        //of(T t)：封装数据t生成Optional对象，要求t非空，否则报错
        Optional<String> op1 = Optional.of(str);

        String str1 = op1.get();
        System.out.println(str1);
    }
    @Test
    public void test3(){
        String str = "Hello World";
        //ofNullable(T t):封装数据t赋给Optional内部的value,不要求非空
        Optional<String> op1 = Optional.ofNullable(str);
        //orElse(T t):如果Optional内部的value非空，则返回此value值，如果value空，返回t
        String str2 = op1.orElse("Hello China");

        System.out.println(str2);

    }
}

package exer.test;

import org.junit.Test;

import java.io.PrintStream;
import java.util.Comparator;
import java.util.function.BiPredicate;
import java.util.function.Consumer;
import java.util.function.Function;

/**
 * @author TJ
 * @create 2021-05-25  21:53
 */
public class FunctionalTest1 {
    //格式1： 对象：：非静态方法
    //Consumer中的void accept(T t)
    //PrintStream中的void println(T t)
    @Test
    public void test1(){

        PrintStream ps1 = System.out;
        ps1.println("北京");

        System.out.println("*****************************");
        //Lambda表达式
        Consumer<String> con1 = str -> System.out.println(str);
        con1.accept("北京");

        System.out.println("*****************************");
        //方法引用
        PrintStream ps = System.out;
        Consumer<String> con2 = ps::println;
        con2.accept("北京");
    }
    //格式2：类：：静态方法
    //Comparator中的int compare(T t1,T t2)
    //Integer中的int compare(T t1,T t2)
    @Test
    public void test2(){
        Comparator<Integer> com = new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                if(o1 == o2) return 0;
                if(o1 > o2) return 1;
                return -1;
            }
        };
        System.out.println(com.compare(12, 21));
        System.out.println("******************************************");
        //Lambda表达式
        Comparator<Integer> com1 = (t1,t2) -> Integer.compare(t1,t2);
        System.out.println(com1.compare(12,21));

        System.out.println("******************************************");
        //方法引用
        Comparator<Integer> com2 = Integer::compare;
        System.out.println(com2.compare(12,21));
    }
    //Function中的R apply(T t)
    //Math中的Long round(Double d)
    @Test
    public void test3(){
        Function<Double,Long> func = new Function<Double, Long>() {
            @Override
            public Long apply(Double aDouble) {
                return Math.round(aDouble);
            }
        };
        System.out.println("******************************");

        Function<Double,Long> func1 = d -> Math.round(d);
        System.out.println(func1.apply(12.3));

        System.out.println("******************************");

        Function<Double,Long> func2 = Math::round;
        System.out.println(func2.apply(12.3));

    }
    //格式3：类：：非静态方法
    //Comparator中的int compare(T t1,T t2)
    //String中的int t1.compareTo(T t2)
    @Test
    public void test4(){
        Comparator<String> com1 = (s1,s2) -> s1.compareTo(s2);
        System.out.println(com1.compare("abc","abd"));

        System.out.println("******************************");

        Comparator<String> com2 = String::compareTo;
        System.out.println(com2.compare("abc","abd"));
    }
    //BiPredicate中的Boolean test(T t1,T t2)
    //String中的Boolean t1.equals(t2)
    @Test
    public void test5(){
        BiPredicate<String,String> pre1 = (s1,s2) -> s1.equals(s2);
        System.out.println(pre1.test("abc","abc"));

        System.out.println("*****************************************");
        BiPredicate<String,String> pre2 = String::equals;
        System.out.println(pre2.test("abc","abc"));

    }
    //Function中的R apply(T t)
    //Employee中的String getName()
    @Test
    public void test6(){
        Employee employee = new Employee(1001,"Jerry",6800);

        Function<Employee,String> func1 = e -> e.getName();
        System.out.println(func1.apply(employee));

        System.out.println("************************************");

        Function<Employee,String> func2 = Employee::getName;
        System.out.println(func2.apply(employee));


    }


}

class Employee{
    private int id;
    private String name;
    private double salary;

    public Employee() {
    }

    public Employee(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public Employee(int id) {
        this.id = id;
    }

    public Employee(int id, String name, double salary) {
        this.id = id;
        this.name = name;
        this.salary = salary;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", salary=" + salary +
                '}';
    }
}
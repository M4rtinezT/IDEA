package exer.test;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * @author TJ
 * @create 2021-05-27  19:16
 */
public class StreamAPITest {
    //步骤一：创建Stream
    //方式一：通过集合
    @Test
    public void test1(){
        List<Employee> employees = EmployeeData.getEmployees();

        //default Stream<E> stream():返回一个顺序流
        Stream<Employee> stream = employees.stream();
        //default Stream<E> parallelStream():返回一个程序流
        Stream<Employee> parallelStream = employees.parallelStream();
    }
    //方式二：通过数组
    @Test
    public void test2(){
        int[] arr = new int[]{1,2,3,4,5,6};
        //调用Arrays类的static<T> Stream<T> stream(T[] array):返回一个流
        IntStream stream = Arrays.stream(arr);

        Employee e1 = new Employee(1001,"Tom");
        Employee e2 = new Employee(1002,"Jerry");

        Employee[] arr1 = new Employee[]{e1,e2};
        Stream<Employee> stream1 = Arrays.stream(arr1);
    }
    //方式三：通过stream的of()
    @Test
    public void test3(){
        Stream<Integer> stream = Stream.of(1,2,3,4,5,6);

    }
    //方式四：创建无限流
    @Test
    public void test4(){
        //迭代
        //public static<T> Stream<T> iterate(final T seed,final UnaryOperator<T> f)
        //遍历前十个偶数
        Stream.iterate(0,t -> t+2).limit(10).forEach(System.out::println);

        //生成
        //public static<T> Stream<T> generate(Supplier<T> s)
        Stream.generate(Math::random).limit(10).forEach(System.out::println);
    }
}

class EmployeeData{
    public static List<Employee> getEmployees(){
        List<Employee> list = new ArrayList<>();
        list.add(new Employee(1001, "Tom", 3000));
        list.add(new Employee(1002, "Jerry", 6000));
        return list;
    }


}
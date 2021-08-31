package exer.test;

import org.junit.Test;

import java.util.function.Function;
import java.util.function.Supplier;

/**
 * @author TJ
 * @create 2021-05-27  18:38
 */
public class ConstructorRefTest {
    //构造器引用
    //Supplier中的T get()
    //Employee的空参构造器：Employee()
    @Test
    public void test1(){
        Supplier<Employee> sup = new Supplier<Employee>() {
            @Override
            public Employee get() {
                return new Employee();
            }
        };
        System.out.println("******************************");

        Supplier<Employee> sup1 = () -> new Employee();
        System.out.println(sup1.get());

        System.out.println("******************************");

        Supplier<Employee> sup2 = Employee::new ;
        System.out.println(sup2.get());

    }
    //Function中的R apply(T t)
    @Test
    public void test2(){
        Function<Integer,Employee> func1 = id -> new Employee(id);
        Employee employee = func1.apply(1001);
        System.out.println(employee);

        System.out.println("******************************");

        Function<Integer,Employee> func2 = Employee::new;
        Employee employee1 = func2.apply(1001);
        System.out.println(employee1);

    }

}

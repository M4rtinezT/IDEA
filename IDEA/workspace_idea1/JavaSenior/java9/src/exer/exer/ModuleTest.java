package exer.exer;

import exer.test.Person;

import java.util.HashSet;
import java.util.Set;

/**
 * @author TJ
 * @create 2021-05-27  21:40
 */
public class ModuleTest {
    public static void main(String[] args) {

        Person p1 = new Person("Tom",21);
        System.out.println(p1);
        Set hashset = new HashSet();
        Object[] objects = hashset.toArray();
    }
}

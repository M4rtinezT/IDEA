package test1;

import java.util.Comparator;

/**
 * @author TJ
 * @create 2021-05-06  16:31
 */
public class homeworkTest2 {
}


class Person implements Comparable{
    private String name;
    private int age;

    @Override
    public int compareTo(Object obj) {
        if(obj instanceof String){
            String name = (String)obj;
            return this.name.compareTo(name);
        }
        return 0;
    }
}
class Person1 implements Comparator{
    private int age;

    @Override
    public int compare(Object o1, Object o2) {
        return 0;
    }
}
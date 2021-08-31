package exer.test;

import java.util.Comparator;
import java.util.Iterator;
import java.util.Objects;
import java.util.TreeSet;

/**
 * @author TJ
 * @create 2021-05-11  14:30
 */
public class TreeSetTest {
    public static void main(String[] args) {
        Comparator com = new Comparator() {
            @Override
            public int compare(Object o1, Object o2) {
                if(o1 instanceof User && o2 instanceof User){
                    return ((User) o1).getAge() - ((User) o2).getAge();
                }
                return 0;
            }
        };
        TreeSet tre = new TreeSet(com);
        tre.add(new User("Tom",12));
        tre.add(new User("Able",11));
        tre.add(new User("Buick",21));
        tre.add(new User("NiceTrick",15));
        Iterator iterator = tre.iterator();
        while(iterator.hasNext()){
            System.out.println(iterator.next());
        }
    }

}
class User implements Comparable{
    private String name;
    private int age;

    public User() {
    }

    public User(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return age == user.age && Objects.equals(name, user.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, age);
    }

    @Override
    public int compareTo(Object o) {
        if(o instanceof User){
            return this.getName().compareTo(((User) o).getName());
        }
        return 0;
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
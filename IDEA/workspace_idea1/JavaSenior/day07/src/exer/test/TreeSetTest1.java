package exer.test;

import java.util.Comparator;
import java.util.Iterator;
import java.util.TreeSet;

/**
 * @author TJ
 * @create 2021-05-11  15:09
 */
public class TreeSetTest1 {
    public static void main(String[] args) {
        Comparator com = new Comparator() {
            @Override
            public int compare(Object o1, Object o2) {
                if(o1 instanceof Employee && o2 instanceof Employee){
                    return ((Employee) o1).getMyDate().getYear()*365 +
                            ((Employee) o1).getMyDate().getMonth()*30+
                            ((Employee) o1).getMyDate().getDay() -
                            ((Employee) o2).getMyDate().getYear()*365 -
                            ((Employee) o1).getMyDate().getMonth()*30 -
                            ((Employee) o1).getMyDate().getDay();

                }
                return 0;
            }
        };
        TreeSet tre = new TreeSet(com);

        tre.add(new Employee("Tom",25,new MyDate(1995,12,4)));
        tre.add(new Employee("Able",20,new MyDate(1999,12,4)));
        tre.add(new Employee("Buick",29,new MyDate(1991,12,4)));
        tre.add(new Employee("ZW",28,new MyDate(1992,12,4)));
        tre.add(new Employee("Mary",24,new MyDate(1996,12,4)));
        Iterator iterator = tre.iterator();
        while(iterator.hasNext()){
            System.out.println(iterator.next());
        }
    }
}
class Employee implements Comparable{
    private String name;
    private int age;
    private MyDate myDate;

    public Employee() {
    }

    public Employee(String name, int age, MyDate myDate) {
        this.name = name;
        this.age = age;
        this.myDate = myDate;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public MyDate getMyDate() {
        return myDate;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setMyDate(MyDate myDate) {
        this.myDate = myDate;
    }

    @Override
    public int compareTo(Object o) {
        if(o instanceof Employee){
            return this.getName().compareTo(((Employee) o).getName());
        }
        return 0;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", myDate:" + myDate +
                '}';
    }
}
class MyDate{
    private int year;
    private int month;
    private int day;

    public MyDate() {
    }

    public MyDate(int year, int month, int day) {
        this.year = year;
        this.month = month;
        this.day = day;
    }

    public int getYear() {
        return year;
    }

    public int getMonth() {
        return month;
    }

    public int getDay() {
        return day;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public void setMonth(int month) {
        this.month = month;
    }

    public void setDay(int day) {
        this.day = day;
    }

    @Override
    public String toString() {
        return year +
                "-" + month +
                "-" + day;
    }
}
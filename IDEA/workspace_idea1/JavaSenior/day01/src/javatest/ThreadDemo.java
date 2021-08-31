package javatest;

/**
 * 创建两个分线程 一个遍历100以内的偶数，一个遍历100以内的奇数
 * @author TJ
 * @create 2021-04-22  16:30
 */
public class ThreadDemo {
    public static void main(String[] args) {
//        ThreadTest1 t1 = new ThreadTest1();
//        ThreadTest2 t2 = new ThreadTest2();
//        t1.start();
//        t2.start();
        new ThreadTest1().start();

    }
}

class ThreadTest1 extends Thread{
    @Override
    public void run() {
        for (int i = 0 ; i < 100 ; i++){
            if(i % 2 == 0){
                System.out.println(i +""+ '*');
            }
        }
    }
}

class ThreadTest2 extends Thread{
    @Override
    public void run() {
        for (int i = 0 ; i < 100 ; i++){
            if(i % 2 != 0){
                System.out.println(i);
            }
        }
    }
}
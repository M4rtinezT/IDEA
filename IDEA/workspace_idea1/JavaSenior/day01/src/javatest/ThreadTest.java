package javatest;

/**
 *
 * 遍历100内所有的偶数
 * @author TJ
 * @create 2021-04-22  15:52
 */
class MyThread extends Thread {
    @Override
    public void run() {
        for (int i = 0 ; i < 100 ; i++){
            if(i % 2 == 0 && i != 0){
                System.out.println(i);
            }
        }
    }
}
public class ThreadTest {
    public static void main(String[] args) {
        MyThread t1 = new MyThread();
        t1.start();
        for (int i = 0 ; i < 100 ; i++){
                System.out.println(i + "*");
        }

    }
}


package javatest;

/**
 * 创建三个窗口卖票，总票数为100张
 * @author TJ
 * @create 2021-04-22  20:47
 */
public class WindowsTest1 {
    public static void main(String[] args) {
        Window w = new Window();
        Thread t1 = new Thread(w);
        Thread t2 = new Thread(w);
        Thread t3 = new Thread(w);

        t1.setName("窗口1");
        t2.setName("窗口2");
        t3.setName("窗口3");

        t1.start();
        t2.start();
        t3.start();
    }
}


class Window implements Runnable{
    private int ticket = 100;
    @Override
    public void run() {
        while(true){
            if(ticket > 0){
                System.out.println(Thread.currentThread().getName() +"买票"+ticket);
                ticket--;
            }else{
                break;
            }
        }
    }
}
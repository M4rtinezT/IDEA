package javaTest02;

/**
 * 创建三个窗口卖票，总票数为100张
 * 重票和错票的线程安全问题
 * 原因：某线程程操作车票的过程中，尚未完成操作，其他线程参与进来
 * 如何解决：当一个线程a操作ticket时，其他线程不能参与进来，直至线程a操作完ticket时，其他线程才可以
 * 开始操作，即使线程a出现阻塞，也不可改变
 * 再Java中，通过同步机制，来解决线程的安全问题
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

    Object obj = new Object();
    @Override
    public void run() {
        while(true){
            synchronized(obj){
                if(ticket > 0){
                    System.out.println(Thread.currentThread().getName() +"买票"+ticket);
                    ticket--;
                }else{
                    break;
                }
            }
        }
    }
}
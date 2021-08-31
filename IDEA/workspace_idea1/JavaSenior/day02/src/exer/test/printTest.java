package exer.test;

/**
 * 打印100以内的自然数 线程交叉打印
 * @author TJ
 * @create 2021-04-24  22:29
 */
class Number implements Runnable{
    private int number = 1 ;
    @Override
    public void run() {
        while(true){
            synchronized (this) {
                notify();
                if(number <= 100){
                    System.out.println(Thread.currentThread().getName()+":"+number);
                    number++;
                    try {
                        //使得调用wait方法的线程进入阻塞状态
                        wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }else{
                    break;
                }
            }
        }
    }
}

public class printTest {
    public static void main(String[] args) {
        Number r1 = new Number();
        Thread t1 = new Thread(r1);
        Thread t2 = new Thread(r1);

        t1.setName("线程一");
        t2.setName("线程二");

        t1.start();
        t2.start();

    }
}

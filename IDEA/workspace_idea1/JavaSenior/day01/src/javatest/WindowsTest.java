package javatest;

/**
 *
 * 创建三个窗口卖票，总票数为100张
 *
 * @author TJ
 * @create 2021-04-22  20:11
 */
public class WindowsTest {
    public static void main(String[] args) {
        Windows w1 = new Windows();
        Windows w2 = new Windows();
        Windows w3 = new Windows();

        w1.setName("窗口1");
        w2.setName("窗口2");
        w3.setName("窗口3");

        w1.start();
        w2.start();
        w3.start();
    }
}


class Windows extends Thread{
    private int ticket = 100;

    @Override
    public void run() {
        while(true){
            if(ticket > 0){
                System.out.println(getName() + ":买票，票号为：" + ticket);
                ticket--;
            }else{
                break;
            }
        }
    }
}
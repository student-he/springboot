package lesson.thread;

public class UseRunnable implements Runnable {

    //票
    private int ticketNum = 10;

    @Override
    public void run() {
        while (true) {
            if (ticketNum <= 0) {
                break;
            }
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() + "拿到了第" + ticketNum-- + "张票");
        }
    }

    public static void main(String[] args) {
        UseRunnable ticket = new UseRunnable();
        new Thread(ticket, "小明").start();
        new Thread(ticket, "小强").start();
        new Thread(ticket, "黄牛").start();
    }
}

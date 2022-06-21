package lesson.thread;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * @author Mr He
 */
public class ThreadNew {

    public static void main(String[] args) {

        new ExtendsThread().start();

        new Thread(new ImplementsRunnable()).start();

        FutureTask<Integer> futureTask = new FutureTask<>(new ImplementsCallable());
        new Thread(futureTask).start();

        try {
            Integer integer = futureTask.get();
            System.out.println(integer);
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }
    }
}

//继承Thread类
class ExtendsThread extends Thread {
    @Override
    public void run() {
        System.out.println("继承Thread类");
    }
}

//实现Runnable接口
class ImplementsRunnable implements Runnable {

    @Override
    public void run() {
        System.out.println("实现Runnable接口");
    }
}

//实现callable接口
class ImplementsCallable implements Callable<Integer> {

    @Override
    public Integer call() throws Exception {
        System.out.println("实现callable接口");
        return 100;
    }
}
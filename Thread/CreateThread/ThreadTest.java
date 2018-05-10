package Thread;

import java.util.Random;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

public class ThreadTest
{
    public static void main(String[] args)
    {
        //1:继承Thread类创建线程
        MyThread myThread = new MyThread();
        myThread.start();

        //2:实现Runnable接口创建线程
        MyThread2 myThread2 = new MyThread2();
        Thread thread = new Thread(myThread2);
        thread.start();

        //3:Callable任务借助FutureTask运行
        CallableAndFutureTest();
    }

    private static void CallableAndFutureTest()
    {
        Callable<Integer> callable = new Callable<Integer>()
        {
            public Integer call() throws Exception
            {
                return new Random().nextInt(100);
            }
        };
        FutureTask<Integer> future = new FutureTask<Integer>(callable);
        new Thread(future).start();
        try
        {//可能做一些事情
            Thread.sleep(5000);
            System.out.println(future.get());
        } catch (InterruptedException e)
        {
            e.printStackTrace();
        } catch (ExecutionException e)
        {
            e.printStackTrace();
        }
    }

}


class MyThread2 implements Runnable
{
    @Override
    public void run()
    {
        System.out.println("sadfa");
    }
}


class MyThread extends Thread
{
    @Override
    public void run()
    {
        super.run();
        System.out.println("1322");
    }
}

package Thread;

import java.util.Random;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

//总结：
//①可以获得任务执行返回值；
//②通过与Future的结合，可以实现利用Future来跟踪异步计算的结果。

//Callable任务借助FutureTask运行
public class CallableAndFutureA
{
    public static void main(String[] args)
    {
        Callable<Integer> callable = new Callable<Integer>()
        {
            @Override
            public Integer call() throws Exception
            {
                return new Random().nextInt(100);
            }
        };

        FutureTask<Integer> futureTask1 = new FutureTask<Integer>(callable);
        Thread thread = new Thread(futureTask1);
        thread.start();

        try
        {
            System.out.println("CallableAndFutureA...");
            Thread.sleep(2000);
            System.out.println(futureTask1.get());
        } catch (InterruptedException e)
        {
            e.printStackTrace();
        } catch (ExecutionException e)
        {
            e.printStackTrace();
        }

    }


}

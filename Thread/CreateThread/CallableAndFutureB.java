package Thread;

import java.util.Random;
import java.util.concurrent.*;

//Callable任务和线程池一起使用，然后返回值是Future
public class CallableAndFutureB
{
    public static void main(String[] args)
    {
        ExecutorService threadPool = Executors.newSingleThreadExecutor();
        Future<Integer> future = threadPool.submit(new Callable<Integer>()
        {
            @Override
            public Integer call() throws Exception
            {
                return new Random().nextInt(100);
            }
        });

        try
        {
            System.out.println("CallableAndFutureB...");
            Thread.sleep(1000);
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

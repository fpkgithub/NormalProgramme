package Thread;

import java.util.ArrayList;
import java.util.concurrent.*;

//当执行多个Callable任务，有多个返回值时，我们可以创建一个Future的集合
public class CallableAndFutureC
{
    public static void main(String[] args)
    {
        ExecutorService executorService = Executors.newCachedThreadPool();
        ArrayList<Future<String>> results = new ArrayList<Future<String>>();

        for (int i = 0; i < 5; i++)
        {
            results.add(executorService.submit(new MyCallableTask(i)));
        }


        for (Future<String> fs : results)
        {
            if (fs.isDone())
            {
                try
                {
                    System.out.println(fs.get());
                } catch (Exception e)
                {
                    e.printStackTrace();
                }
            } else
            {
                System.out.println("MyCallableTask任务完成...");
            }
        }
        executorService.shutdown();
    }

}


class MyCallableTask implements Callable<String>
{

    private int id;

    public MyCallableTask(int id)
    {
        this.id = id;
    }

    @Override
    public String call() throws Exception
    {
        for (int i = 0; i < 5; i++)
        {
            System.out.println("Thread " + id);
            Thread.sleep(1000);
        }
        return "Result of callable:" + id;
    }
}
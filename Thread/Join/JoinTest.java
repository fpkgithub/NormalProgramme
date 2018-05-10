package Thread;

//线程实例的join()方法可以使得一个线程在另一个线程结束后再执行，即也就是说使得当前线程可以阻塞其他线程执行；
//结论是：t1阻塞t2和t3，t2和t3是乱序的
public class JoinTest
{
    public static void main(String[] args) throws InterruptedException
    {
        Thread t1 = new Thread(new Runnable()
        {
            @Override
            public void run()
            {
                System.out.println("start t1 task...");
                try
                {
                    Thread.sleep(2000);
                } catch (InterruptedException e)
                {
                    e.printStackTrace();
                }
                System.out.println("start t1 task...");
                System.out.println("end t1 task...");

            }
        });
        Thread t2 = new Thread(new Runnable()
        {
            @Override
            public void run()
            {
                System.out.println("end t2 task...");
                System.out.println("start t2 task...");
            }
        });
        Thread t3 = new Thread(new Runnable()
        {
            @Override
            public void run()
            {
                System.out.println("end t3 task...");
                System.out.println("start t3 task...");
            }
        });


        t1.start();
        t1.join();
        t2.start();
        t3.start();


    }


}

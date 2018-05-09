package alibaba;

public class TimeTest
{

	public static void main(String[] args)
	{
		System.err.println("======TimeTest÷¥––========");
		sayHello();
		sayHello2("hello world222222222");
	}

	public static void sayHello()
	{
		try
		{
			Thread.sleep(2000);
			System.out.println("hello world!!");
		}
		catch (InterruptedException e)
		{
			e.printStackTrace();
		}
	}

	public static void sayHello2(String hello)
	{
		try
		{
			Thread.sleep(1000);
			System.out.println(hello);
		}
		catch (InterruptedException e)
		{
			e.printStackTrace();
		}
	}
}
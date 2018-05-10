package 栈溢出和内存溢出;

//堆栈溢出错误一般是递归调用
public class 栈溢出
{
    public static void main(String[] args)
    {
        fun();
    }

    private static void fun()
    {
        for (;;)
        {
            fun();
        }
    }
}

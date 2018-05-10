package 栈溢出和内存溢出;

import java.util.ArrayList;
import java.util.List;

//申请了较多的内存空间且没有释放
public class 内存溢出
{
    public static void main(String[] args)
    {
        fun();
    }

    private static void fun()
    {
        List<int[]> list = new ArrayList<int[]>();

        for (; ; )
        {
            int[] a = new int[1000000];
            list.add(a);
        }
    }

}

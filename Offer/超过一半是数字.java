package Offer;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

//一个数组超过一半以上都是同一个数，求这个数，要求效率最高
public class 超过一半是数字
{
    public static void main(String[] args)
    {
        int[] a = {1, 2, 3, 2, 2, 2, 5, 4, 2};


        /*
         *思路一：
         * 首先将容器中的数字排序，则排序结束后，相同的数字都在相邻位置，
         * 直接判断数组当前位置的数字与（数组位置+数组一半长度位置）的数字是否相等，相等则输出该数字。
         * 时间复杂度O(nlogn)，空间复杂度O(1) runtime 15ms
         */
        System.out.println("思路一：" + Solution_1(a));

        /*
         *思路二：
         * 首先是输入是数字，介于0～9之间（晕我居然才知道）。所以我们可以首先建立一个含有10个元素的数组，
         * 然后用输入的数字作为下标以统计每个数字出现的次数。再对这个数组与长度的一半进行比较，输出结果。
         */
        System.out.println("思路二：" + Solution_2(a));


        /*
         * 思路三：使用HashMap
         * 使用HashMap存放，key为数字，value为出现的次数
         */
        System.out.println("思路三：" + Solution_3(a));


        /*
         * 思路四：使用java巧解
         */
        System.out.println("思路四：" + Solution_4(a));
    }

    //思路一：
    private static int Solution_1(int[] a)
    {
        if (a.length <= 0 || a == null)
            return 0;
        int len = a.length / 2;
        Arrays.sort(a);
        for (int i = 0; i + len < a.length; i++)
        {
            if (a[i] == a[i + len])
            {
                return a[i];
            }
        }

        return 0;
    }

    //思路二:
    private static int Solution_2(int[] a)
    {
        if (a == null || a.length <= 0)
            return 0;
        int temp[] = new int[10];
        //将a数组输入的数字作为下标以统计每个数字出现的次数
        for (int i : a)
        {
            temp[i]++;
        }
        //比较
        for (int j = 0; j < temp.length; j++)
        {
            if (temp[j] > a.length / 2)
            {
                return j;
            }
        }
        return 0;
    }

    private static int Solution_3(int[] a)
    {
        if (a == null || a.length <= 0)
            return 0;
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        for (int i = 0; i < a.length; i++)
        {
            int val;
            if (map.get(a[i]) == null)
            {
                map.put(a[i], 1);
                val = 1;
            }
            else
            {
                val = map.get(a[i]) + 1;
                map.put(a[i], val);//注意一定要++val
            }
            if (val >= a.length / 2)
            {
                return a[i];
            }
        }


        return 0;
    }

    //思路四:
    private static int Solution_4(int[] a)
    {
        Arrays.sort(a);

        int count = 0;
        for (int i = 0; i < a.length; i++)
        {
            if (a[i] == a[a.length / 2])
            {
                count++;
            }
            if (count > a.length / 2)
            {
                return a[a.length / 2];
            }
        }
        return 0;
    }

}

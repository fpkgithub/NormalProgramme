package Offer;

import java.util.HashMap;
import java.util.Map;

public class 超过一半是数字
{
    public static void main(String[] args)
    {
        int[] a = {1, 2, 3, 2, 2, 2, 5, 4, 2};
        int re = fun(a);
        System.out.println(re);
    }

    private static int fun(int[] a)
    {
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();

        for (int i = 0; i < a.length; i++)
        {
            int temp;
            if (map.get(a[i]) == null)
            {
                map.put(a[i], 1);
                temp = 1;
            }
            else
            {
                temp = map.get(a[i]);
                map.put(a[i], ++temp);
            }
            if (temp > a.length / 2)
            {
                System.out.println(a.length + " " + temp);
                return a[i];
            }
        }

        return 0;
    }

}

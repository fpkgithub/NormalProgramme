package Offer;

import java.util.*;

/*
 *全排列数f(n)=n!(定义0!=1)
 * 例如：123
 * 123 132
 * 213 231
 * 312 321
 * 共3*2*1=6
 *
 * 故思路是：从字符串数组中每次选取一个元素，作为结果中的第一个元素。然后，对剩余的元素全排列，步骤跟上面一样。
 * 很明显这是个递归处理的过程，一直到最后即可。
 * 运用递归的方法，比如abc的全排列，可以变成a+bc的全排列、b+ac的全排列、c+ab的全排列
 */
public class 字符串全排列
{
    public static void main(String[] args)
    {
        String str = "abcd";//4*3*2
        Set<String> set = new TreeSet<String>();
        if (str.length() > 0)
        {

            fun(set, str.toCharArray(), 0);
            List<String> resList = new ArrayList<String>();
            //resList.addAll(set);
            for (String s : set)
            {
                System.out.print(s + " ");
            }
            System.out.println();
        }
    }

    private static void fun(Set<String> set, char[] arr, int k)
    {
        if (k == arr.length)
        {
            set.add(new String(arr));
            return;
        }
        for (int i = 0; i < arr.length; i++)
        {
            swap(arr, i, k);
            fun(set, arr, k + 1);
            swap(arr, i, k);
        }

    }

    private static void swap(char[] arr, int i, int k)
    {
        if (i != k)
        {
            char temp = arr[i];
            arr[i] = arr[k];
            arr[k] = temp;
        }
    }


    //牛客网的要求
    public class Solution
    {
        public ArrayList<String> Permutation(String str)
        {
            ArrayList<String> re = new ArrayList<String>();
            if (str == null || str.length() == 0)
            {
                return re;
            }
            HashSet<String> set = new HashSet<String>();
            fun(set, str.toCharArray(), 0);
            re.addAll(set);
            Collections.sort(re);
            return re;
        }

        void fun(HashSet<String> re, char[] str, int k)
        {
            if (k == str.length)
            {
                re.add(new String(str));
                return;
            }
            for (int i = k; i < str.length; i++)
            {
                swap(str, i, k);
                fun(re, str, k + 1);
                swap(str, i, k);
            }
        }

        void swap(char[] str, int i, int j)
        {
            if (i != j)
            {
                char t = str[i];
                str[i] = str[j];
                str[j] = t;
            }
        }
    }


}

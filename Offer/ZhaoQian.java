package offer;

public class ZhaoQian
{
	public static void main(String[] args)
	{
		// 求解特定实例：要将100元兑换为1元、5元、10元的零钱，请问有多少种兑换方法？
		int money = 100;
		System.out.println(baseFun(money));
		System.out.println(getDivideWays());
		int[] coinKinds = { 1, 5, 10 };
		System.out.println(cc(money, coinKinds.length));
	}

	// 递归实现
	/**
	 * @param mount
	 *            整钱数量
	 * @param coinKinds
	 *            零钱类型数量
	 */
	// 将总数为a的现金换成n种不同面值的不同方式的数目等于：
	// 将现金a换成除了第一种面值之外的所有其他面值的不同方式数目，加上
	// 将现金a-d换成所有种类的面值的不同方式数目，其中d是第一种面值的钱币
	private static int cc(int mount, int coinKinds)
	{
		// 如果a==0,应该算作是有1种换零钱的方式 : 整数面值的钱刚好被换完了
		if (mount == 0)
			return 1;
		// 如果n=0，应该算作是有0种换零钱的方式
		// 如果a<0,应该算作是有0中换零钱的方式
		if (mount <= 0 || coinKinds == 0)
			return 0;
		return cc(mount, coinKinds - 1) + cc(mount - denomination(coinKinds), coinKinds);
	}

	private static int denomination(int coinKinds)
	{
		switch (coinKinds)
		{
		case 1:
			return 1;
		case 2:
			return 5;
		default:
			return 10;
		}
	}

	/**
	 * 1、求解特定实例：要将100元兑换为1元、5元、10元的零钱，请问有多少种兑换方法？ 针对10的每个场景，计算5的组合情况（即，从0个5 到 n（
	 * n=(100 - i * 10)/5 个5共n+1种情况
	 */

	private static int getDivideWays()
	{
		int count = 0;
		for (int i = 0; i <= 100 / 10; i++)
		{
			count += (100 - 10 * i) / 5 + 1;
		}
		return count;
	}

	private static int baseFun(int money)
	{
		int count = 0;
		for (int i = 0; i <= 10; i++)
		{
			for (int j = 0; j <= 20; j++)
			{
				for (int k = 0; k <= 100; k++)
				{
					if (10 * i + 5 * j + k == 100)
					{
						count++;
					}
				}
			}
		}
		return count;
	}
}

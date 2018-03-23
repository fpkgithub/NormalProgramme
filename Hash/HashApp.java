package HashTest;

/**
 * @time   Mar 23, 2018
 * @author akun
 * @description  
 */
class DataItem
{
	private int value;

	public DataItem(int value)
	{
		this.value = value;
	}

	/**
	 * @return the value
	 */
	public int getValue()
	{
		return value;
	}

	/**
	 * @param value the value to set
	 */
	public void setValue(int value)
	{
		this.value = value;
	}

}

public class HashApp
{
	public DataItem[] arr;// 哈希表的底层是由数组实现的
	public int size;// 当前数组的最大长度
	public DataItem newItem;// 新插入的节点
	public int currentSize; // 当前数组有几个元素

	// 初始化
	public HashApp(int maxSize)
	{
		arr = new DataItem[maxSize];
		size = maxSize;
		currentSize = 0;
	}

	// 哈希化
	public int hash(int value)
	{
		return value % size;
	}

	// 添加数据
	public void insert(int value)
	{
		// 如果满了，则返回
		if (isFull())
		{
			System.out.println("is full...");
			return;
		}

		// 计算哈希化后的索引
		int index = hash(value);
		newItem = new DataItem(value);

		// 当前小标的数组元素不为空，说明有元素了，index递增
		while (arr[index] != null)
		{
			index++;
			// 防止index超过数组最大索引下标
			index = hash(index);
		}
		arr[index] = newItem;
		++currentSize;
	}

	// 删除数据
	public void delete(int value)
	{
		int index = hash(value);
		while (arr[index] != null)
		{
			if (arr[index].getValue() == value)
			{
				arr[index] = null;
				return;
			}
			index++;
			index = hash(index);
		}
	}

	// 查找数据
	public DataItem find(int value)
	{
		int index = hash(value);
		// 疑问？ 万一为空的这个点在之前被删除了呢
		while (arr[index] != null)
		{
			if (arr[index].getValue() == value)
			{
				return arr[index];
			}
			index++;
			index = hash(index);
		}
		return null;
	}

	// 哈希表无法有序的遍历！所以这里遍历只是查看一个数据的分布情况
	public void display()
	{
		for (DataItem arr : arr)
		{
			if (arr != null)
				System.out.print(arr.getValue() + " ");
		}
		System.out.println();
	}

	public boolean isFull()
	{
		return currentSize == size;
	}
	
	
	
}

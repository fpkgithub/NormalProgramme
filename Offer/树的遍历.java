package Offer;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Stack;

/**
 * @time   May 12, 2018
 * @author akun
 * @description  
 */
public class 树的遍历
{
	public static void main(String[] args)
	{
		// 构造一棵树
		Tree tree = new Tree(1);
		Tree node1 = new Tree(2);
		Tree node2 = new Tree(3);
		Tree node3 = new Tree(4);
		Tree node4 = new Tree(5);
		Tree node5 = new Tree(6);
		tree.left = node1;
		tree.right = node2;

		node1.left = node3;
		node1.right = node4;

		node2.left = node5;

		// 树的前序递归遍历
		preRecursion(tree);

		System.out.println();

		// 树的前序非递归遍历
		// ArrayList<Integer> result = preNoRecursion(tree);

		// 树的中序非递归遍历
		// ArrayList<Integer> result2 = INNoRecursion(tree);

		// 树的中序非递归遍历
		ArrayList<Integer> result3 = LastNoRecursion(tree);
		Iterator<Integer> iterator = result3.iterator();
		while (iterator.hasNext())
		{
			System.out.print(iterator.next() + " ");
		}

	}

	/**
	 * @param tree
	 * @return
	 */
	private static ArrayList<Integer> LastNoRecursion(Tree tree)
	{
		ArrayList<Integer> list = new ArrayList<Integer>();
		if (tree == null)
		{
			return list;
		}
		Stack<Tree> stack = new Stack<Tree>();
		stack.push(tree);
		while (!stack.empty())
		{
			// 取栈顶元素
			Tree node = stack.peek();
			if (node.left == null && node.right == null)
			{
				Tree temp = stack.pop();
				list.add(temp.val);
			}
			// 因为是栈 所以顺序要换一下
			if (node.right != null)
			{
				stack.push(node.right);
				node.right = null;
			}
			if (node.left != null)
			{
				stack.push(node.left);
				node.left = null;
			}

		}
		return list;
	}

	/**
	 * @param tree
	 */
	private static ArrayList<Integer> INNoRecursion(Tree tree)
	{
		ArrayList<Integer> list = new ArrayList<Integer>();
		if (tree == null)
		{
			return list;
		}
		Stack<Tree> stack = new Stack<Tree>();
		stack.push(tree);
		while (!stack.empty())
		{
			// 取栈顶元素
			Tree node = stack.peek();
			if (node.left == null)
			{
				// 出
				Tree temp = stack.pop();
				list.add(temp.val);
				if (temp.right != null)
				{
					stack.push(temp.right);
				}

			}
			else
			{
				stack.push(node.left);
				// 清除加入栈后的元素之间的左孩子关系，不然后续判断中，无法进入if判断中
				node.left = null;
			}
		}
		return list;
	}

	/**
	 * @param tree
	 * push当前节点->push左子树->pop左子树->push右子树->pop右子树的方式
	 */
	private static ArrayList<Integer> preNoRecursion(Tree tree)
	{
		ArrayList<Integer> list = new ArrayList<Integer>();
		if (tree == null)
		{
			return list;
		}
		Stack<Tree> stack = new Stack<Tree>();
		stack.push(tree);
		while (!stack.empty())
		{
			Tree node = stack.pop();
			list.add(node.val);
			if (node.right != null)
			{
				stack.push(node.right);
			}
			if (node.left != null)
			{
				stack.push(node.left);
			}

		}
		return list;
	}

	/**
	 * @param tree
	 */
	private static void preRecursion(Tree tree)
	{
		if (tree == null)
			return;
		System.out.print(tree.val + " ");
		preRecursion(tree.left);
		preRecursion(tree.right);

	}
}

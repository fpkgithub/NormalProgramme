package Offer;

import java.util.ArrayList;
import java.util.Iterator;

class TreeNode
{
    int val = 0;
    TreeNode left = null;
    TreeNode right = null;

    public TreeNode(int val)
    {
        this.val = val;

    }

}

/**
 * 从上往下打印出二叉树的每个节点，同层节点从左至右打印。
 */
public class 从上往下打印出二叉树
{


    public static void main(String[] args)
    {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        ArrayList<Integer> re = PrintFromTopToBottom(root);
        Iterator iterator = re.iterator();
        while (iterator.hasNext())
        {
            System.out.print(iterator.next() + " ");
        }

    }

    public static ArrayList<Integer> PrintFromTopToBottom(TreeNode root)
    {
        ArrayList<Integer> list = new ArrayList<Integer>();
        ArrayList<TreeNode> queue = new ArrayList<TreeNode>();
        if (root == null)
        {
            return list;
        }
        queue.add(root);
        while (queue.size() > 0)
        {
            TreeNode node = queue.remove(0);
            list.add(node.val);
            if (node.left != null)
            {
                queue.add(node.left);
            }
            if (node.right != null)
            {
                queue.add(node.right);
            }
        }
        return list;


    }
}

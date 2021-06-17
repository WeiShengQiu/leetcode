package offer.easy;

import java.util.*;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: wangshiqi
 * @DateTime: 2021/6/17 17:45
 * @Description:
 */
public class KthNode {
    public class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;

        }
    }

    ArrayList<TreeNode> list = new ArrayList<>();

    TreeNode KthNode(TreeNode pRoot, int k) {
        PrintFromTopToBottom(pRoot);
        if (k >= 1 && list.size() >= k) {
            return list.get(k - 1);
        }
        return null;

    }

    public void PrintFromTopToBottom(TreeNode root) {
        if (root != null) {
            PrintFromTopToBottom(root.left);
            list.add(root);
            PrintFromTopToBottom(root.right);
        }
    }
}

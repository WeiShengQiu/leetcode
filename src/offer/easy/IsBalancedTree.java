package offer.easy;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: wangshiqi
 * @DateTime: 2021/6/17 15:31
 * @Description:
 */
public class IsBalancedTree {
    public class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;

        }
    }

    public boolean IsBalancedTree(TreeNode root) {
        return depth(root) != -1;
    }

    public int depth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int left = depth(root.left);
        if (left == -1) {
            return -1;
        }
        int right = depth(root.right);
        if (right == -1) {
            return -1;
        }
        return Math.abs(left - right) > 1 ? -1 : 1 + Math.max(left, right);
    }

//    public boolean IsBalancedTree(TreeNode root) {
//        if (root == null) {
//            return true;
//        }
//        return Math.abs(depth(root.left) - depth(root.right)) <= 1 && IsBalancedTree(root.left) && IsBalancedTree(root.right);
//    }
//
//    public int depth(TreeNode root) {
//        if (root == null) {
//            return 0;
//        }
//        return Math.max(depth(root.right), depth(root.left)) + 1;
//    }
}

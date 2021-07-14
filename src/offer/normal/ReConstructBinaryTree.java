package offer.normal;

import java.util.Arrays;

public class ReConstructBinaryTree {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder.length == 0 || inorder.length == 0) {
            return null;
        }
        TreeNode root = new TreeNode(preorder[0]);
        // 在中序中找到前序的根
        for (int i = 0; i < inorder.length; i++) {
            if (inorder[i] == preorder[0]) {
                // 左子树，注意 copyOfRange 函数，左闭右开
                root.left = buildTree(Arrays.copyOfRange(preorder, 1, i + 1), Arrays.copyOfRange(inorder, 0, i));
                // 右子树，注意 copyOfRange 函数，左闭右开
                root.right = buildTree(Arrays.copyOfRange(preorder, i + 1, preorder.length), Arrays.copyOfRange(inorder,
                        i + 1, inorder.length));
                break;
            }
        }
        return root;
    }
}

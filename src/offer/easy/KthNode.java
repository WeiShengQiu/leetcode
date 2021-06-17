package offer.easy;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

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

    TreeNode KthNode(TreeNode pRoot, int k) {
        if (pRoot.left != null) {

        }
        if (pRoot.right != null) {

        }
    }

    public void depth(TreeNode pRoot, List<Integer> list) {
        while (pRoot != null) {
            list.add(pRoot.val);
            depth(pRoot.left, list);
            depth(pRoot.right, list);
        }
    }
}

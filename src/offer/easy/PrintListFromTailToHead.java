package offer.easy;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: wangshiqi
 * @DateTime: 2021/6/15 16:10
 * @Description:
 */


public class PrintListFromTailToHead {
    public class ListNode {
        int val;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }

    ArrayList<Integer> list = new ArrayList<>();

    public int[] printListFromTailToHead(ListNode listNode) {

        if (Objects.nonNull(listNode)) {
            printListFromTailToHead(listNode.next);
            list.add(listNode.val);
        }
        return list.stream().mapToInt(Integer::intValue).toArray();
    }
}

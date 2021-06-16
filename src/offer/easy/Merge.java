package offer.easy;

import java.util.Objects;

public class Merge {

    public class ListNode {
        int val;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }

    public ListNode Merge(ListNode list1, ListNode list2) {
        ListNode newHeadNode = new ListNode(0);
        ListNode tempNode = newHeadNode;
        while (Objects.nonNull(list1) && Objects.nonNull(list2)) {
            if(list1.val>=list2.val){
                tempNode.next = list2;
                tempNode = tempNode.next;
                list2 = list2.next;
            }else{
                tempNode.next = list1;
                tempNode = tempNode.next;
                list1 = list1.next;
            }
        }
        if (null == list1) {
            tempNode.next = list2;
        } else if (null == list2) {
            tempNode.next = list1;
        }
        return newHeadNode.next;
    }
}

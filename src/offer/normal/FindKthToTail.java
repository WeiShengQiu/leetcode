package offer.normal;


public class FindKthToTail {


    public class ListNode {
        int val;
        ListNode next = null;

        public ListNode(int val) {
            this.val = val;
        }
    }

    public ListNode findKthToTail(ListNode pHead, int k) {
        ListNode first = pHead;
        for (int i = 0; i < k; i++) {
            if (first == null) return first;
            first = first.next;

        }
        ListNode last = pHead;
        while (first != null) {
            first = first.next;
            last = last.next;
        }
        return last;
    }
}

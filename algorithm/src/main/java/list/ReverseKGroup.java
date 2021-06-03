package list;

/**
 * Description:
 *
 * @author:edgarding
 * @date:2021/3/28
 **/
public class ReverseKGroup {
    /**
     * Definition for singly-linked list.
     * public class ListNode {
     * int val;
     * ListNode next;
     * ListNode() {}
     * ListNode(int val) { this.val = val; }
     * ListNode(int val, ListNode next) { this.val = val; this.next = next; }
     * }
     */
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode dummy = new ListNode(0), prev = dummy, cur = head, nextNode;
        dummy.next = head;
        int len = 0;
        while (head != null) {
            len++;
            head = head.next;
        }
        for (int i = 0; i < len / k; i++) {
            for (int j = 0; j < k - 1; j++) {
                nextNode = cur.next;
                cur.next = nextNode.next;
                nextNode.next = prev.next;
                prev.next = nextNode;
            }
            prev = cur;
            cur = cur.next;
        }
        return dummy.next;
    }
}

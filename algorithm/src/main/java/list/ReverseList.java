package list;

/**
 * Description:
 * 反转链表
 * @author:edgarding
 * @date:2021/5/23
 **/
public class ReverseList {
    /**
     * 反转整个链表
     * @param head
     * @return
     */
    public ListNode reverse(ListNode head) {
        ListNode pre = null, cur = head;
        while(cur != null) {
            ListNode tmp = cur.next;
            cur.next = pre;
            pre = cur;
            cur = tmp;
        }
        return pre;
    }

    /**
     * 反转整个链表2
     * 优势：容易反转某个范围内的子链表
     * @param head
     * @return
     */
    public ListNode reverseList(ListNode head) {
        if(head == null) {
            return null;
        }
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode cur = head;
        while(cur.next != null) {
            ListNode node = cur.next;
            cur.next = node.next;
            node.next = dummy.next;
            dummy.next = node;
        }
        return dummy.next;
    }

    /**
     * 反转从位置 left 到位置 right 的链表节点，返回 反转后的链表 。
     * @param head
     * @param left
     * @param right
     * @return
     */
    public ListNode reverseBetween(ListNode head, int left, int right) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode pre = dummy;
        for(int i=1; i<left; i++) {
            pre = pre.next;
        }
        ListNode cur = pre.next;
        for(int i=left; i<right; i++) {
            ListNode tmp = cur.next;
            cur.next = tmp.next;
            tmp.next = pre.next;
            pre.next = tmp;
        }
        return dummy.next;
    }
}

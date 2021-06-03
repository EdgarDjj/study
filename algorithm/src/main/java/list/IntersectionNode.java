package list;

/**
 * Description:
 * 求相交的链表
 * 设交集链表长c,链表1除交集的长度为a，链表2除交集的长度为b，有
 *
 * a + c + b = b + c + a
 * 若无交集，则a + b = b + a
 * @author:edgarding
 * @date:2021/3/4
 **/
public class IntersectionNode {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) {
            return null;
        }
        ListNode h1 = headA, h2 = headB;
        while (h1 != h2) {
            h1 = h1 == null ? headB : h1.next;
            h2 = h2 == null ? headA : h2.next;
        }
        return h1;
    }
}

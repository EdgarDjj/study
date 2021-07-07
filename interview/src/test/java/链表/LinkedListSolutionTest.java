package 链表;

import org.junit.Test;

/**
 * Description:
 *
 * @author:edgarding
 * @date:2021/6/25
 **/
public class LinkedListSolutionTest {

    @Test
    public void test2() {
        ListNode dummy = new ListNode(0);
        ListNode pre = dummy;
        pre.val = 1;
        System.out.println(dummy.val);
    }

    @Test
    public void Test() {
        ListSolution listSolution = new ListSolution();
        ListNode dummyNode = new ListNode(0), cur = dummyNode;
        for (int i = 1; i <= 5; i++) {
            ListNode node = new ListNode(i);
            cur.next = node;
            cur = cur.next;
        }

        ListNode head = listSolution.reverseKGroup(dummyNode.next, 3);

        while (head != null) {
            System.out.println(head.val + " ");
            head = head.next;
        }
    }
}
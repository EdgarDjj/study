package 链表;

/**
 * Description:
 * 有关链表的一些问题
 *
 * @author:edgarding
 * @date:2021/6/14
 **/
public class ListSolution {

    /**
     * 两个结点不断的去对方的轨迹中寻找对方的身影，只要二人有交集，就终会相遇
     * <p>
     * 两个链表，找出它们的第一个公共节点。
     *
     * @param headA
     * @param headB
     * @return
     */
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        // 链表的公共节点
        // 1.没有交点返回 -》 null
        // 2.保持原有结构
        // 3.没有循环
        // 4.尽量不开辟空间
        if (headA == null || headB == null) {
            return null;
        }
        ListNode p1 = headA, p2 = headB;
        while (p1 != p2) {
            p1 = p1 == null ? headB : p1.next;
            p2 = p2 == null ? headA : p2.next;
        }
        return p1;
    }

    /**
     * 删除链表的倒数第n个节点
     *
     * @param head
     * @param n    第n个节点
     * @return 返回头节点
     */
    public ListNode removeNthFromEnd(ListNode head, int n) {
        // 删除倒数第n个 返回头节点
        // 一趟扫描
        // 快慢指针
        if (head == null) {
            return null;
        }
        ListNode dummyNode = new ListNode(0);
        dummyNode.next = head;
        ListNode slow = dummyNode, fast = dummyNode;
        for (; n > 0; n--) {
            fast = fast.next;
        }

        for (; fast.next != null; fast = fast.next, slow = slow.next) {
        }
        slow.next = slow.next.next;
        return dummyNode.next;
    }


    /**
     * 反转整个链表
     *
     * @param head
     * @return
     */
    public ListNode reverse(ListNode head) {
        ListNode pre = null, cur = head;
        while (cur != null) {
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
     *
     * @param head
     * @return
     */
    public ListNode reverseList(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        while (head.next != null) {
            ListNode node = head.next;
            head.next = node.next;
            node.next = dummy.next;
            dummy.next = node;
        }
        return dummy.next;
    }

    /**
     * 反转从位置 left 到位置 right 的链表节点，返回 反转后的链表 。
     *
     * @param head
     * @param left
     * @param right
     * @return
     */
    public ListNode reverseBetween(ListNode head, int left, int right) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode pre = dummy;
        for (int i = 1; i < left; i++) {
            pre = pre.next;
        }
        ListNode cur = pre.next;
        for (int i = left; i < right; i++) {
            ListNode tmp = cur.next;
            cur.next = tmp.next;
            tmp.next = pre.next;
            pre.next = tmp;
        }
        return dummy.next;
    }

    /**
     * k个一组反转链表
     *
     * @param head
     * @param k
     * @return
     */
    public ListNode reverseKGroup(ListNode head, int k) {
        // 注意pre的赋值
        ListNode dummy = new ListNode(0), pre = dummy, cur = head;
        dummy.next = head;
        if (head == null) {
            return null;
        }
        int len = 0;
        for (; head != null; len++) {
            head = head.next;
        }
        // 循环次数
        for (int i = 0; i < len / k; i++) {
            for (int j = 0; j < k - 1; j++) {
                ListNode nextNode = cur.next;
                cur.next = nextNode.next;
                nextNode.next = pre.next;
                pre.next = nextNode;
            }
            // 第一次循环结束，pre已经将dummy的指向改变了
            pre = cur;
            cur = cur.next;
        }
        return dummy.next;
    }

    public ListNode reverseKGroup2(ListNode head, int k) {
        ListNode dummy = new ListNode(0);
        ListNode pre = new ListNode(0);
        ListNode cur = head;
        pre.next = head;
        int len = 0;
        for (; head != null; len++) {
            head = head.next;
        }
        if (len < k) {
            return pre.next;
        }
        for (int i = 0; i < len / k; i++) {
            for (int j = 0; j < k - 1; j++) {
                ListNode node = cur.next;
                cur.next = node.next;
                node.next = pre.next;
                pre.next = node;
            }
            if (dummy.next == null) {
                dummy.next = pre.next;
            }
            pre = cur;
            cur = cur.next;
        }
        return dummy.next;
    }


    /**
     * 获取倒数第k个节点
     *
     * @param head
     * @param k
     * @return
     */
    public ListNode getKthFromEnd(ListNode head, int k) {
        if (head == null) {
            return null;
        }
        ListNode fast = head, slow = head;
        for (; fast != null && k > 0; k--, fast = fast.next) {
        }
        for (; fast != null; fast = fast.next, slow = slow.next) {
        }
        return slow;
    }

    /**
     * 重排链表
     * 给定一个单链表 L：L0→L1→…→Ln-1→Ln ，
     * 将其重新排列后变为： L0→Ln→L1→Ln-1→L2→Ln-2→…
     * <p>
     * 你不能只是单纯的改变节点内部的值，而是需要实际的进行节点交换。
     *
     * @param head
     */
    public void reorderList(ListNode head) {
        if (head == null || head.next == null) {
            return;
        }
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        // 使得slow位于中间靠左边
        ListNode fast = dummy, slow = dummy;
        for (; fast != null && fast.next != null; fast = fast.next.next, slow = slow.next) {
        }
        ;
        ListNode last = slow.next;
        slow.next = null;
        last = reverseList(last);

        for (ListNode cur = head; last != null; ) {
            ListNode tmp = cur.next;
            ListNode tmp2 = last.next;
            cur.next = last;
            last.next = tmp;
            cur = tmp;
            last = tmp2;
        }
    }

    /**
     * 奇偶链表
     * 给定一个单链表，把所有的奇数节点和偶数节点分别排在一起。请注意，这里的奇数节点和偶数节点指的是节点编号的奇偶性，而不是节点的值的奇偶性。
     * <p>
     * 请尝试使用原地算法完成。你的算法的空间复杂度应为 O(1)，时间复杂度应为 O(nodes)，nodes 为节点总数。
     *
     * @param head
     * @return
     */
    public ListNode oddEvenList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        // head 为奇链表头节点 o为尾节点
        ListNode o = head;
        // p 为偶链表的头节点 e为尾节点
        ListNode p = head.next, e = p;
        for (; o.next != null && e.next != null; ) {
            o.next = e.next;
            o = o.next;
            e.next = o.next;
            e = e.next;
        }
        o.next = p;
        return head;
    }
}

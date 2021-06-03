package 链表;

/**
 * Description:
 * 单链表实现
 *
 * @author:edgarding
 * @date:2021/6/3
 **/
public class SingleList implements List{
    private int size;
    Node head, tail;
    private static class Node {
        int item;
        Node next;

        Node(int item) {
            this.item = item;
            next = null;
        }
    }

    public SingleList() {
    }


    @Override
    public int size() {
        return this.size;
    }

    @Override
    public boolean add(int val) {
        Node node = new Node(val);
        if (tail == null) {
            tail = node;
            head = node;
        } else {
            tail.next = node;
            tail = tail.next;
        }
        size++;
        return true;
    }

    @Override
    public boolean add(int index, int val) {
        checkIndex(index);
        if (index == size - 1) {
            return add(val);
        }
        Node cur = this.head;
        while (cur != null && index-- != 0) {
            cur = cur.next;
        }
        Node node = new Node(val);
        node.next = cur.next;
        cur.next = node;
        size++;
        return true;
    }

    @Override
    public int remove(int index) {
        checkIndex(index);
        Node cur = head, pre = head;
        while (cur != null && index-- != 0) {
            pre = cur;
            cur = cur.next;
        }
        pre.next = cur.next;
        int oldVal = cur.item;
        cur = null;
        size--;
        return oldVal;
    }

    @Override
    public int set(int index, int newVal) {
        checkIndex(index);
        Node cur = head;
        while (cur != null && index-- != 0) {
            cur = cur.next;
        }
        int oldVal = cur.item;
        cur.item = newVal;
        return oldVal;
    }

    @Override
    public boolean isEmpty() {
        return size != 0;
    }

    @Override
    public int indexOf(int val) {
        Node cur = head;
        int index = 0;
        while (cur != null && cur.item != val) {
            cur = cur.next;
            index++;
        }
        return index;
    }

    @Override
    public int get() {
        return tail.item;
    }

    @Override
    public int get(int index) {
        checkIndex(index);
        if (index == size - 1) {
            return get();
        }
        Node cur = head;
        while (index-- != 0) {
            cur = cur.next;
        }
        return cur.item;
    }


    private void checkIndex(int index) {
        if (index >= size) {
            throw new IndexOutOfBoundsException();
        }
    }
}

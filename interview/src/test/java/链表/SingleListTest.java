package 链表;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Description:
 *
 * @author:edgarding
 * @date:2021/6/3
 **/
public class SingleListTest {
    @Test
    public void test() {
        List list = new SingleList();
        list.add(9);
        list.add(2);
        list.add(3);
        list.add(5);
        System.out.println(list.size() + " " + list.remove(1) + list.add(1, 5) + list.get(1));
    }
}
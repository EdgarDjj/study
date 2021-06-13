package 散列表;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Description:
 *
 * @author:edgarding
 * @date:2021/6/13
 **/
public class MyHashMapTest {
    @Test
    public void HashTest() {
        MyHashMap<Integer, Integer> map = new MyHashMap<>();
        for (int i = 0; i < 10; i++) {
            map.put(i, i * i);
        }
        map.remove(1);
        map.put(1, 300);
        for (int i = 0; i < 10; i++) {
            System.out.print(map.get(i) + " ");
        }
    }
}
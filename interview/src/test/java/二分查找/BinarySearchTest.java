package 二分查找;

import org.junit.Test;

import static org.junit.Assert.*;
import static 二分查找.BinarySearch.*;

/**
 * Description:
 *
 * @author:edgarding
 * @date:2021/6/4
 **/
public class BinarySearchTest {
    @Test
    public void Test() {
        int[] nums = {1, 4, 6, 6, 9, 32, 77, 77, 77, 100};
        System.out.println(binarySearch(nums, 6));
        System.out.println(leftBoundSearch(nums, 6));
        System.out.println(rightBoundSearch(nums, 6));
    }

    @Test
    public void test2() {
        StringBuilder sb = new StringBuilder();
        sb.append("das").append(",");
        sb.deleteCharAt(sb.length() - 1);
        System.out.println(sb.toString());
        String str = "1234213";
        str += String.valueOf("2") + ",";
        System.out.println(str);
    }

    @Test
    public void test1() {
//        int a = 10;
//        Integer b = 10;
//        int c = 129;
//        Integer d = 129;
//        Integer e = 10;
//        Integer f = 129;
//        System.out.println(a == b);
//        System.out.println(c == d);
//        System.out.println(b == e);
//        System.out.println(d == f);

        String b = new StringBuilder("ja").append("va").toString();
        String c = new StringBuilder("dsfd").append("dsa").toString();
        System.out.println(b.intern() == b);
        System.out.println(c.intern() == c);
    }
}
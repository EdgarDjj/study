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
        int[] nums = {1, 4, 6, 6, 9, 32, 77, 77, 77,  100};
        System.out.println(binarySearch(nums, 6));
        System.out.println(leftBoundSearch(nums, 6));
        System.out.println(rightBoundSearch(nums, 6));
    }
}
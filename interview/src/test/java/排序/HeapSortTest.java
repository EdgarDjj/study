package 排序;

import org.junit.Test;

import java.util.Arrays;
import java.util.Random;

import static org.junit.Assert.*;

/**
 * Description:
 *
 * @author:edgarding
 * @date:2021/7/17
 **/
public class HeapSortTest {
    @Test
    public void test() {
        Sort sort = new HeapSort();
        int[] arr = new int[10];
        for (int i = 0; i < 10; i++) {
            arr[i] = new Random().nextInt(10);
        }
        System.out.println("未排序：" + Arrays.toString(arr));
        System.out.println("排序后：" + Arrays.toString(sort.sort(arr)));
    }
}
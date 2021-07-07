package 堆;

import org.junit.Test;

import java.util.Arrays;
import java.util.Random;

import static org.junit.Assert.*;

/**
 * Description:
 *
 * @author:edgarding
 * @date:2021/6/22
 **/
public class HeapSortFinalTest {
    @Test
    public void test() {
        int[] arr = new int[10];
        Random random = new Random();
        for (int i = 0; i < 10; i++) {
            arr[i] = random.nextInt(10);
        }
        HeapSortFinal.heapSort(arr);
        System.out.println(Arrays.toString(arr));
    }
}
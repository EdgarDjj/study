package sort;

import org.junit.Test;

import java.util.Arrays;
import java.util.Random;

import static sort.SortUtils.print;

/**
 * Description:
 *
 * @author:edgarding
 * @date:2021/2/17
 **/
public class InsertionSortTest {
    @Test
    public void sortTest() {
        SortAlgorithm shellSort = new MergeSort();
        int[] arr = new int[10];
        Random random = new Random();
        for(int i=0; i<arr.length; i++) {
            arr[i] = random.nextInt(10);
        }
        print(arr);
        System.out.println(Arrays.toString(shellSort.sort(arr)));
    }
}
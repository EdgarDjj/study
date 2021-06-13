package 排序;

import org.junit.Test;

import java.util.Arrays;
import java.util.Random;


/**
 * Description:
 *
 * @author:edgarding
 * @date:2021/6/9
 **/
public class SortTest {

    @Test
    public void sortTest() {
        Sort sort = new MergeSort();
        Random random = new Random();
        int[] arr = new int[10];
        for (int i = 0; i < 10; i++) {
            arr[i] = random.nextInt(20);
        }
        System.out.print("原数组：");
        print(arr);
        System.out.print("排序后：");
        sort.sort(arr);
        print(arr);

    }

    public static void print(int[] arr) {
        System.out.println(Arrays.toString(arr));
    }
}
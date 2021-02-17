package sort;

import java.util.Arrays;

/**
 * Description:
 *
 * @author:edgarding
 * @date:2021/2/17
 **/
public class SortUtils {
    public static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void print(int[] arr) {
        System.out.println(Arrays.toString(arr));
    }
}

package 排序;

import java.util.Arrays;

/**
 * Description:
 *
 * @author:edgarding
 * @date:2021/6/9
 **/
public class SortUtil {
    public static void swap(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }

    public static void print(int[] arr) {
        System.out.println(Arrays.toString(arr));
    }
}

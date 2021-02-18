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

    public static int getMinVal(int[] arr) {
        if(arr.length == 0) {
            return  -1;
        }
        int min = arr[0];
        for (int i = 1; i < arr.length - 1; i++) {
            min = Math.min(min, arr[i]);
        }
        return min;
    }

    public static int getMaxVal(int[] arr) {
        if(arr.length == 0) {
            return -1;
        }
        int max = arr[0];
        for(int i=1; i<arr.length - 1; i++) {
            max = Math.max(max, arr[i]);
        }
        return max;
    }
}

package sort;

import static com.sun.tools.javac.jvm.ByteCodes.swap;
import static sort.SortUtils.swap;

/**
 * Description:
 * 冒泡排序
 * @author:edgarding
 * @date:2021/2/17
 **/
public class BubbleSort implements SortAlgorithm {
    @Override
    public int[] sort(int[] arr) {
        for(int i=0; i<arr.length - 1; i++) {
            boolean isSwapped = false;
            for(int j=0; j<arr.length - i - 1; j++) {
                if(arr[j] > arr[j + 1]) {
                    swap(arr, j, j+1);
                    isSwapped = true;
                }
            }
            if(!isSwapped) {
                break;
            }
        }
        return arr;
    }
}

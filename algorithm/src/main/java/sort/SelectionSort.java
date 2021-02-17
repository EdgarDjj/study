package sort;

import static sort.SortUtils.swap;

/**
 * Description:
 * 选择排序
 * 在未排序中的序列中找到一个最小的元素，放入到排序完的最后一位。
 * @author:edgarding
 * @date:2021/2/17
 **/
public class SelectionSort implements SortAlgorithm{
    @Override
    public int[] sort(int[] arr) {
        for(int i=0; i<arr.length-1; i++) {
            int min = i;
            for(int j=i+1; j<arr.length; j++) {
                min = arr[min] < arr[j] ? min : j;
            }
            if(min != i) {
                swap(arr, min, i);
            }
        }
        return arr;
    }
}

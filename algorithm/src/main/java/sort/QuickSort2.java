package sort;

import static sort.SortUtils.swap;

/**
 * Description:
 * 快排优化
 * @author:edgarding
 * @date:2021/2/18
 **/
public class QuickSort2 implements SortAlgorithm{

    @Override
    public int[] sort(int[] arr) {
        doSort(arr, 0, arr.length - 1);
        return arr;
    }

    private void doSort(int[] arr, int left, int right) {
        if (left < right) {
            int pivot = partition(arr, left, right);
            doSort(arr, left, pivot - 1);
            doSort(arr, pivot + 1, right);
        }
    }


    private int partition(int[] arr, int left, int right) {
        int pivot = arr[left];
        int i = left;
        while(left < right) {
            while(left < right && arr[right] >= pivot) {
                right--;
            }
            while(left < right && arr[left] <= pivot) {
                left++;
            }
            if(left >= right) {
                break;
            }
            swap(arr, left, right);
        }
        arr[i] = arr[left];
        arr[left] = pivot;
        return left;
    }
}

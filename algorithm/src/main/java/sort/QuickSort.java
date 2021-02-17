package sort;


/**
 * Description:
 *
 * @author:edgarding
 * @date:2021/2/17
 **/
public class QuickSort implements SortAlgorithm{
    @Override
    public int[] sort(int[] arr) {
        quickSort(arr, 0, arr.length - 1);
        return arr;
    }

    private void quickSort(int[] arr, int left, int right) {
        if(left >= right) {
            return;
        }
        int pivot = arr[left];
        int i = left, j = right;
        while(i < j) {
            while(i < j && arr[j] >= pivot) {
                j--;
            }
            arr[i] = arr[j];
            while(i < j && arr[i] <= pivot) {
                i++;
            }
            arr[j] = arr[i];
        }
        arr[i] = pivot;
        quickSort(arr, left, i - 1);
        quickSort(arr, i + 1, right);
    }
}

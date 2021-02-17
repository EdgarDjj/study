package sort;

/**
 * Description:
 *
 * @author:edgarding
 * @date:2021/2/17
 **/
public class MergeSort implements SortAlgorithm{
    @Override
    public int[] sort(int[] arr) {
        doSort(arr, 0, arr.length - 1);
        return arr;
    }

    private void doSort(int[] arr, int left, int right) {
        if(left < right) {
            int mid = left + ((right - left) >> 1);
            doSort(arr, left, mid);
            doSort(arr, mid + 1, right);
            merge(arr, left, mid, right);
        }
    }

    private void merge(int[] arr, int left, int mid, int right) {
        int size = right - left + 1;
        int[] temp = new int[size];
        int i = left, j = mid + 1, index = 0;
        while (i <= mid && j <= right) {
            if(arr[i] < arr[j]) {
                temp[index++] = arr[i++];
            } else {
                temp[index++] = arr[j++];
            }
        }
        while(i <= mid) {
            temp[index++] = arr[i++];
        }
        while(j <= right) {
            temp[index++] = arr[j++];
        }
        System.arraycopy(temp, 0, arr, left, size);
    }
}

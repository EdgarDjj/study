package sort;

/**
 * Description:
 * 直接插入排序
 * @author:edgarding
 * @date:2021/2/17
 **/
public class InsertionSort implements SortAlgorithm{

    @Override
    public int[] sort(int[] arr) {
        for(int i=1; i<arr.length; i++) {
            int key = arr[i];
            int j = i - 1;
            while(j >= 0 && arr[j] > key) {
                arr[j + 1] = arr[j];
                j--;
            }
            arr[j + 1] = key;
        }
        return arr;
    }

}

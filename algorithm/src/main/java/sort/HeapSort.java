package sort;

import static sort.SortUtils.swap;

/**
 * Description:
 * 堆排序
 * 1. 先将初始序列K[1..n]建成一个大顶堆, 那么此时第一个元素K1最大, 此堆为初始的无序区.
 * 2. 再将关键字最大的记录K1 (即堆顶, 第一个元素)和无序区的最后一个记录 Kn 交换, 由此得到新的无序区K[1..n−1]和有序区K[n], 且满足K[1..n−1].keys⩽K[n].key
 * 3. 交换K1 和 Kn 后, 堆顶可能违反堆性质, 因此需将K[1..n−1]调整为堆. 然后重复步骤②, 直到无序区只有一个元素时停止.
 *
 * 节点k的左子节点：2*k+1
 * 节点k的右子节点：2*k+2
 * 父节点：floor(k-1/2)
 * @author:edgarding
 * @date:2021/2/18
 **/
public class HeapSort implements SortAlgorithm{
    @Override
    public int[] sort(int[] arr) {
        // 1、构建大顶堆
        for(int i=arr.length/2-1; i>=0; i--) {
            adjustHeap(arr, i, arr.length);
        }
        //2.调整堆结构+交换堆顶元素与末尾元素
        for(int j=arr.length-1;j>0;j--){
            swap(arr,0,j);//将堆顶元素与末尾元素进行交换
            adjustHeap(arr,0,j);//重新对堆进行调整
        }
        return arr;
    }

    private static void adjustHeap(int[] arr, int i, int length) {
        // 先取出当前元素i
        int temp = arr[i];
        // 从i节点的左节点开始，即2*i+1
        for(int k=i*2+1; k<length; k=k*2+1) {
            // 如果左节点小于右子节点，k指向右子节点
            if(k+1<length && arr[k] < arr[k+1]) {
                k++;
            }
            if(arr[k] > temp) {
                arr[i] = arr[k];
                i = k;
            } else {
                break;
            }
        }
        // 将temp值放到最终的位置
        arr[i] = temp;
    }
}

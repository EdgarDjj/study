package 排序;


import static 排序.SortUtil.swap;

/**
 * Description:
 * 堆排序
 * 1. 先将初始序列K[1..n]建成一个大顶堆, 那么此时第一个元素K1最大, 此堆为初始的无序区.
 * 2. 再将关键字最大的记录K1 (即堆顶, 第一个元素)和无序区的最后一个记录 Kn 交换, 由此得到新的无序区K[1..n−1]和有序区K[n], 且满足K[1..n−1].keys⩽K[n].key
 * 3. 交换K1 和 Kn 后, 堆顶可能违反堆性质, 因此需将K[1..n−1]调整为堆. 然后重复步骤②, 直到无序区只有一个元素时停止.
 * <p>
 * 节点k的左子节点：2*k+1
 * 节点k的右子节点：2*k+2
 * 父节点：floor(k-1/2)
 *
 * @author:edgarding
 * @date:2021/6/13
 **/
public class HeapSort implements Sort {
    @Override
    public int[] sort(int[] arr) {
        // 1.构建大顶堆
        int n = arr.length;
        for (int i = n / 2 - 1; i >= 0; i--) {
            adjustHeap(arr, i, n - 1);
        }

        // 2.调整堆结构 + 交换堆顶与末尾元素 -> 从而达到排序的目的
        for (int j = n - 1; j > 0; j--) {
            // 堆顶的元素由于是最大的，与末尾元素进行交换
            // 使得arr[j]是所有元素中最大的数
            swap(arr, 0, j);
            // 对堆结构进行调整 调整 0 ～ j - 1
            adjustHeap(arr, 0, j);
        }
        return arr;
    }

    private static void adjustHeap(int[] arr, int i, int len) {
        // 取当前节点构建
        int temp = arr[i];
        // 构建i节点的左子树
        for (int k = i * 2 + 1; k < len; k = k * 2 + 1) {
            // 如果左节点小于右节点 k指向右节点
            // 选择左右孩子中一个较大的与当前节点交换
            if (k + 1 <= len && arr[k] < arr[k + 1]) {
                k++;
            }
            if (arr[k] > temp) {
                arr[i] = arr[k];
                i = k;
            } else {
                break;
            }
        }
        // 将tmp值放入到最终位置
        arr[i] = temp;
    }

    /**
     * 优化后的堆排序
     *
     * @param nums
     * @return
     */
    public int[] sortArray(int[] nums) {
        heapSort(nums);
        return nums;
    }

    private void heapSort(int[] nums) {
        // build heap
        int len = nums.length;
        buildHeap(nums, len);
        for (int i = len - 1; i >= 1; --i) {
            swap(nums, i, 0);
            maxHeapify(nums, 0, --len);
        }
    }

    private void buildHeap(int[] nums, int len) {
        for (int i = len / 2; i >= 0; i--) {
            maxHeapify(nums, i, len);
        }
    }

    /**
     * 堆化
     *
     * @param nums
     * @param i
     * @param len
     */
    private void maxHeapify(int[] nums, int i, int len) {
        // 如果i<<1 >= len 说明已经没有左子树，无需在进行循环
        for (; (i << 1) < len; ) {
            int left = i * 2, right = i * 2 + 1, larget = i;
            if (left < len && nums[larget] < nums[left]) {
                larget = left;
            }
            if (right < len && nums[larget] < nums[right]) {
                larget = right;
            }
            // 最大堆从子树向根构造，若无发生交换说明该子树已经为最大堆
            if (larget != i) {
                swap(nums, larget, i);
                i = larget;
            } else {
                break;
            }
        }
    }

}

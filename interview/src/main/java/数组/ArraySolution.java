package 数组;

import java.util.*;

/**
 * Description:
 *
 * @author:edgarding
 * @date:2021/7/10
 **/
public class ArraySolution {
    /**
     * 区间合并问题
     *
     * @param intervals
     * @return
     */
    public int[][] merge(int[][] intervals) {
        // 贪心
        int n = intervals.length;
        if (n == 0) {
            return null;
        }
        HashMap<Integer, int[]> map = new HashMap<>();
        List<int[]> rec = new ArrayList<>();
        // 排序
        Arrays.sort(intervals, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if (o1[0] < o2[0]) {
                    return -1;
                } else if (o1[0] > o2[0]) {
                    return 1;
                } else {
                    // 子区间可以通过最有边界过滤
                    return o2[1] - o1[1];
                }
            }
        });
        // 最右边界
        int r = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            int[] tmp = intervals[i];
            if (intervals[i][1] <= r) {
                continue;
            }
            for (int j = i + 1; j < n; j++) {
                if (intervals[j][0] > tmp[1]) {
                    break;
                } else if (intervals[j][0] <= tmp[1] && intervals[j][1] > tmp[1]) {
                    tmp[1] = intervals[j][1];
                }
            }
            rec.add(tmp);
            if (r < tmp[1]) {
                r = tmp[1];
            }
        }
        int[][] res = new int[rec.size()][2];
        for (int i = 0; i < rec.size(); i++) {
            res[i] = rec.get(i);
        }
        return res;
    }


    /**
     * 实现获取 下一个排列 的函数，算法需要将给定数字序列重新排列成字典序中下一个更大的排列。
     * <p>
     * 如果不存在下一个更大的排列，则将数字重新排列成最小的排列（即升序排列）。
     * <p>
     * 必须 原地 修改，只允许使用额外常数空间。
     * <p>
     * Q.1 2 3 4 5
     * A.1 2 3 5 4
     * <p>
     * Q.1 5 4 3 2
     * A. 2 1 3 4 5
     *
     * @param nums
     */
    public void nextPermutation(int[] nums) {
        int n = nums.length;
        if (n <= 1) {
            return;
        }
        // 数组中升序的最后一位
        int l = 0, r = n - 1;
        for (int i = 0; i < n - 1; i++) {
            if (nums[i] < nums[i + 1]) {
                l = i;
            }
        }
        // 之后查找降序的第一位
        for (int i = l + 1; i < n; i++) {
            if (nums[i] > nums[l]) {
                r = i;
            }
        }
        // 交换两个位置的数
        swap(nums, l, r);
        // 进行排序 对降序的
        Arrays.sort(nums, l + 1, n);
    }

    private static void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }
}

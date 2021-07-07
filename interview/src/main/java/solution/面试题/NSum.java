package solution.面试题;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Description:
 * N数之和
 *
 * @author:edgarding
 * @date:2021/6/25
 **/
public class NSum {

    /**
     * 三数之和为0
     *
     * @param nums
     * @return
     */
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        int n = nums.length;
        if (n < 3) {
            return res;
        }
        Arrays.sort(nums);
        for (int i = 0; i < n - 2; i++) {
            if (nums[i] > 0) {
                return res;
            }
            if (i != 0 && nums[i - 1] == nums[i]) {
                continue;
            }
            int target = -nums[i];
            for (int j = i + 1, k = n - 1; j < k; ) {
                int sum = nums[j] + nums[k];
                if (sum == target) {
                    res.add(Arrays.asList(nums[i], nums[j], nums[k]));
                    while (j < k && nums[j + 1] == nums[j]) {
                        j++;
                    }
                    while (j < k && nums[k - 1] == nums[k]) {
                        k--;
                    }
                    j++;
                    k--;
                } else if (sum > target) {
                    k--;
                } else if (sum < target) {
                    j++;
                }

            }
        }
        return res;
    }
}

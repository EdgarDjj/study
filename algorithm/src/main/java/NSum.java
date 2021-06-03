import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Description:
 * n个数相加为target
 * @author:edgarding
 * @date:2021/3/4
 **/
public class NSum {
    public List<List<Integer>> nSum(int[] nums, int n, int target) {
        List<List<Integer>> res = new ArrayList<>();
        if(nums.length == 0) {
            return res;
        }
        Arrays.sort(nums);
        return nSumTarget(nums, n, 0, target);
    }

    private List<List<Integer>> nSumTarget(int[] nums, int n, int start, int target) {
        int size = nums.length;
        List<List<Integer>> res = new ArrayList<>();
        // 最少是n>2的情况
        if(n < 2 || size < n) {
            return res;
        }
        if(n == 2) {
            int lo = start, hi = size - 1;
            while(lo < hi) {
                List<Integer> ans = new ArrayList<>();
                int left = nums[lo], right = nums[hi];
                int sum = left + right;
                if(sum < target) {
                    while(lo < hi && nums[lo] == left) {
                        lo++;
                    }
                } else if(sum > target) {
                    while(lo < hi && nums[hi] == right) {
                        hi--;
                    }
                } else if(sum == target) {
                    ans.add(left);
                    ans.add(right);
                    res.add(ans);
                    while(lo < hi && nums[lo] == left) {
                        lo ++;
                    }
                    while(lo < hi && nums[hi] == right) {
                        hi--;
                    }
                }
            }
        } else {
            for(int i=start; i<size; i++) {
                List<List<Integer>> ret = nSumTarget(nums, n-1, i+1, target - nums[i]);
                for(List<Integer> arr : ret) {
                    arr.add(nums[i]);
                    res.add(arr);
                }
                while(i < size - 1 && nums[i] == nums[i + 1]) {
                    i++;
                }
            }
        }
        return res;

    }
}

package search;

/**
 * Description:
 * 限制：有序数组中搜索给定的某个目标的索引
 * 二分搜索
 * @author:edgarding
 * @date:2021/2/18
 **/
public class BinarySearch {
    public int binarySearch(int[] arr, int target) {
        int left = 0, right = arr.length - 1;
        while(left <= right) {
            int mid = left + ((right - left) >> 1);
            if(arr[mid] == target) {
                return mid;
            } else if(arr[mid] > target) {
                right = mid - 1;
            } else if(arr[mid] < target) {
                left = mid + 1;
            }
        }
        return -1;
    }

    public int leftBoundSearch(int[] arr, int target) {
        int left = 0, right = arr.length - 1;
        while(left <= right) {
            int mid = left +((right - left) >> 1);
            if(arr[mid] < target) {
                left = mid + 1;
            } else if(arr[mid] > target) {
                right = mid - 1;
            } else if(arr[mid] == target) {
                right = mid - 1;
            }
        }
        if(left >= arr.length || arr[left] != target) {
            return -1;
        }
        return left;
    }

    public int rightBoundSearch(int[] arr, int target) {
        int left = 0, right = arr.length - 1;
        while(left <= right) {
            int mid = left + ((right - left) >> 1);
            if(arr[mid] < target) {
                left = mid + 1;
            } else if(arr[mid] > target) {
                right = mid - 1;
            } else if(arr[mid] == target) {
                left = mid + 1;
            }
        }
        if (right < 0 || arr[right] != target) {
            return -1;
        }
        return right;
    }
}

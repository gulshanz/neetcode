class Solution {
    public int search(int[] nums, int target) {
        // find the pivot, means the minimum element
        int minIndex = findMin(nums);

        // two binary search on correct partition
        int l, r;
        if (target >= nums[minIndex] && target <= nums[nums.length - 1]) {
            l = minIndex;
            r = nums.length - 1;
        } else {
            l = 0;
            r = minIndex - 1;
        }
        while (l <= r) {
            int mid = (l + r) / 2;
            if (nums[mid] == target)
                return mid;
            if (target < nums[mid]) {
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }

        return -1;
    }

    public int findMin(int[] nums) {
        int l = 0;
        int r = nums.length - 1;

        while (l < r) {
            int mid = (l + r) / 2;
            if (nums[mid] > nums[r]) {
                l = mid + 1;
            } else {
                r = mid;
            }
        }
        return l;

    }
}

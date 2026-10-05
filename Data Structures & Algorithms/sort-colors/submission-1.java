class Solution {
    public void sortColors(int[] nums) {
        int l = 0;
        int h = nums.length - 1;
        int mid = 0;

        while (mid <= h) {
            if (nums[mid] == 0) {
                swap(nums, l, mid);
                l++;
                mid++;
            } else if (nums[mid] == 2) {
                swap(nums, h, mid);
                h--;
            } else {
                mid++;
            }
        }
    }

    void swap(int[] nums, int p1, int p2) {
        int temp = nums[p1];
        nums[p1] = nums[p2];
        nums[p2] = temp;
    }
}

// [2,0,1]
// [0,1,2]


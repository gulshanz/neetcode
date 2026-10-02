class Solution {
    public int majorityElement(int[] nums) {
        int majority = nums[0];
        int freq = 1;

        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == majority) {
                freq++;
            } else {
                if (freq == 0) {
                    majority = nums[i];
                    freq++;
                } else {
                    freq--;
                }
            }
        }
        return majority;
    }
}
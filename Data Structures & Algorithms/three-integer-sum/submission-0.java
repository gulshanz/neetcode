class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums);
        HashSet<String> set = new HashSet<>();
        for (int i = 0; i < nums.length - 2; i++) {
            List<Integer> curr = new ArrayList<>();
            int required = -nums[i];
            int p1 = i + 1;
            int p2 = nums.length - 1;
            while (p1 < p2) {
                int sum = nums[p1] + nums[p2];
                if (sum == required) {
                    String hash = nums[i] + " " + nums[p1] + " " + nums[p2];
                    if (!set.contains(hash)) {
                        set.add(hash);
                        Collections.addAll(curr, nums[i], nums[p1], nums[p2]);
                        res.add(curr);
                        curr = new ArrayList<>();
                    }
                    p1++;
                    p2--;
                } else if (sum > required) {
                    p2--;
                } else {
                    p1++;
                }
            }
        }
        return res;
    }
}

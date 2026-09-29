class Solution {
    HashMap<Integer, Integer> count = new HashMap<>();
    List<List<Integer>> res = new ArrayList<>();
    List<Integer> curr = new ArrayList<>();

    public List<List<Integer>> permuteUnique(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            count.merge(nums[i], 1, Integer::sum);
        }
        dfs(nums);
        return res;
    }

    void dfs(int[] nums) {
        if (curr.size() == nums.length) {
            res.add(List.copyOf(curr));
            return;
        }

        for (Map.Entry<Integer, Integer> entry : count.entrySet()) {
            int key = entry.getKey();
            int value = entry.getValue();
            if (value > 0) {
                curr.add(key);
                count.merge(key, -1, Integer::sum);
                dfs(nums);

                // backtrack
                count.merge(key, 1, Integer::sum);
                curr.removeLast();
            }
        }
    }
}
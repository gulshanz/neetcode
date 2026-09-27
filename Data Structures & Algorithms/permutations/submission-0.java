class Solution {
    List<List<Integer>> res = new ArrayList<>();

    public List<List<Integer>> permute(int[] nums) {
        boolean[] used = new boolean[nums.length];
        dfs(new ArrayList<>(), used, nums);
        return res;
    }

    void dfs(List<Integer> curr, boolean[] used, int[] nums) {
        if (curr.size() == nums.length) {
            res.add(List.copyOf(curr));
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            if (used[i])
                continue;
            used[i] = true;
            curr.add(nums[i]);
            dfs(curr, used, nums);
            used[i] = false;
            curr.removeLast();
        }
    }
}
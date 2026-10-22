class Solution {
    List<List<Integer>> res = new ArrayList<>();

    public List<List<Integer>> subsets(int[] nums) {
        dfs(0, new ArrayList<>(), nums);
        return res;
    }

    void dfs(int i, List<Integer> curr, int[] nums) {
        if (i >= nums.length) {
            res.add(List.copyOf(curr));
            return;
        }

        curr.add(nums[i]);
        dfs(i + 1, curr, nums);
        curr.removeLast();
        dfs(i + 1, curr, nums);
    }
}
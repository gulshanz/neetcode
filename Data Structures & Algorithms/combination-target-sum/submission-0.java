class Solution {
    List<List<Integer>> res = new ArrayList<>();
    public List<List<Integer>> combinationSum(int[] nums, int target) {
        dfs(nums, new ArrayList<>(), 0, 0, target);
        return res;
    }

    void dfs(int[] candidates, List<Integer> curr, int i, int total, int target) {
        if (total == target) {
            res.add(List.copyOf(curr));
            return;
        }

        if (i >= candidates.length || total > target)
            return;

        // include
        curr.add(candidates[i]);
        dfs(candidates, curr, i, total + candidates[i], target);

        // or not
        curr.remove(curr.size() - 1);
        dfs(candidates, curr, i + 1, total, target);
    }
}

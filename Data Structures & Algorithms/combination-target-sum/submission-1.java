class Solution {
    List<List<Integer>> res = new ArrayList<>();

    public List<List<Integer>> combinationSum(int[] nums, int target) {
        dfs(0, 0, new ArrayList<>(), nums, target);
        return res;
    }

    void dfs(int i, int sum, List<Integer> curr, int[] candidates, int target) {
        if (sum == target) {
            res.add(List.copyOf(curr));
            return;
        }

        if (sum > target || i >= candidates.length) {
            return;
        }

        curr.add(candidates[i]);
        dfs(i, sum + candidates[i], curr, candidates, target);
        curr.removeLast();
        dfs(i + 1, sum, curr, candidates, target);
    }
}

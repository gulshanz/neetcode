class Solution {
    List<List<Integer>> res = new ArrayList<>();

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        dfs(0, 0, new ArrayList<>(), candidates, target);
        return res;
    }

    void dfs(int index, int sum, List<Integer> curr, int[] candidates, int target) {
        if (sum == target) {
            res.add(List.copyOf(curr));
            return;
        }
        if (sum > target) {
            return;
        }

        for (int i = index; i < candidates.length; i++) {
            curr.add(candidates[i]);
            dfs(i, sum + candidates[i], curr, candidates, target);
            curr.removeLast();
        }
    }
}
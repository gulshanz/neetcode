class Solution {
    List<List<Integer>> res = new ArrayList<>();
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        dfs(0, 0, new ArrayList<>(), candidates, target);
        return res;
    }

    void dfs(int i, int sum, List<Integer> curr, int[] candidates, int target) {
        if (i >= candidates.length || sum >= target) {
            if (sum == target) {
                res.add(List.copyOf(curr));
            }
            return;
        }

        curr.add(candidates[i]);
        dfs(i + 1, sum + candidates[i], curr, candidates, target);
        while (i < candidates.length - 1 && candidates[i] == candidates[i + 1]) {
            i++;
        }
        curr.removeLast();
        dfs(i + 1, sum, curr, candidates, target);
    }
}

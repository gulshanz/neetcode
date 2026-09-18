class Solution {
    List<List<Integer>> res = new ArrayList<>();

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        dfs(0, 0, new ArrayList<>(), target, candidates);
        return res;
    }

    void dfs(int i, int total, List<Integer> curr, int target, int[] candidates) {
        if (total == target) {
            res.add(List.copyOf(curr));
            return;
        }
        if (i >= candidates.length || total > target) {
            return;
        }

        // include
        curr.add(candidates[i]);
        dfs(i + 1, total + candidates[i], curr, target, candidates);

        // skip
        while (i + 1 < candidates.length && candidates[i] == candidates[i + 1]) {
            i++;
        }

        curr.remove(curr.size() - 1);
        dfs(i + 1, total, curr, target, candidates);
    }
}

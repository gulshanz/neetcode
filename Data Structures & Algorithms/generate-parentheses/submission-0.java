class Solution {
    List<String> res = new ArrayList<>();

    public List<String> generateParenthesis(int n) {
        dfs(n, 0, 0, "");
        return res;
    }

    void dfs(int n, int open, int close, String curr) {
        if (open > n || close > n || close > open)
            return;

        if (open == n && close == n) {
            res.add(curr);
            return;
        }

        dfs(n, open + 1, close, curr + "(");
        dfs(n, open, close + 1, curr + ")");

    }

}
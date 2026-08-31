/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */

class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
        if (root == null)
            return new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        List<List<Integer>> res = new ArrayList<>();
        while (!queue.isEmpty()) {
            List<Integer> curr = new ArrayList<>();
            for (int count = queue.size(); count > 0; count--) {
                TreeNode polled = queue.poll();
                curr.add(polled.val);
                if (polled.left != null) {
                    queue.add(polled.left);
                }
                if (polled.right != null) {
                    queue.add(polled.right);
                }
            }
            res.add(curr);
        }
        return res;
    }
}

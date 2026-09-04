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
    List<Integer> list = new ArrayList<>();
    int curr = 0;
    int kthSmallest = -1;
    int k = 0;

    public int kthSmallest(TreeNode root, int k) {
        this.k = k;
        inorder(root);
        return kthSmallest;
    }

    void inorder(TreeNode root) {
        if (root == null || curr >= k)
            return;
        inorder(root.left);
        curr++;
        if (curr == k) {
            kthSmallest = root.val;
            return;
        }
        list.add(root.val);
        inorder(root.right);
    }

}

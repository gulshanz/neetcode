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
    int goodNodes = 0;
    public int goodNodes(TreeNode root) {
        if (root==null) return 0;
        countGood(root, root.val);
        return goodNodes;
    }

    void countGood(TreeNode root, int min){
        if(root==null) return;
        if(min <= root.val){
            goodNodes++;
            min = root.val;
        }
        countGood(root.left, min);
        countGood(root.right, min);
    }
        
}
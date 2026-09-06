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
    HashMap<Integer, Integer> map = new HashMap<>();
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        for (int i = 0; i < preorder.length; i++) {
            map.put(inorder[i], i);
        }

        return build(preorder, 0, 0, preorder.length);
    }

    TreeNode build(int[] preorder, int prestart, int instart, int inend) {
        if (instart >= inend)
            return null;

        TreeNode root = new TreeNode(preorder[prestart]);

        int mid = map.get(root.val);
        int leftsize = mid - instart;

        root.left = build(preorder, prestart + 1, instart, mid);
        root.right = build(preorder, leftsize + prestart + 1, mid + 1, inend);

        return root;
    }
}

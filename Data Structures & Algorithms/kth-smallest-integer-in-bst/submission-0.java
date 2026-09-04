class Solution {
    int curr = 0;
    int kthSmallest = 0;
    int k = 0;
    boolean found = false;

    public int kthSmallest(TreeNode root, int k) {
        this.k = k;
        inorder(root);
        return kthSmallest;
    }

    void inorder(TreeNode root) {
        if (root == null||found)
            return;
        inorder(root.left);
        curr++;
        if (curr == k) {
            kthSmallest = root.val;
            found = true;
            return;
        }
        inorder(root.right);
    }
}
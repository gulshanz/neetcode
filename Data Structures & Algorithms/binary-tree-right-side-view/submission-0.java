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
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if(root==null) return res;
        List<List<Integer>> levels = new ArrayList<>();


        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.offer(root);

        while(!queue.isEmpty()){
            int size = queue.size();
            List<Integer> level = new ArrayList<>();
            for(int i=0;i<size;i++){
                TreeNode polled = queue.poll();
                level.add(polled.val);
                if(polled.left!=null){
                    queue.offer(polled.left);
                }
                if(polled.right!=null){
                    queue.offer(polled.right);
                }
            }
            levels.add(level);
        }

        for(int i=0;i<levels.size();i++){
            res.add(levels.get(i).getLast());
        }

        return res;
    }
}

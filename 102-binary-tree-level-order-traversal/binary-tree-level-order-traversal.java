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
        
        List<List<Integer>> ans = new ArrayList<>();
        if(root == null) {
            return ans;
        }
        
        Queue<TreeNode> q = new ArrayDeque<>();
        q.add(root);
        while(!q.isEmpty()) {
            int size = q.size();
            List<Integer> temp = new ArrayList<>();
            while(size>0) {
                TreeNode top = q.poll();

                if(top.left != null) {
                    q.add(top.left);
                }

                if(top.right != null) {
                    q.add(top.right);
                }
                temp.add(top.val);
                size--;
            }
            if(temp.size()>0) {
                ans.add(temp);
            }
        }

        return ans;
    }
}
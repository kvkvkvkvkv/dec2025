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
    int gmax = Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) {
        sum(root);
        return gmax;    
    }

    public int sum(TreeNode root) {
        
        if(root == null) {
            return 0;
        }

        int left = sum(root.left);
        int right = sum(root.right);



        right = right<0?0:right;
        left = left<0?0:left;
        int sum = root.val + left + right;
        gmax = Math.max(sum, gmax);
        gmax = Math.max(root.val, gmax);
        return Math.max(left, right) + root.val;
    }
}
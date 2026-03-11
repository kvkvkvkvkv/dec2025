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
    int gmax =0;
    public int diameterOfBinaryTree(TreeNode root) {
        dia(root);
        return gmax;
    }

    public int dia(TreeNode root) {
        
        if(root == null) {
            return -1;
        }

        int left = dia(root.left);
        int right = dia(root.right);

        int current = 1 + Math.max(left, right);
        int sum = left + right + 2;
        int max = Math.max(current, sum);
        gmax = Math.max(gmax, max);

        return current;
    }
}
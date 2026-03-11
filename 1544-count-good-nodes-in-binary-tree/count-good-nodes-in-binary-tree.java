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
    public int goodNodes(TreeNode root) {
        return goodNodes(root, root.val);
    }

    public int goodNodes(TreeNode root, int max) {
        if(root == null) {
            return 0;
        }

        int count = 0;
        if(max<=root.val) {
            count++;
            max = root.val;
        }
        int left = goodNodes(root.left, max);
        int right = goodNodes(root.right, max);

        return count + left + right;
    }
}
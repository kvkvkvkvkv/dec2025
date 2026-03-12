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
    int count = 0;
    public int kthSmallest(TreeNode root, int k) {
        count = k;
        return small(root).val;
    }

    public TreeNode small(TreeNode root) {
        if(root == null) {
            return root;
        }

        TreeNode v1 = small(root.left);

        count--;
        if(count == 0) {
            return root;
        }
        TreeNode v2 = small(root.right);
        return v1==null?v2:v1;
    }
}
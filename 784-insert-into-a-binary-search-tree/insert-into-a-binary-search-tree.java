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
    public TreeNode insertIntoBST(TreeNode root, int val) {
        return bst(root, val);
    }

    public TreeNode bst(TreeNode root, int val) {
        if(root == null) {
            TreeNode node = new TreeNode(val);
            return node;
        }

        if(root.val>val) {
            TreeNode left = bst(root.left, val);
            root.left = left;
        } else {
            TreeNode right = bst(root.right, val);
            root.right = right;
        }
        return root;
    }
}
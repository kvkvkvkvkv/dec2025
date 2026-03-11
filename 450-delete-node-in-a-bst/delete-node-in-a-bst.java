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
    public TreeNode deleteNode(TreeNode root, int key) {
        
        if(root == null) {
            return root;
        }

        if(root.val>key) {
            root.left = deleteNode(root.left, key);
        } else if(root.val<key) {
            root.right = deleteNode(root.right, key);
        } else {
            return delete(root);
        }

        return root;
    }

    public TreeNode delete(TreeNode root) {
        TreeNode left = root.left;
        TreeNode right = root.right;


        if(left == null && right == null) {
            return null;
        }

        if(left == null) {
            return right;
        }

        if(right == null) {
            return left;
        }

        TreeNode leftOfRight = right;
        while (leftOfRight.left != null) {
            leftOfRight = leftOfRight.left;
        }
        leftOfRight.left = left;
        root.left = null;
        root.right = null;
        return right;
    }
}
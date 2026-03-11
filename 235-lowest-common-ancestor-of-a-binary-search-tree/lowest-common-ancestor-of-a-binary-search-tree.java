/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(p.val>q.val) {
            return lowestCommonAncestor(root, q, p);
        }

        return lcs(root, p, q);
    }

    public TreeNode lcs(TreeNode root, TreeNode p, TreeNode q) {
        
        if(root == null) {
            return null;
        }

        if(root.val>p.val && root.val<q.val) {
            return root;
        }

        if(root == p || root == q) {
            return root;
        }

        if(root.val>q.val) {
            return lcs(root.left, p, q);
        } else {
            return lcs(root.right, p,q);
        }
    }
}
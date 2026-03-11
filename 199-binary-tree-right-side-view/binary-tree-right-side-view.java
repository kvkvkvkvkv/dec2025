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
    List<Integer> ans = new ArrayList<>();
    public List<Integer> rightSideView(TreeNode root) {
        right(root, 0);
        return ans;
    }

    public void right(TreeNode root, int count) {
        if(root == null) {
            return;
        }

        count++;
        if(count>ans.size()) {
            ans.add(root.val);
        }

        right(root.right, count);
        right(root.left, count);
    }
}
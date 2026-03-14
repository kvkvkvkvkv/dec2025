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
    Map<Pair<TreeNode, Boolean>, Integer> map = new HashMap<>();
    public int rob(TreeNode root) {
        return Math.max(sum(root, true), sum(root, false));
    }

    public int sum(TreeNode root, boolean take) {
        if(root == null) {
            return 0;
        }

        Pair<TreeNode,Boolean> p = new Pair<>(root, take);
        if(map.containsKey(p)) {
            return map.get(p);
        }

        if(take) {
            int add = root.val + sum(root.left, false) +
            sum(root.right, false);
            int skip =  sum(root.left, true) +
            sum(root.right, true);
            int max = Math.max(add, skip);
            map.put(p, max);
            return max;
        } else {
            int add = sum(root.left, true) +
            sum(root.right, true);
            int skip =  sum(root.left, false) +
            sum(root.right, false);
            int max = Math.max(add, skip);
            map.put(p, max);
            return max;
        }
    }
}
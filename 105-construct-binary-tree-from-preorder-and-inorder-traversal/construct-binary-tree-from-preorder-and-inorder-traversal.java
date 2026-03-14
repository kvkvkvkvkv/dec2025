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
    Map<Integer,Integer> map = new HashMap<>();
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        
        for(int i=0;i<preorder.length;i++) {
            map.put(inorder[i],i);
        }

        return build(preorder, 0, preorder.length, 0);
    }

    public TreeNode build(int[] preorder, int l, int r, int i) {
        
        if(l > r || i==preorder.length) {
            return null;
        }

        
        if(l == r) {
            return new TreeNode(preorder[i]);
        }

        int idx = map.get(preorder[i]);
        TreeNode node = new TreeNode(preorder[i]);
        node.left = build(preorder, l, idx-1, i+1);
        node.right = build(preorder, idx+1, r, i+idx-l+1);
        return node;
    }
}
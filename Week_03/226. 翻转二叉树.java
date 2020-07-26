
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
    public TreeNode invertTree(TreeNode root) {
        reviceNode(root);
        return root;
    }
    
    public void reviceNode(TreeNode root) {
        if (root == null) return;
        if (root.left != null || root.right != null) {
            TreeNode temp = root.left;
            root.left = root.right;
            root.right = temp;   
        }
        reviceNode(root.left);
        reviceNode(root.right);
        
    }
}
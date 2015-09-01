/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Solution {
    public boolean isBalanced(TreeNode root) {
        if(root == null)
            return true;
        return isBalanced(root.left) && isBalanced(root.right) && (Math.abs(getHeight(root.left) - getHeight(root.right)) < 2);
    }
    
    public int getHeight(TreeNode root) {
        if(root == null)
            return 0;
        else
            return (Math.max(getHeight(root.left), getHeight(root.right)) + 1);
    }
}
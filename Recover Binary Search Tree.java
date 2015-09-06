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
    TreeNode prev = null;
    TreeNode first = null;
    TreeNode second = null;
    public void recoverTree(TreeNode root) {
        inorder(root);
        if(first != null && second != null) {
            int temp = first.val;
            first.val = second.val;
            second.val= temp;
        }
        return;
    }
    
    public void inorder(TreeNode root) {
        if(root == null)
            return;
        inorder(root.left);
        if(first == null && prev != null && prev.val > root.val)
            first = prev;
        if(first != null && prev != null && prev.val > root.val)
            second = root;
        if(first != null && root.val > first.val)
            return;
        prev = root;
        inorder(root.right);
        return;
    }
}
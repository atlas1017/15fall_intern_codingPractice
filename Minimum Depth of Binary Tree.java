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
    public int minDepth(TreeNode root) {
        if(root == null)
            return 0;
        int min = findMin(root);
        return min;
    }
    
    public int findMin(TreeNode root) {
        if(root.left == null && root.right == null)
            return 1;
        else if(root.left != null && root.right != null)
            return Math.min( findMin(root.left), findMin(root.right) ) + 1;
        else if(root.left != null)
            return findMin(root.left) + 1;
        else
            return findMin(root.right) + 1;
    }
}
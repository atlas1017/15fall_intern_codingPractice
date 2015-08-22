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
    public void flatten(TreeNode root) {
        root = help(root);
        return;
    }
    
    public TreeNode help(TreeNode root)
    {
        if(root == null)
            return null;
        if(root.left != null)
        {
            TreeNode temp = root.right;
            root.right = help(root.left);
            root.left = null;
            
            TreeNode cur = root;
            while(cur.right != null)
                cur = cur.right;
            cur.right = help(temp);
        }
        else
            root.right = help(root.right);
        return root;
    }
}
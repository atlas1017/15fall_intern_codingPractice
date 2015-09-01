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
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<Integer>();
        helpAdding(res, root);
        return res;
    }
    
    public void helpAdding(List<Integer> res, TreeNode root) {
        if(root == null)
            return;
        helpAdding(res, root.left);
        helpAdding(res, root.right);
        res.add(root.val);
        return;
    }
}
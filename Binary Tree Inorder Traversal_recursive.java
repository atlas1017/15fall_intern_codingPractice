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
    public List<Integer> inorderTraversal(TreeNode root) {
        // left --> root --> right
        List<Integer> res = new ArrayList<Integer>();
        helpAdd(root, res);
        return res;
    }
    
    public void helpAdd(TreeNode root, List<Integer> res) {
        if(root == null)
            return;
        helpAdd(root.left, res);
        res.add(root.val);
        helpAdd(root.right, res);
        return;
    }
}
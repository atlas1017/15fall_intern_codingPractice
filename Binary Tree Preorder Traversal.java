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
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<Integer> ();
        List<TreeNode> nodeStack = new ArrayList<TreeNode>();
        if(root != null)
            nodeStack.add(root);
        else
            return res;
            
        while(!nodeStack.isEmpty()) {
            TreeNode last = nodeStack.remove(nodeStack.size() - 1);
            if(last.right != null)
                nodeStack.add(last.right);
            if(last.left != null)
                nodeStack.add(last.left);
            res.add(last.val);
        }
        return res;
    }
}
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
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        // important null pointer
        if(root == null)
            return res;
        List<Integer> one = new ArrayList<Integer>();
        List<TreeNode> cur = new ArrayList<TreeNode>();
        cur.add(root);
        one.add(root.val);
        helpAdding(res, one, cur);
        return res;
    }
    
    public void helpAdding(List<List<Integer>> res, List<Integer> one, List<TreeNode> cur) {
        if(cur.isEmpty())
            return;
        res.add(one);
        List<Integer> temp = new ArrayList<Integer>();
        List<TreeNode> next = new ArrayList<TreeNode>();
        for(TreeNode oneNode : cur) {
            if(oneNode.left != null) {
                next.add(oneNode.left);
                temp.add(oneNode.left.val);
            }
            if(oneNode.right != null) {
                next.add(oneNode.right);
                temp.add(oneNode.right.val);
            }
        }
        helpAdding(res, temp, next);
        return;
    }
}
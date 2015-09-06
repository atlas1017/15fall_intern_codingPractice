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
    public boolean isValidBST(TreeNode root) {
        if(root == null)
            return true;
        List<Integer> res = inOrder(root);
        for(int i = 0; i < res.size() - 1; i++)
            if(res.get(i) >= res.get(i + 1)) return false;
        return true;
    }
    
    public List<Integer> inOrder(TreeNode root) {
        List<Integer> res = null;
        if(root.left != null) {
            res = inOrder(root.left);
            res.add(root.val);
        }
        else {
            res = new ArrayList<Integer>();
            res.add(root.val);
        }
        if(root.right != null) {
            for(Integer one : inOrder(root.right))
                res.add(one);
        }
        return res;
    }
}
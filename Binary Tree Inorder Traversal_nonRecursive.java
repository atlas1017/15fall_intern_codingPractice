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
        if(root == null)
            return res;
        List<TreeNode> stack = new ArrayList<TreeNode>();
        TreeNode cur = root;
        while(cur != null) {
            stack.add(cur);
            cur = cur.left;
        }
        while(!stack.isEmpty()) {
            TreeNode temp = stack.remove(stack.size() - 1);
            res.add(temp.val);
            
            cur = temp.right;
            while(cur != null) {
                stack.add(cur);
                cur = cur.left;
            }
        }
        return res;
    }
}
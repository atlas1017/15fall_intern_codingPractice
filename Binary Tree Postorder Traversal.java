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
        if(root == null)
            return res;
        List<TreeNode> stack = new ArrayList<TreeNode>();
        TreeNode cur = root;
        stack.add(cur);
        while(cur.left != null || cur.right != null) {
            if(cur.left != null)
                cur = cur.left;
            else
                cur = cur.right;
            stack.add(cur);
        }
        while(!stack.isEmpty()) {
            TreeNode one = stack.remove(stack.size() - 1);
            res.add(one.val);
            if(stack.isEmpty())
                break;
            TreeNode last = stack.get(stack.size() - 1);
            if(last.right != one && last.right != null) {
                TreeNode temp = last.right;
                stack.add(temp);
                while(temp.left != null || temp.right != null) {
                    if(temp.left != null)
                        temp = temp.left;
                    else
                        temp = temp.right;
                    stack.add(temp);
                }
            }
        }
        return res;
    }
}
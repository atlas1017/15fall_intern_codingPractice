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
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> res = new ArrayList<List<Integer>> ();
        if(root == null)
            return res;
        List<Integer> one = new ArrayList<Integer> ();
        int temp = 0;
        helpAdding(root, temp, sum, res, one);
        return res;
    }
    
    public void helpAdding(TreeNode root, int temp, int sum, List<List<Integer>> res, List<Integer> one)
    {
        if(root.left == null && root.right == null && root.val + temp == sum) {
            List<Integer> copy = new ArrayList<Integer> (one);
            copy.add(root.val);
            res.add(copy);
        }
        else {
            one.add(root.val);
            temp += root.val;
            if(root.left != null)
                helpAdding(root.left, temp, sum, res, one);
            if(root.right != null)
                helpAdding(root.right, temp, sum, res, one);
            one.remove(one.size() - 1);
            temp -= root.val;
        }
        return;
    }
}
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
    public int maxPathSum(TreeNode root) {
        int[] res = new int[1];
        res[0] = Integer.MIN_VALUE;
        getMax(root, res);
        return res[0];
    }
    
    public int getMax(TreeNode root, int[] res) {
        if(root == null)
            return 0;
        int left = getMax(root.left, res);
        int right = getMax(root.right, res);
        int one = Math.max(left, right);
        int ret = one > 0 ? one + root.val : root.val;
        //note: why here we did not compare the res with left or right
        // reason 1 : the res[0] has been updated through calling getMax for left and right;
        // reason 2 : if left or right is null(0) we dont want to utilize them anymore
        res[0] = Math.max(res[0], Math.max(left + right + root.val, ret));
        return ret;
    }
}
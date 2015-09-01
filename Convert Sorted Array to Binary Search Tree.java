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
    public TreeNode sortedArrayToBST(int[] nums) {
        if(nums == null)
            return null;
        return makeTree(nums, 0, nums.length - 1);
    }
    
    public TreeNode makeTree(int[] nums, int start, int end) {
        if(start > end)
            return null;
        if(start == end)
            return new TreeNode(nums[start]);
        else {
            int mid = (start + end) / 2;
            TreeNode one = new TreeNode(nums[mid]);
            one.left = makeTree(nums, start, mid - 1);
            one.right = makeTree(nums, mid + 1, end);
            return one;
        }
    }
}
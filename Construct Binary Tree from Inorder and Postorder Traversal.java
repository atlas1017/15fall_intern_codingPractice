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
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        int len = inorder.length;
        return buildHelper(inorder, 0, len - 1, postorder, 0, len - 1);
    }
    
    public TreeNode buildHelper(int[] in, int inStart, int inEnd, int[] post, int postStart, int postEnd) {
        if(inStart > inEnd)
            return null;
        int pivot = post[postEnd];
        int inIndex = findPivot(in, pivot);
        
        TreeNode one = new TreeNode(pivot);
        one.left = buildHelper(in, inStart, inIndex - 1, post, postStart, postStart + (inIndex - 1 - inStart) );
        one.right = buildHelper(in, inIndex + 1, inEnd, post, postEnd - 1 - (inEnd - inIndex - 1) , postEnd - 1);
        return one;
    }
    
    public int findPivot(int[] nums, int target) {
        for(int i = 0; i < nums.length; i++) {
            if(nums[i] == target)
                return i;
        }
        return -1;
    }
}
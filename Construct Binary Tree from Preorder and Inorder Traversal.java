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
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        int len = preorder.length;
        return buildHelper(preorder, 0, len - 1, inorder, 0, len - 1);
    }
    
    public TreeNode buildHelper(int[] pre, int preStart, int preEnd, int[] in, int inStart, int inEnd) {
        if(preStart > preEnd)
            return null;
        int pivot = pre[preStart];
        int index = find(in, pivot);
        
        TreeNode one = new TreeNode(pivot);
        one.left = buildHelper(pre, preStart + 1, preStart + 1 + (index - 1 - inStart), in, inStart, index - 1);
        one.right = buildHelper(pre, preEnd - (inEnd - index - 1), preEnd, in, index + 1, inEnd);
        
        return one;
    }
    
    public int find(int[] nums, int target) {
        for(int i = 0; i < nums.length; i++) {
            if(nums[i] == target)
                return i;
        }
        return -1;
    }
}
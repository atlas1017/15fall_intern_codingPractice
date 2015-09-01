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
    public int sumNumbers(TreeNode root) {
        if(root == null)
            return 0;
        List<Integer> nums = new ArrayList<Integer> ();
        
        int[] sum = new int[1];
        sum[0] = 0;
        
        getSum(nums, root, sum);
        return sum[0];
    }
    
    public void getSum(List<Integer> nums, TreeNode root, int[] sum) {
        if(root.left == null && root.right == null)
            sum[0] += add(nums)*10 + root.val;
        else {
            if(root.left != null) {
                nums.add(root.val);
                getSum(nums, root.left, sum);
                nums.remove(nums.size() - 1);
            }
            
            if(root.right != null) {
                nums.add(root.val);
                getSum(nums, root.right, sum);
                nums.remove(nums.size() - 1);
            }
        }
        return;
    }
    
    public int add(List<Integer> nums) {
        int res = 0;
        for(int i = 0; i < nums.size(); i++) {
            int temp = nums.get(i);
            res = res*10 + temp;
        }
        return res;
    }
}
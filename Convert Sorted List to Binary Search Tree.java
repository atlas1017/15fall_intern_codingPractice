/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
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
    public TreeNode sortedListToBST(ListNode head) {
        int len = getlen(head);
        int[] nums = new int[len];
        ListNode cur = head;
        int curIndex = 0;
        while(cur != null) {
            nums[curIndex++] = cur.val;
            cur = cur.next;
        }
        
        TreeNode res = makeTree(nums, 0, len - 1);
        return res;
    }
    
    public TreeNode makeTree(int[] nums, int start, int end) {
        if(start > end)
            return null;
        int mid = (start + end) / 2;
        TreeNode one = new TreeNode(nums[mid]);
        one.left = makeTree(nums, start, mid - 1);
        one.right = makeTree(nums, mid + 1, end);
        return one;
    }
    
    public int getlen(ListNode head){
        int count = 0;
        ListNode cur = head;
        while(cur != null) {
            cur = cur.next;
            count++;
        }
        return count;
    }
}
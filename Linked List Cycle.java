/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public boolean hasCycle(ListNode head) {
        boolean first = true;
        ListNode prev = head;
        ListNode cur = head;
        
        while(cur != null)
        {
            if(!first && cur == prev)
                return true;
                
            prev = prev.next;
            cur = cur.next;
            if(cur == null)
                break;
            cur = cur.next;
            first = false;    
        }
        return false;
    }
}
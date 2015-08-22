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
    public ListNode detectCycle(ListNode head) {
        boolean first = true;
        ListNode prev = head;
        ListNode cur = head;
        
        
        while(cur != null)
        {
            if(!first && prev == cur)
                break;
            cur = cur.next;
            if(cur == null)
                return null;
            cur = cur.next;
            prev = prev.next;
            first = false;
        }
        
        if(cur == null)
            return null;
        
        ListNode temp = head;
        while(temp != cur)
        {
            temp = temp.next;
            cur = cur.next;
        }
        return temp;
    }
}
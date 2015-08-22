/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */


// the point is thatthe position of some elements change
public class Solution {
    public ListNode swapPairs(ListNode head) {
        ListNode phead = new ListNode(0);
        phead.next = head;
        
        ListNode prev = phead;
        while(prev != null)
        {
            if(prev.next == null || prev.next.next == null)
                break;
            ListNode cur = prev.next.next;
            
            ListNode temp1 = prev.next;
            ListNode temp2 = cur.next;
            
            prev.next = cur;
            cur.next = temp1;
            temp1.next = temp2;
            
            prev = prev.next.next;
        }
        return phead.next;
    }
}
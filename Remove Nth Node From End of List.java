/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode phead = new ListNode(1);
        phead.next = head;
        ListNode prev = phead;
        ListNode cur = phead;
        int count = 0;
        while(count < n + 1 && cur != null)
        {
            count++;
            cur = cur.next;
        }
        
        while(cur != null)
        {
            cur = cur.next;
            prev = prev.next;
        }
        
        prev.next = prev.next.next;
        return phead.next;
    }
}
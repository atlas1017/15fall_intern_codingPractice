/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        if(head == null)
            return head;
        ListNode phead = new ListNode(1);
        phead.next = head;
        ListNode prev = phead;
        ListNode cur = phead.next;
        while(cur != null)
        {
            if(cur.next == null)
                break;
            if(cur.next.val == cur.val)
            {
                int tempVal = cur.val;
                while(cur != null && cur.val == tempVal)
                    cur = cur.next;
                prev.next = cur;
            }
            else
            {
                cur = cur.next;
                prev = prev.next;
            }
        }
        return phead.next;
    }
}
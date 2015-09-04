/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
// create a phead;
// find the next one to conctanate -- if duplicate skip, or if last one or unique, update 
// then prev.next = null; whcih means that if last was added, that is fine, but if last one 
// is not added then we will skip them and directly add null

public class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        ListNode phead = new ListNode(1);
        phead.next = head;
        ListNode cur = head; // 
        ListNode prev = phead;
        while(cur != null) {
            if(cur.next != null && cur.next.val == cur.val) {
                // skip if we find duplicate
                while(cur.next != null && cur.next.val == cur.val)
                    cur = cur.next;
                cur = cur.next;
            }
            else {
                prev.next = cur;
                cur = cur.next;
                prev = prev.next;
            }
        }
        prev.next = null;
        return phead.next;
    }
}
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode res = new ListNode(1);
        ListNode cur = res;
        ListNode p1 = l1;
        ListNode p2 = l2;
        
        while(p1 != null && p2 != null)
        {
            if(p1.val < p2.val)
            {
                cur.next = p1;
                cur = cur.next;
                p1 = p1.next;
            }
            else
            {
                cur.next = p2;
                p2 = p2.next;
                cur = cur.next;
            }
        }
        
        if(p1 != null)
            cur.next = p1;
        if(p2 != null)
            cur.next = p2;
        
        return res.next;
    }
}
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode insertionSortList(ListNode head) {
        ListNode phead = new ListNode(1);
        ListNode cur = head;
        while(cur != null)
        {
            ListNode temp = cur.next;
            helpInsert(phead, cur);
            cur = temp;
        }
        return phead.next;
    }
    
    public void helpInsert(ListNode phead, ListNode temp)
    {
        ListNode cur = phead;
        while(cur.next != null && cur.next.val < temp.val)
            cur = cur.next;
        ListNode after =  cur.next;
        cur.next = temp;
        temp.next = after;
        return;
    }
}
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode sortList(ListNode head) {
        if(head == null || head.next == null)
            return head;
        int len = getLen(head);
        //System.out.println("the len is " + len);
        int half = len / 2;
        ListNode first = head;
        ListNode cur = first;
        for(int i = 0; i < half - 1; i++)
            cur = cur.next;
        ListNode second = cur.next;
        cur.next = null;
        first = sortList(first);
        second = sortList(second);
        return merge(first, second);
    }
    
    public int getLen(ListNode head)
    {
        int count = 0;
        ListNode cur = head;
        while(cur != null)
        {
            cur = cur.next;
            count++;
        }
        return count;
    }
    
    public ListNode merge(ListNode p1, ListNode p2)
    {
        ListNode phead = new ListNode(1);
        ListNode cur = phead;
        
        while(p1 != null && p2 != null)
        {
            if(p1.val < p2.val)
            {
                cur.next = p1;
                p1 = p1.next;
                cur = cur.next;
                cur.next = null;
            }
            else
            {
                cur.next = p2;
                p2 = p2.next;
                cur = cur.next;
                cur.next = null;
            }
        }
        
        while(p1 != null)
        {
            cur.next = p1;
            p1 = p1.next;
            cur = cur.next;
            cur.next = null;
        }
        
        while(p2 != null)
        {
            cur.next = p2;
            p2 = p2.next;
            cur = cur.next;
            cur.next = null;
        }
        
        return phead.next;
    }
}
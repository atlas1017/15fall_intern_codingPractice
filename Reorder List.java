/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public void reorderList(ListNode head) {
        int len = getLen(head);
        if(len <= 2)
            return;
        int half = (len + 1) / 2;
        
        ListNode cur = head;
        for(int i = 0; i < half - 1; i++)
            cur = cur.next;
        ListNode second = cur.next;
        cur.next = null;
        second = reverse(second);
        merge(head, second);
        return;
    }
    
    public int getLen(ListNode head)
    {
        ListNode cur = head;
        int count = 0;
        while(cur != null)
        {
            count++;
            cur = cur.next;
        }
        return count;
    }
    
    public ListNode reverse(ListNode head)
    {
        ListNode prev = head;
        ListNode cur = prev.next;
        prev.next = null;
        
        ListNode temp = null;
        while(cur != null)
        {
            temp = cur.next;
            cur.next = prev;
            prev = cur;
            cur = temp;
        }
        return prev;
    }
    
    public void merge(ListNode p1, ListNode p2)
    {
        ListNode n1 = p1;
        ListNode n2 = p2;
        ListNode phead = new ListNode(1);
        ListNode cur = phead;
        
        while(n1 != null && n2 != null)
        {
            cur.next = n1;
            n1 = n1.next;
            cur = cur.next;
            
            cur.next = n2;
            n2 = n2.next;
            cur = cur.next;
        }
        
        if(n1 != null)
            cur.next = n1;
        return;
    }
}
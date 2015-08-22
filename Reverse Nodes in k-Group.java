/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
     public ListNode reverseKGroup(ListNode head, int k) {
       ListNode phead = new ListNode(1);
       phead.next = head;
       if(k == 1)
        return phead.next;
       
       ListNode prev = phead;
       ListNode cur = phead;
       
       while(cur != null)
       {
           for(int i = 0; i < k; i++)
           {
               cur = cur.next;
               if(cur == null)
                return phead.next;
           }
           
           ListNode temp = prev.next;
           ListNode after = cur.next;
           reverse(prev, cur);
           prev = temp;
           cur = prev;
           prev.next = after;
       }
       return phead.next;
    }
    
    
    public ListNode reverse(ListNode p1, ListNode p2)
    {
        ListNode prev = p1.next;
        ListNode cur = prev.next;
        prev.next = null;
        
        while(prev != p2)
        {
            ListNode temp = cur.next;
            cur.next = prev;
            prev = cur;
            cur = temp;
        }
        p1.next = prev;
        return p1;
    }
}
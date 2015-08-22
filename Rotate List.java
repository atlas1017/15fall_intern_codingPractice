/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode rotateRight(ListNode head, int k) {
        int len = getLen(head);
        if(len == 0)
            return head;
        k = k % len;
        if(k == 0)
            return head;
        
        ListNode prev = head;
        ListNode tail = head;
        for(int i = 0; i < k; i++)
            tail = tail.next;
        
        while(tail.next != null)
        {
            prev = prev.next;
            tail = tail.next;
        }
        
        ListNode temp = prev.next;
        tail.next = head;
        prev.next = null;
        return temp;
    }
    
    public int getLen(ListNode head)
    {
        int count = 0;
        ListNode cur = head;
        while(cur != null)
        {
            count++;
            cur = cur.next;
        }
        return count;
    }
}
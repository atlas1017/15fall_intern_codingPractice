/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
       ListNode phead = new ListNode(1);
       ListNode cur = phead;
       ListNode n1 = l1;
       ListNode n2 = l2;
       int addOn = 0;
       
       while(n1 != null && n2 != null)
       {
           int temp = n1.val + n2.val + addOn;
           ListNode one = new ListNode(temp % 10);
           addOn = temp / 10;
           
           cur.next = one;
           cur = one;
           
           n1 = n1.next;
           n2 = n2.next;
       }
       
       while(n1 != null)
       {
           int temp = n1.val + addOn;
           ListNode one = new ListNode(temp % 10);
           addOn = temp / 10;
           
           cur.next = one;
           cur = one;
           
           n1 = n1.next;
       }
       
       while(n2 != null)
       {
           int temp = n2.val + addOn;
           ListNode one = new ListNode(temp % 10);
           addOn = temp / 10;
           
           cur.next = one;
           cur = one;
           
           n2 = n2.next;
       }
       
       if(addOn > 0)
       {
           cur.next = new ListNode(addOn);;
       }
       
       return phead.next;
    }
}
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode partition(ListNode head, int x) {
      ListNode phead = new ListNode(1);
      phead.next = head;
      
      // p1, p2 will be the end of the smaller part
      ListNode p1 = phead;
      ListNode p2 = phead.next;
      
      while(p2 != null && p2.val < x)
      {
          p1 = p1.next;
          p2 = p2.next;
      }
      
      // q1 q2 will be the current iterating pos
      ListNode q1 = p1;
      ListNode q2 = p2;
      
      while(q2 != null)
      {
          if(q2.val >= x)
          {
              q1 = q1.next;
              q2 = q2.next;
          }
          else
          {
              //insert(p1, q1)
              ListNode temp = q2.next;
              p1.next = q2;
              q2.next = p2;
              q1.next = temp;
              
              p1 = q2;
              q2 = temp;
          }
      }
      
      return phead.next;
      
    }
}
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode reverseBetween(ListNode head, int m, int n) {
        if(head == null || m == n)
            return head;
        ListNode phead = new ListNode(0);
        phead.next = head;
        ListNode mPrev = phead;
        ListNode nNode = phead;
        for(int i = 0; i < m - 1; i++)
            mPrev = mPrev.next;
        for(int i = 0; i < n; i++)
            nNode = nNode.next;
        ListNode mNode = mPrev.next;
        ListNode nAfter = nNode.next;
        mPrev.next = null;
        nNode.next = null;
        reverse(mNode);
        mPrev.next = nNode;
        mNode.next = nAfter;
        return phead.next;
    }
    
    public void reverse(ListNode head) {
        if(head == null || head.next == null)
            return;
        ListNode cur = head;
        ListNode temp = cur.next;
        head.next = null;
        while(temp != null) {
            ListNode next = temp.next;
            temp.next = cur;
            cur = temp;
            temp = next;
            System.out.println(cur.val);
        }
        return;
    }
}
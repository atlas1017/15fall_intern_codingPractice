/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        if(lists == null || lists.length == 0)
            return null;
        
        ListNode phead = new ListNode(1);
        ListNode cur = phead;
        
        PriorityQueue<ListNode> q = new PriorityQueue<ListNode>(lists.length, new Comparator<ListNode>() 
        {
            public int compare(ListNode a, ListNode b)
            {
                if(a.val < b.val)
                    return -1;
                else if(a.val > b.val)
                    return 1;
                else
                    return 0;
            }
        });
        
        for(ListNode one : lists)
        {
            if(one != null)
                q.add(one);
        }
        while(q.size() > 0)
        {
            ListNode small = q.poll();
            cur.next = small;
            if(small.next != null)
                q.add(small.next);
            cur = small;
            cur.next = null;
        }
        
        
        return phead.next;
    }
}
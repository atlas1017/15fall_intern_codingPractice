/**
 * Definition for singly-linked list with a random pointer.
 * class RandomListNode {
 *     int label;
 *     RandomListNode next, random;
 *     RandomListNode(int x) { this.label = x; }
 * };
 */
public class Solution {
    public RandomListNode copyRandomList(RandomListNode head) {
        if(head == null)
            return null;
        RandomListNode cur = head;
        RandomListNode phead = new RandomListNode(1);
        RandomListNode cur1 = phead;
        HashMap<RandomListNode, RandomListNode> map = new HashMap<RandomListNode, RandomListNode>();
        
        while(cur != null)
        {
            RandomListNode one = new RandomListNode(cur.label);
            cur1.next = one;
            map.put(cur, one);
            cur1 = one;
            cur = cur.next;
        }
        
        cur = head;
        cur1 = phead.next;
        while(cur != null)
        {
            RandomListNode temp = cur.random;
            RandomListNode temp1 = map.get(temp);
            cur1.random = temp1;
            
            cur = cur.next;
            cur1 = cur1.next;
        }
        return phead.next;
    }
}
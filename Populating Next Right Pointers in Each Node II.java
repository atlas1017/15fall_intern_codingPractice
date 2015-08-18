/**
 * Definition for binary tree with next pointer.
 * public class TreeLinkNode {
 *     int val;
 *     TreeLinkNode left, right, next;
 *     TreeLinkNode(int x) { val = x; }
 * }
 */
public class Solution {
    public void connect(TreeLinkNode root) {
        if(root == null)
            return;
        TreeLinkNode lastHead = root;
        TreeLinkNode lastCur = null;
        TreeLinkNode head = null;
        TreeLinkNode cur = null;
        
        while(lastHead != null)
        {
            // this while handles all levels
            lastCur = lastHead;
            
            while(lastCur != null)
            {
                // this while will handle with one level
                if(lastCur.left != null)
                {
                    if(head == null)
                    {
                        head = lastCur.left;
                        cur = head;
                    }
                    else
                    {
                        cur.next = lastCur.left;
                        cur = cur.next;
                    }
                }
                
                // this is for the right branch
                if(lastCur.right != null)
                {
                    if(head == null)
                    {
                        head = lastCur.right;
                        cur = head;
                    }
                    else
                    {
                        cur.next = lastCur.right;
                        cur = lastCur.right;
                    }
                }
                
                
                lastCur = lastCur.next;
            }
        
            lastHead = head;
            head = null;
            cur = null;
        }
        
        return;
    }
}
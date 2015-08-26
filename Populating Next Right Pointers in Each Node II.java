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
        TreeLinkNode lastCur = root;
        TreeLinkNode head = null;
        TreeLinkNode cur = null;
        while(lastHead != null) {
            // this will handle all levels of tree
            lastCur = lastHead;
            head = null;
            cur = null;
            while(lastCur != null){
                // this will handle with one level
                if(lastCur.left != null) {
                    TreeLinkNode one = lastCur.left;
                    if(head != null)
                        cur.next = one;
                    else
                        head = one;
                    cur = one;
                }
                if(lastCur.right != null) {
                    TreeLinkNode one = lastCur.right;
                    if(head != null)
                        cur.next = one;
                    else
                        head = one;
                    cur = one;
                }
                lastCur = lastCur.next;
            }
            lastHead = head;
        }
        return;
    }
}
/**
 * Definition for binary tree with next pointer.
 * public class TreeLinkNode {
 *     int val;
 *     TreeLinkNode left, right, next;
 *     TreeLinkNode(int x) { val = x; }
 * }
 */
public class Solution {
    public void connect(TreeLinkNode root) 
    {
        int len = getDepth(root);
        for(int i = 0; i < len; i++)
            link(root, i);
        return;
    }
    
    public int getDepth(TreeLinkNode root)
    {
        int count = 0;
        TreeLinkNode cur = root;
        while(cur != null)
        {
            count++;
            cur = cur.left;
        }
        return count;
    }
    
    
    public void link(TreeLinkNode root, int depth)
    {
        if(depth == 0)
        {
            root.next = null;
            return;
        }
        
        int num = 1 << depth; // num is the total number of nodes on this level
        TreeLinkNode prev = getNode(root, depth, 0);
        for(int i = 0; i < num - 1; i++)
        {
            TreeLinkNode cur = getNode(root, depth, i + 1); // on the depth level, find the (i+1)th node
            prev.next = cur;
            prev = cur;
        }
        
        prev.next = null;
        return;
    }
    
    public TreeLinkNode getNode(TreeLinkNode root, int depth, int num)
    {
        TreeLinkNode cur = root;
        for(int i = 0; i < depth; i++)
        {
            int temp = 1 << (depth - i - 1);
            if(num >= temp)
            {
                num -= temp;
                cur = cur.right;
            }
            else
                cur = cur.left;
        }
        return cur;
    }
}
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Solution {
    public List<TreeNode> generateTrees(int n) {
        List<TreeNode> res = new ArrayList<TreeNode>();
        res = makeTree(1, n);
        return res;
    }
    
    // do this recursively
    // the one node situation is included in main situations
    public List<TreeNode> makeTree(int start, int end) {
        List<TreeNode> res = new ArrayList<TreeNode>();
        if(end < start) {
            res.add(null);
            return res;
        }
            
        for(int i = start; i <= end; i++) {
            List<TreeNode> left = makeTree(start, i - 1);
            List<TreeNode> right = makeTree(i + 1, end);
            for(int m = 0; m < left.size(); m++) {
                for(int n = 0; n < right.size(); n++) {
                    TreeNode one = new TreeNode(i);
                    one.left = left.get(m);
                    one.right = right.get(n);
                    res.add(one);
                }
            }
        }
        return res;
    }
}
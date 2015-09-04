/**
 * Definition for undirected graph.
 * class UndirectedGraphNode {
 *     int label;
 *     List<UndirectedGraphNode> neighbors;
 *     UndirectedGraphNode(int x) { label = x; neighbors = new ArrayList<UndirectedGraphNode>(); }
 * };
 */
public class Solution {
    public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
        HashMap<UndirectedGraphNode, UndirectedGraphNode> map = new HashMap<UndirectedGraphNode, UndirectedGraphNode>();
        return cloneHelper(node, map);
    }
    
    public UndirectedGraphNode cloneHelper(UndirectedGraphNode node, HashMap<UndirectedGraphNode, UndirectedGraphNode> map) {
        if(node == null)
            return null;
        UndirectedGraphNode one = new UndirectedGraphNode(node.label);
        map.put(node, one);
        for(UndirectedGraphNode temp : node.neighbors) {
            if(map.containsKey(temp))
                one.neighbors.add(map.get(temp));
            else
                one.neighbors.add(cloneHelper(temp, map));
        }
        return one;
    }
}
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
        if(node == null)
            return null;
        HashSet<UndirectedGraphNode> visited = new HashSet<UndirectedGraphNode>();
        HashSet<UndirectedGraphNode> cur = new HashSet<UndirectedGraphNode>();
        HashSet<UndirectedGraphNode> next = new HashSet<UndirectedGraphNode>();
        HashMap<UndirectedGraphNode, UndirectedGraphNode> map = new HashMap<UndirectedGraphNode, UndirectedGraphNode>();
        cur.add(node);
        UndirectedGraphNode res = new UndirectedGraphNode(node.label);
        map.put(node, res);
        
        while(!cur.isEmpty()) {
            next = new HashSet<UndirectedGraphNode>();
            for(UndirectedGraphNode oneNode : cur) {
                UndirectedGraphNode oneCopy = map.get(oneNode);
                for(UndirectedGraphNode oneNeighbor : oneNode.neighbors) {
                    if(visited.contains(oneNeighbor)) 
                        continue;
                    UndirectedGraphNode tempNeighbor = new UndirectedGraphNode(oneNeighbor.label);
                    map.put(oneNeighbor, tempNeighbor);
                    next.add(oneNeighbor);
                    oneCopy.neighbors.add(tempNeighbor);
                    tempNeighbor.neighbors.add(oneCopy);
                }
            }
            visited = cur;
            cur = next;
        }
        return res;
    }
}
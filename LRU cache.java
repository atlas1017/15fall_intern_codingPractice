// could make it better by attaching the value also to the node
// so that we do not need 2 hashMap any more

public class LRUCache {

    private class Node
    {
        int key;
        Node prev;
        Node next;
        public Node(int k)
        {
            key = k;
            prev = null;
            next = null;
        }
    }

    int count;
    int limit;

    Node head;
    Node end;
    HashMap<Integer, Node> nodeMap;
    HashMap<Integer, Integer> valMap;



    public LRUCache(int capacity) {
        count = 0;
        limit = capacity;

        nodeMap = new HashMap<Integer, Node>();
        valMap = new HashMap<Integer, Integer>();

        head = new Node(Integer.MIN_VALUE);
        end = head;
    }
    
    public int get(int key) {
        if(valMap.containsKey(key))
        {
            // remove the node and add it to the end
            Node keyNode = nodeMap.get(key);
            if(keyNode.next != null)
                updateNode(keyNode);
            // return value
            return valMap.get(key);
        }
        else
            return -1;
    }
    
    public void set(int key, int value) {
        if(valMap.containsKey(key))
        {
            // set the new value
            valMap.put(key, value);
            // remove the node and add it to the end 
             Node keyNode = nodeMap.get(key);
            if(keyNode.next != null)
                updateNode(keyNode);
        }
        else
        {
            // adding it to the list, two maps;
            Node one = new Node(key);
            end.next = one;
            one.prev = end;
            end = one;

            valMap.put(key, value);
            nodeMap.put(key, one);


            count++;
            if(count > limit)
            {
                // do the eviction
                Node evicNode = head.next;
                int evicKey = evicNode.key;

                evicNode.next.prev = head;
                head.next = evicNode.next;

                valMap.remove(evicKey);
                nodeMap.remove(evicKey);

                evicNode.next = null;
                evicNode.prev = null;
                evicNode = null;

                count--;
            }
        }
    }
    
    public void updateNode(Node keyNode)
    {
        Node nextNode = keyNode.next;
        Node prevNode = keyNode.prev;
        nextNode.prev = prevNode;
        prevNode.next = nextNode;

        keyNode.next = null;
        keyNode.prev = end;
        end.next = keyNode;

        end = keyNode;
        return;
    }
}
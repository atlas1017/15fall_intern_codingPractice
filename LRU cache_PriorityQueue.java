public class LRUCache {

	public class Node 
	{
		int key;
		int value;
		int timeStamp;

		public Node(int k, int v, int t)
		{
			key = k;
			value = v;
			timeStamp = t;
		}
	}


	int limit;
	int time;
	PriorityQueue<Node> q;
	HashMap<Integer, Node> m;


	public LRUCache(int capacity)
	{
		time = 0;
		limit = capacity;
		q = new PriorityQueue<Node>(capacity, new Comparator<Node>()
		{
			public int compare(Node a, Node b)
			{
				if(a.timeStamp < b.timeStamp)
					return -1;
				else if(a.timeStamp == b.timeStamp)
					return 0;
				else
					return 1;
			}
		});
		m = new HashMap<Integer, Node>();
	}


	public int get(int key)
	{
		time++;
		if(m.containsKey(key))
		{
			Node temp = m.get(key);
			temp.timeStamp = time;
			// update the queue
			q.remove(temp);
			q.add(temp);
			return temp.value;
		}
		else
			return -1;
	}

	public void set(int key, int value)
	{
		time++;
		if(m.containsKey(key))
		{
			Node temp = m.get(key);
			temp.value = value;
			temp.timeStamp = time;
			q.remove(temp);
			q.add(temp);
		}
		else
		{
			if(m.size() == limit)
			{
				Node temp = q.poll();
				m.remove(temp.key);
				Node one = new Node(key, value, time);
				m.put(key, one);
				q.add(one);
			}
			else
			{
				Node one = new Node(key, value, time);
				m.put(key, one);
				q.add(one);
			}
		}
		return;
	}
}
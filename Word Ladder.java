public class Solution {
    public int ladderLength(String beginWord, String endWord, Set<String> wordDict) {
        // BFS
        HashSet<String> cur = new HashSet<String>();
        HashSet<String> next = null;
        cur.add(beginWord);
        int count = 0;
        while(!cur.isEmpty() && !cur.contains(endWord)) {
            count++;
            next = new HashSet<String>();
            for(String oneCur : cur) {
                List<String> neighbors = getNeighbors(oneCur);
                for(String oneNeighbor : neighbors) {
                    if(wordDict.contains(oneNeighbor)) {
                        next.add(oneNeighbor);
                        wordDict.remove(oneNeighbor);
                    }
                }
            }
            cur = next;
        }
        if(cur.isEmpty())
            return 0;
        return count + 1;
    }
    
    public List<String> getNeighbors(String s) {
        char[] arr = s.toCharArray();
        List<String> res = new ArrayList<String>();
        for(int i = 0; i < arr.length; i++) {
            char temp = arr[i];
            for(int j = 0; j < 26; j++) {
                if(j + 'a' != temp) {
                    arr[i] = (char)(j + 'a');
                    String one = new String(arr);
                    res.add(one);
                    arr[i] = temp;
                }
            }
        }
        return res;
    }
}
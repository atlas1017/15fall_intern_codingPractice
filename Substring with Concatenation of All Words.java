public class Solution {
    public List<Integer> findSubstring(String s, String[] words) {
        List<Integer> res = new ArrayList<Integer>();
        int len = words[0].length();
        if(s == null || s.length() < len * words.length)
            return res;

        HashMap<String, Integer> target = new HashMap<String, Integer>();
        for(int i = 0; i < words.length; i++) {
            if(!target.containsKey(words[i]))
                target.put(words[i], 1);
            else
                target.put(words[i], target.get(words[i]) + 1);
        }
        
        for(int i = 0; i <= s.length() - words.length*len; i++) {
            HashMap<String, Integer> map = new HashMap<String, Integer>(target);
            if(check(map, s, i, len))
                res.add(i);
        }
        return res;
    }
    
    public boolean check(HashMap<String, Integer> map, String s, int start, int len)
    {
        int pos = start;
        while(pos <= s.length() - len && !map.isEmpty()) {
            String one = s.substring(pos, pos + len);
            if(!map.containsKey(one))
                return false;
            else
                map.put(one, map.get(one) - 1);
            if(map.get(one) == 0)
                map.remove(one);
            pos += len;
        }
        return true;
    }
}
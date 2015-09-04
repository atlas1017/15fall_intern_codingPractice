public class Solution {
    public List<List<String>> findLadders(String start, String end, Set<String> dict) {
      Set<String> s1 = new HashSet<String>();
      Set<String> s2 = new HashSet<String>();
      Map<String, List<String>> map = new HashMap<String, List<String>>();
      s1.add(start);
      s2.add(end);
      help(s1, s2, map, dict, false);

      List<String> one = new ArrayList<String>();
      List<List<String>> res = new ArrayList<List<String>>();
      one.add(start);
      getList(start, end, one, res, map);
      return res;
    }

    public boolean help(Set<String> s1, Set<String> s2, Map<String, List<String>> map, Set<String> dict, boolean flip) {
      if(s1.isEmpty())
        return false;
      if(s1.size() > s2.size()) 
        return help(s2, s1, map, dict, !flip);
      dict.removeAll(s1);
      dict.removeAll(s2);
      boolean done = false;
      // set of next step
      HashSet<String> set = new HashSet<String>();
      for(String oneStr : s1) {
        char[] arr = oneStr.toCharArray();
        for(int i = 0; i < arr.length; i++) {
          for(char j = 'a'; j <= 'z'; j++) {
            if(j == arr[i])
              continue;
            char temp = arr[i];
            arr[i] = j;
            String tempStr = new String(arr);
            arr[i] = temp;

            String key = flip ? tempStr : oneStr;
            String val = flip ? oneStr : tempStr;

            List<String> list = map.containsKey(key) ? map.get(key) : new ArrayList<String> ();
            // tempStr is next String that is for testing
            if(s2.contains(tempStr)) {
              done = true;
              list.add(val);
              map.put(key, list);
            }
            if(!done && dict.contains(tempStr)){
              list.add(val);
              map.put(key, list);
              set.add(tempStr);
            }
          }
        }
      }
      // important : march one more step
      return (done || help(set, s2, map, dict, flip));
    }

    // map has guaranteed that we can only get shortest path from the map
    public void getList(String start, String end, List<String> one, List<List<String>> res, Map<String, List<String>> map) {
      if(start.equals(end)) {
        List<String> copy = new ArrayList<String> (one);
        res.add(copy);
        return;
      }
      if(!map.containsKey(start))
        return;
      for(String temp : map.get(start)) {
        one.add(temp);
        getList(temp, end, one, res, map);
        one.remove(one.size() - 1);
      }
      return;
    }
}
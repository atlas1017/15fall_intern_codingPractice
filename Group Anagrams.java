public class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String, List<String>> m = new HashMap<String, List<String>> ();
        for(String one : strs) {
            char[] oneArr = one.toCharArray();
            Arrays.sort(oneArr);
            String temp = new String(oneArr);
            if(m.containsKey(temp)) {
                // the requirement that all strings in a list should be in alphabetical order
                List<String> tempInsertList = m.get(temp);
                int index = 0;
                while(index < tempInsertList.size() && one.compareTo(tempInsertList.get(index)) > 0)
                    index++;
                tempInsertList.add(index, one);
            }
            else {
                List<String> tempList = new ArrayList<String>();
                tempList.add(one);
                m.put(temp, tempList);
            }
        }
        
        List<List<String>> res = new ArrayList<List<String>>();
        for(List<String> oneList : m.values()) 
            res.add(oneList);
        return res;
    }
}
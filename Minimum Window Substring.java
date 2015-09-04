public class Solution {
    public String minWindow(String s, String t) {
        if(s.length() == 0 || t.length() > s.length())
            return "";
        HashMap<Character, Integer> target = new HashMap<Character, Integer>();
        char[] tArr = t.toCharArray();
        for(char one : tArr) {
            if(!target.containsKey(one)) 
                target.put(one, 1);
            else
                target.put(one, target.get(one) + 1);
        }
        
        int len = s.length() + 1;
        String res = "";
        int pos = 0;
        int prev = 0;
        int count = 0;
        HashMap<Character, Integer> m = new HashMap<Character, Integer> ();
        while(pos < s.length()) {
            char oneChar = s.charAt(pos);
            if(target.containsKey(oneChar)) {
                if(!m.containsKey(oneChar)) {
                    count++;
                    m.put(oneChar, 1);
                }
                else {
                    m.put(oneChar, m.get(oneChar) + 1);
                    if(m.get(oneChar) <= target.get(oneChar))
                        count++;
                }
            }
            
            // move the prev to update len
            if(count == t.length()) {
                while(prev <= pos) {
                    char temp = s.charAt(prev);
                    if(!m.containsKey(temp))
                        prev++;
                    else if(m.get(temp) > target.get(temp)) {
                        prev++;
                        m.put(temp, m.get(temp) - 1);
                    }
                        
                    else {
                        if(pos - prev + 1 < len) {
                            len = pos - prev + 1;
                            res = s.substring(prev, pos + 1);
                        }
                        break;
                    }
                }
            }
            pos++;
        }
        return res;
    }
}
public class Solution {
    public String convert(String s, int numRows) {
        if(numRows == 1)
            return s;
        int period = 2* (numRows - 1);
        String res = "";
        
        // handle with the first line
        int pos = 0;
        while(pos < s.length()) {
            res += s.charAt(pos);
            pos += period;
        }
        
        // handle with the middle part
        for(int i = 1; i < numRows - 1; i++) {
            // handle with one line
            pos = i;
            if(pos < s.length()) {
                res += s.charAt(pos);
                pos += period;
                while(pos < s.length()) {
                    res += s.charAt(pos - 2*i);
                    res += s.charAt(pos);
                    pos += period;
                }
                
                if(pos - 2*i < s.length())
                    res += s.charAt(pos - 2*i);
            }
        }
        
        // handle with the last line
        pos = numRows - 1;
        while(pos < s.length()) {
            res += s.charAt(pos);
            pos += period;
        }
        
        return res;
    }
}
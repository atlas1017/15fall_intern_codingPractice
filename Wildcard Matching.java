public class Solution {
    public boolean isMatch(String s, String p) {
        int match = -1;
        int star = -1;
        
        int posS = 0;
        int posP = 0;
        while(posS < s.length()) {
            if((posP < p.length()) && (p.charAt(posP) == '?' || p.charAt(posP) == s.charAt(posS))) {
                posP++;
                posS++;
            }
            else if((posP < p.length()) && (p.charAt(posP) == '*')) {
                star = posP;
                match = posS;
                posP++;
            }
            else if(star != -1) {
                match++;
                posS = match;
                posP = star + 1;
            }
            else
                return false;
        }
        
        while(posP < p.length() && p.charAt(posP) == '*')
            posP++;
        return posP == p.length();
    }
}
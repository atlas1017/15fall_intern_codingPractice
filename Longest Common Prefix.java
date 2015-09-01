public class Solution {
    public String longestCommonPrefix(String[] strs) {
        if(strs == null || strs.length == 0)
            return "";
        int len = Integer.MAX_VALUE;
        for(String one : strs) 
            len = Math.min(one.length(), len);
        for(int i = 0; i < len; i++) {
            char temp = strs[0].charAt(i);
            for(String one : strs) {
                if(one.charAt(i) != temp)
                    return strs[0].substring(0, i);
            }
        }
        return strs[0].substring(0, len);
    }
}
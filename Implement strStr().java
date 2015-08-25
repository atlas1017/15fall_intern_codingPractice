public class Solution {
    public int strStr(String haystack, String needle) {
        if(needle.length() == 0)
            return 0;
        if(haystack == null || haystack.length() == 0)
            return -1;
        int len = needle.length();
        char first = needle.charAt(0);
        
        for(int i = 0; i < haystack.length(); i++)
        {
            if(haystack.charAt(i) != first)
                continue;
            int pos = i;
            int count = 1;
            while(count < len && pos + 1 < haystack.length() && haystack.charAt(pos + 1) == needle.charAt(count))
            {
                pos++;
                count++;
            }
            if(count == len)
                return i;
        }
        return -1;
    }
}
public class Solution {
    public int numDecodings(String s) {
        if(s == null || s.length() == 0)
            return 0;
        HashSet<Integer> done = new HashSet<Integer>(); // this will store the indexes of parts with 0
                                                        // means no more combination for this kind
        String parsedStr = parse(s, done);
        // handle with 0 because 0 can be only attached to former one
        if(parsedStr == null)
            return 0;
        int[] dp = new int[parsedStr.length() + 1];
        dp[0] = 1;
        dp[1] = 1; // here 0 means nothing and 1 means the first or tht one with index 0
        int pos = 1;
        while(pos < parsedStr.length())
        {
            if(done.contains(pos - 1) || done.contains(pos))
                dp[pos + 1] = dp[pos];
            else
            {
                if(isLetter(parsedStr.substring(pos - 1, pos + 1)))
                    dp[pos + 1] = dp[pos] + dp[pos - 1];
                else
                    dp[pos + 1] = dp[pos];
            }
            pos++;
        }
        return dp[pos];
    }
    
    public boolean isLetter(String s) {
        if(s.charAt(0) == '1')
            return true;
        if(s.charAt(0) == '2' && (s.charAt(1) >= '0' && s.charAt(1) <= '6'))
            return true;
        else
            return false;
    }
    
    public String parse(String s, HashSet<Integer> done) {
        char[] arr = s.toCharArray();
        int pos = 0;
        String res = "";
        while(pos < arr.length) {
            if(arr[pos] == '0') {
                if((pos > 0) && (arr[pos - 1] == '1' || arr[pos - 1] == '2') && (!done.contains(pos - 1)))
                    done.add(pos - 1);
                else
                    return null;
            }
            else
                res += arr[pos];
            pos++;
        }
        return res;
    }
}
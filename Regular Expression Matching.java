public class Solution {
    public boolean isMatch(String s, String p) {
        HashSet<Integer> stars = new HashSet<Integer>();
        p = parse(p, stars); // wipe out * and mark chars with * in stars
        
        int len1 = s.length();
        int len2 = p.length();
        
        boolean[][] dp = new boolean[len1 + 1][len2 + 1];
        dp[0][0] = true;
        int pos = 0;
        while(pos < len2 && stars.contains(pos))
            dp[0][1 + pos++] = true;
        for(int i = 1; i <= len1; i++) {
            for(int j = 1; j <= len2; j++) {
                if(dp[i][j])
                    continue;
                if(!stars.contains(j - 1)) {
                    if(dp[i][j - 1])
                        dp[i][j] = true;
                    else if((dp[i - 1][j - 1]) && ( p.charAt(j - 1) == '.'|| s.charAt(i - 1) == p.charAt(j - 1))) {
                        int pos0 = i - 1;
                        while(pos0 < len1 && ( p.charAt(j - 1) == '.'|| s.charAt(pos0) == p.charAt(j - 1))) {
                            dp[pos0 + 1][j] = true;
                            pos0++;
                        }
                    }
                }
                else
                    dp[i][j] = dp[i - 1][j - 1] && ( p.charAt(j - 1) == '.'|| s.charAt(i - 1) == p.charAt(j - 1));
            }
        }
        return dp[len1][len2];
    }
    
    public String parse(String s, HashSet<Integer> stars) {
        String res = "";
        int pos = 0;
        while(pos < s.length() - 1) {
            if(s.charAt(pos + 1) == '*') {
                res += s.charAt(pos);
                stars.add(res.length() - 1);
                pos++;
                while(pos < s.length() && s.charAt(pos) == '*')
                    pos++;
            }
            else {
                res += s.charAt(pos);
                pos++;
            }
        }
        
        if(pos < s.length())
            res += s.charAt(pos);
        System.out.println(res);
        return res;
    }
}
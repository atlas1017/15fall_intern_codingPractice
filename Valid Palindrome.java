public class Solution {
    public boolean isPalindrome(String s) {
        int m = 0;
        int n = s.length() - 1;
        while(m <= n) {
           char char_m = s.charAt(m);
           char char_n = s.charAt(n);
           
           int res_m = getLetter(char_m);
           if( res_m == -1) {
               m++;
               continue;
           }
           else if(res_m == 0) {
               char_m = (char)(char_m + 'a' - 'A');
           }
               
           int res_n = getLetter(char_n);
           if(res_n == -1) {
               n--;
               continue;
           }
           else if(res_n == 0) {
               char_n = (char)(char_n + 'a' - 'A');
           }
            
            if(char_m != char_n)
                return false;
            m++;
            n--;
        }
        return true;
    }
    
    public int getLetter(char temp) {
        if(temp >= 'A' && temp <= 'Z')
            return 0;
        else if( (temp >= 'a' && temp <= 'z') || (temp >= '0' && temp <= '9'))
            return 1;
        else
            return -1;
    }
}
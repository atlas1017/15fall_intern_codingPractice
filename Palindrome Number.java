public class Solution {
    public boolean isPalindrome(int x) {
        if(x < 0)
            return false;
        long reverse = getReverse(x);
        return (reverse == (long)x);
    }
    
    public long getReverse(int num)
    {
        int res = 0;
        while(num != 0) {
            int temp = num % 10;
            res = res * 10 + temp;
            num = num / 10;
        }
        return res;
    }
}
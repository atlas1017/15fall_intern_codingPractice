public class Solution {
    public int reverse(int x) {
    boolean neg = false;
    long y = 0;
    if(x < 0)
        y = -reverseHelp(-x);
    else
        y = reverseHelp(x);
    if(y > Integer.MAX_VALUE || y < Integer.MIN_VALUE)
        return 0;
    return (int)y;
    }
    
    public long reverseHelp(int x) {
        long res = 0;
        while(x != 0) {
            res = 10 * res + (x % 10);
            x = x / 10;
        }
        return res;
    }
}
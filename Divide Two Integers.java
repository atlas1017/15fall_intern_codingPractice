public class Solution {
    public int divide(int dividend, int divisor) {
        long ret = 0;
        boolean neg = false;
        if((dividend < 0 && divisor > 0) || (dividend > 0 && divisor < 0))
            neg = true;
        long divid = dividend < 0 ? 0 - (long)dividend : dividend;
        long divis = divisor < 0 ? 0 - (long)divisor : divisor;
        System.out.println(divid);
        System.out.println(divis);
        long sub = divis;
        long c = 1;
        while(divid >= divis) {
            if(divid >= sub) {
                ret += c;
                divid -= sub;
                sub = sub << 1;
                c = c << 1;
            }
            else {
                c = c >> 1;
                sub = sub >> 1;
            }
        }
        ret = neg ? -ret : ret;
        System.out.println(ret);
        ret = ret > (long)Integer.MAX_VALUE ? (long)Integer.MAX_VALUE : ret;
        ret = ret < (long)Integer.MIN_VALUE ? (long)Integer.MIN_VALUE : ret;
        System.out.println(ret);
        return (int)ret;
    }
}
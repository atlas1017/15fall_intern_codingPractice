public class Solution {
    public int divide(int dividend, int divisor) {
    // found the answer from internet
    if(divisor==0) return Integer.MAX_VALUE;
    else if(dividend==Integer.MIN_VALUE){ //deal with min int for dividend and divisor
        if(divisor==-1) return Integer.MAX_VALUE;
        else if(divisor==1)  return dividend;
        else return ((divisor&1)==1)?divide(dividend+1,divisor):divide(dividend>>1,divisor>>1);
    } 
    else if(divisor==Integer.MIN_VALUE) return 0; 
    else if(dividend<0&&divisor<0) return divide(-dividend,-divisor);
    else if(dividend<0||divisor<0) return -divide(-dividend,divisor);
    int res = 0;
    while(dividend>=divisor){ //positive division method
        int tmp = divisor, tmpres = 1;
        while(dividend>=tmp<<1&&((tmp<<1))>divisor){ //avoid tmp integer overflow
            tmp <<= 1;
            tmpres <<= 1;
        }
        res += tmpres;
        dividend -= tmp;
    }
    return res;
}
}
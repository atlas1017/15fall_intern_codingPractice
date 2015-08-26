public class Solution {
    public int myAtoi(String str) {
        if(str == null || str.length() == 0)
            return 0;
        int len = str.length();
        boolean neg = false;
        char[] arr = str.toCharArray();
        int pos = 0;
        long res = 0;
        while(pos < len && arr[pos] == ' ')
            pos++;
        if(pos < len && arr[pos] == '+')
            pos++;
        else if(pos < len && arr[pos] == '-') {
            neg = true;
            pos++;
        }
        System.out.println(pos);
        int count = 0;
        while(pos < len && count < 12) {
            count++;
            int temp = arr[pos] - '0';
            if(temp >= 0 && temp <= 9) {
                res = res * 10 + temp;
                pos++;
            }
            else
                return parse(neg ? 0 - res : res);
        }
        return parse(neg ? 0 - res : res);
    }
    public int parse(long res) {
        if(res > (long)Integer.MAX_VALUE)
            return Integer.MAX_VALUE;
        if(res < (long)Integer.MIN_VALUE)
            return Integer.MIN_VALUE;
        return (int)res;
    }
}
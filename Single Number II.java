public class Solution {
    public int singleNumber(int[] nums) {
       int res = 0;
       int unit = 1;
       for(int i = 0; i < 32; i++) {
           int count = 0;
           for(int one : nums) {
               if((one&unit) != 0)
                count++;
           }
           count = count % 3;
           res = res + count * unit;
           unit = unit << 1;
       }
       return (int)res;
    }
}
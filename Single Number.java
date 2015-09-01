public class Solution {
    public int singleNumber(int[] nums) {
        int res = 0;
        for(int one : nums)
            res = res ^ one;
        return res;
    }
}
public class Solution {
    public int[] plusOne(int[] digits) {
        if(allNine(digits)) {
            int[] res = new int[digits.length + 1];
            res[0] = 1;
            return res;
        }
        
        int pos = digits.length - 1;
        while(true) {
            if(digits[pos] < 9) {
                digits[pos] += 1;
                break;
            }
            else
                digits[pos--] = 0;
        }
        return digits;
    }
    
    public boolean allNine(int[] nums) {
        for(int one : nums) {
            if(one != 9)
                return false;
        }
        return true;
    }
}
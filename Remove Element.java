public class Solution {
    public int removeElement(int[] nums, int val) {
        int p1 = 0;
        int p2 = 0;
        int count = 0;
        while(p1 < nums.length) {
            if(nums[p1] == val)
                p1++;
            else {
                nums[p2++] = nums[p1++];
                count++;
            }
        }
        return count;
    }
}
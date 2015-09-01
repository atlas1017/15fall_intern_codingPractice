public class Solution {
    public void sortColors(int[] nums) {
        int c1 = 0;
        int c2 = 0;
        int c3 = 0;
        for(int i : nums) {
            if(i == 0)
                c1++;
            else if(i == 1)
                c2++;
            else if(i == 2)
                c3++;
        }
        int cur = 0;
        while(c1-- > 0)
            nums[cur++] = 0;
        while(c2-- > 0)
            nums[cur++] = 1;
        while(c3-- > 0)
            nums[cur++] = 2;
        return;
    }
}
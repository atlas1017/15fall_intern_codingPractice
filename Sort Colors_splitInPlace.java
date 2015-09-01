public class Solution {
    public void sortColors(int[] nums) {
        // classify in place
        if(nums == null || nums.length < 2)
            return;
        int p = 0;
        int q = nums.length - 1;
        
        // split by 1
        while(p < q) {
            while(p <= q && nums[p] == 0)
                p++;
            while(p <= q && nums[q] > 0)
                q--;
            if(q < p)
                break;
            swap(p++, q--, nums);
        }
        
        q = nums.length - 1;
        // leave alone the first 0 and split the left part by 1
        while(p < q) {
            while(p <= q && nums[p] < 2)
                p++;
            while(p <= q && nums[q] > 1)
                q--;
            if(p > q)
                break;
            swap(p++, q--, nums);
        }
        return;
    }
    
    public void swap(int a, int b, int[] nums) {
        int temp = nums[a];
        nums[a] = nums[b];
        nums[b] = temp;
        return;
    }
}
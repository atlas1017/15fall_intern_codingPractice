public class Solution {
   public static int maxArea(int[] height) {
        int p = 0;
        int q = height.length - 1;
        int max = 0;
        while(p < q)
        {
            int temp = Math.min(height[p], height[q]) * (q - p);
            max = temp > max ? temp : max;
            if(height[p] < height[q])
                p++;
            else
                q--;
        }
        return max;
    }
}
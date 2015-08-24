public class Solution {
    // 对于这道题目 我们需要找trapping water 
    // 考察每个trapping的interval --> 一直左边一个interval end 之后
    // 我们其实不在乎中间的高度变化 -- 我们只需要在乎是不是出现了比这个边界
    // 还要高的点
    
    // 需要从两边收集 因为考虑极端情况 最高点有可能时最左边的一个 
    public int trap(int[] height) {
        if(height.length < 3)
            return 0;
        int maxIndex = findMax(height);
        int res = 0;
        
        int p1 = 0;
        int p2 = 0;
        while(p2 < maxIndex)
        {
            while(p2 < maxIndex && (p1 == p2 || height[p2] <= height[p1]))
                p2++;
            res += collect(height, p1, p2);
            p1 = p2;
        }
        
        int p3 = height.length - 1;
        int p4 = height.length - 1;
        while(p4 > maxIndex)
        {
            while(p4 > maxIndex && (p3 == p4 || height[p4] <= height[p3]))
                p4--;
            res += collect(height, p4, p3);
            p3 = p4;
        }
        
        return res;
    }
    
    public int findMax(int[] height)
    {
        int pos = 0;
        int max = height[0];
        for(int i = 0; i < height.length; i++)
        {
            if(height[i] > max)
            {
                max = height[i];
                pos = i;
            }
        }
        return pos;
    }
    
    public int collect(int[] height, int p1, int p2)
    {
        int res = 0;
        int h = Math.min(height[p1], height[p2]);
        for(int i = p1 + 1; i < p2; i++)
            res += h - height[i];
        return res;
    }
}
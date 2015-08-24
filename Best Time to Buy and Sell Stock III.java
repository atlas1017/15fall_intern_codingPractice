public class Solution {
    public int maxProfit(int[] prices) 
    {
        int max = 0;
        
        int p1 = 0;
        while(p1 + 1 < prices.length && prices[p1] >= prices[p1 + 1])
            p1++;
        int p2 = prices.length - 1;
        while(p2 > 0 && prices[p2 - 1] >= prices[p2])
            p2--;
        
        // the reason that I made these 2 end points is that I want to cover the situations where there are only
        // 2 or 3 prices in total
        for(int i = p1 - 1; i < p2 + 1; i++)
        {
            int tempMax = findMax(prices, p1, i) + findMax(prices, i + 1, p2);
            max = tempMax > max ? tempMax : max;
        }
        return max;
    }
    
    public int findMax(int[] prices, int start, int end)
    {
        if(start >= end)
            return 0;
        int pos = start;
        int min = prices[start];
        int max = 0;
        while(pos <= end)
        {
            int temp = prices[pos];
            if(temp < min)
                min = temp;
            else
                max = temp - min > max ? temp - min : max;
            pos++;
        }
        return max;
    }
}
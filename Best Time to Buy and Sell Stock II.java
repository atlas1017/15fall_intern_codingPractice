public class Solution {
    public int maxProfit(int[] prices) 
    {
        int max = 0;
        for(int i = 0; i < prices.length - 1; i++)
        {
            int temp = prices[i + 1] - prices[i];
            max += temp > 0 ? temp : 0;
        }
        return max;
    }
}
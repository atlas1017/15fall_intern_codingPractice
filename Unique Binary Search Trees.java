public class Solution {
    public int numTrees(int n) {
        int[] res = new int[n + 1];
        res[0] = 1;
        res[1] = 1;
        
        for(int i = 2; i < n + 1; i++)
        {
            for(int j = 1; j <= i; j++)
            {
                int left = j - 1;
                int right = i - j;
                res[i] += res[left] * res[right];
            }
        }
        return res[n];
    }
}
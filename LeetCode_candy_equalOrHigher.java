public class Solution {
    public int candy(int[] ratings) {
        if(ratings.length == 0)
            return 0;
        if(ratings.length < 2)
            return 1;
            
        int[] bottom = new int[2];
        if(!findNextBottom(ratings, 0, bottom))
        {
            doUpHalf(ratings, 0, ratings.length - 1);
        }
        else
        {
            int prev = bottom[0];
            int cur = bottom[1];
            
            for(int i = prev; i <= cur; i++)
                ratings[i] = 1;
            doDownHalf(ratings, 0, prev);
            
            while(cur + 1 < ratings.length && findNextBottom(ratings, cur + 1, bottom))
            {
                for(int m = bottom[0]; m <= bottom[1]; m++)
                    ratings[m] = 1;
                doWhole(ratings, cur, bottom[0]);
                prev = bottom[0];
                cur = bottom[1];
            }
            
            if(cur + 1 < ratings.length)
                doUpHalf(ratings, cur, ratings.length - 1);
        }
        
        int res = 0;
        for(int one : ratings)
            res += one;
        return res;
    }
    
    public boolean findNextBottom(int[] ratings, int start, int[] res)
    {
        if(start >= ratings.length)
            return false;
        int pos = start;
        while(pos < ratings.length)
        {
            int cur = pos;
            while(cur < ratings.length && ratings[cur] == ratings[pos])
                cur++;
            // cur will be the first different or ratings.length
            if((pos == 0 || ratings[pos - 1] > ratings[pos]) && (cur == ratings.length || ratings[cur - 1] < ratings[cur]))
            {
                res[0] = pos;
                res[1] = cur - 1;
                return true;
            }
            else
                pos = cur;
        }
        return false;
    }
    
    public void doUpHalf(int[] ratings, int start, int end)
    {
        if(start == end)
            return;
        int pos = start + 1;
        int count = 2;
        while(pos <= end)
        {
            int cur = pos;
            while(cur <= end && ratings[cur] == ratings[pos])
                cur++;
            for(int i = pos; i < cur; i++)
                ratings[i] = count;
            count++;
            pos = cur;
        }
        return;
    }
    
    public void doDownHalf(int[] ratings, int start, int end)
    {
        if(start == end)
            return;
        int pos = end - 1;
        int count = 2;
        while(pos >= start)
        {
            int cur = pos;
            while(cur >= start && ratings[cur] == ratings[pos])
                cur--;
            for(int i = cur + 1; i <= pos; i++)
                ratings[i] = count;
            count++;
            pos = cur;
        }
        return;
    }
    
    public void doWhole(int[] ratings, int start, int end)
    {
        if(start == end)
            return;
        int max = start;
        for(int i = start; i <= end; i++)
        {
            if(ratings[i] > ratings[max])
                max = i;
        }
        int maxCur = max;
        while(maxCur <= end && ratings[max] == ratings[maxCur])
            maxCur++;
        doUpHalf(ratings, start, max);
        int temp = ratings[max];
        doDownHalf(ratings, maxCur, end);
        
        if(temp < ratings[maxCur])
            temp = ratings[maxCur];
        for(int m = max; m <= maxCur; m++)
            ratings[m] = temp;
        return;
    }
}
public class Solution {
    public int candy(int[] ratings) {
        if(ratings.length == 0)
            return 0;
        if(ratings.length < 2)
            return 1;
            
        int[] candy = new int[ratings.length];
        candy[0] = 1;
        int pos = 1;
        while(pos < ratings.length)
        {
            if(ratings[pos - 1] > ratings[pos])
                candy[pos] = candy[pos - 1] - 1;
            else if(ratings[pos - 1] == ratings[pos])
                candy[pos] = 1;
            else
                candy[pos] = candy[pos - 1] + 1;

            if(pos < ratings.length - 1 && ratings[pos - 1] > ratings[pos] && ratings[pos] <= ratings[pos + 1])
                readjust(ratings, candy, pos);
            pos++;
        }
        
        int len = ratings.length;
        if(ratings[len - 1] < ratings[len - 2])
            readjust(ratings, candy, len - 1);
        
        int res = 0;
        for(int one : candy)
        {
            res += one;
            //System.out.println(one);
        }
        return res;
    }
    
    public void readjust(int[] ratings, int[] candy, int end)
    {
        int offset = 1 - candy[end];
        int start = end;
        while(start > 0 && ratings[start - 1] > ratings[start])
            start--;
        for(int i = start + 1; i <= end; i++)
            candy[i] += offset;
        if(offset > 0)
            candy[start] += offset;
        return;
    }
}
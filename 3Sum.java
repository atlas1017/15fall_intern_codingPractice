import java.util.List;

public class Solution {
    public List<List<Integer>> threeSum(int[] num) {
        Arrays.sort(num);
        List<List<Integer>> res = new ArrayList<List<Integer>> ();
        for(int i = 0; i < num.length - 2; i++)
        {
            if(num[i] > 0)
                break;
            int s = i+1;
            int t = num.length - 1;
            while(s < t)
            {
                int tempSum = num[i] + num[s] + num[t];
                if(tempSum == 0)
                {
                    List<Integer> one = new ArrayList<Integer>();
                    one.add(num[i]);
                    one.add(num[s]);
                    one.add(num[t]);
                    res.add(one);

                    do{s++;} while(s < t && num[s-1] == num[s]);
                    do{t--;} while(s < t && num[t+1] == num[t]);
                }
                else if(tempSum > 0)
                    t--;
                else
                    s++;
            }
            while(i < num.length - 2 && num[i+1] == num[i])
                i++;
        }
        return res;
    }
}
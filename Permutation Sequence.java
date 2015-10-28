public class Solution {
    public String getPermutation(int n, int k) {
        long total = 1;
        for(int i = 1; i <=n; i++)
            total *= i;
        String s = ""; 
        k = k - 1;
        List<Integer> nums = new ArrayList<Integer>();
        for(int i = 1; i <= 9; i++)
            nums.add(i);
        for(int i = n; i > 0; i--) {
            total = total / i;
            int temp = (int)(k / total);
            k = (int)(k % total);
            s += nums.get(temp);
            nums.remove(temp);
        }
        return s;
    }
}
                int tempSum = nums[i] + nums[s] + nums[t];
                if(tempSum == target)
                    return target; // no need to update
                else if(tempSum < target) {
                    if(target - tempSum < Math.abs(close - target))
                        close = tempSum;
                    do{s++;} while(s < t && nums[s] == nums[s - 1]);
                }
                else {
                    if(tempSum - target < Math.abs(close - target))
                        close = tempSum;
                    do{t--;} while(s < t && nums[t] == nums[t + 1]);
                }
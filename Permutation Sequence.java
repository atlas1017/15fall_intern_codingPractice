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
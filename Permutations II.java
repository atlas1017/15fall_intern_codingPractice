public class Solution {
    public List<List<Integer>> permuteUnique(int[] nums) {
        Arrays.sort(nums);
        List<Integer> numbers = new ArrayList<Integer>();
        for(int one : nums) 
            numbers.add(one);
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        List<Integer> one = new ArrayList<Integer>();
        helpAdding(numbers, res, one);
        return res;
    }
    
    public void helpAdding(List<Integer> numbers, List<List<Integer>> res, List<Integer> one) {
        if(numbers.isEmpty()) {
            List<Integer> copy = new ArrayList<Integer> (one);
            res.add(copy);
            return;
        }
        for(int i = 0; i < numbers.size(); i++) {
            if(i > 0 && numbers.get(i) == numbers.get(i - 1))
                continue;
            Integer temp = numbers.get(i);
            one.add(temp);
            numbers.remove(temp);
            helpAdding(numbers, res, one);
            one.remove(one.size() - 1);
            numbers.add(i, temp);
        }
        return;
    }
}
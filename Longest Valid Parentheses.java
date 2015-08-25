public class Solution {
    public int longestValidParentheses(String s) {
        char[] arr = s.toCharArray();
        
        int max = 0;
        List<Integer> stack = new ArrayList<Integer>();
        for(int i = 0; i < arr.length; i++) {
            if(arr[i] == '(' || stack.isEmpty())
                stack.add(i);
            else {
                int last = stack.get(stack.size() - 1);
                if(arr[last] == '(') {
                    stack.remove(stack.size() - 1);
                    if(stack.isEmpty())
                        max = i + 1;
                    else {
                        int temp = i - stack.get(stack.size() - 1);
                        max = Math.max(max, temp);
                    }
                }
                else
                    stack.add(i);
            }
        }
        return max;
    }
}
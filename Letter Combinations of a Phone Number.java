public class Solution {
    public List<String> letterCombinations(String digits) {
        List<String> res = new ArrayList<String> ();
        if(digits.length() == 0)
            return res;
        int[] nums = new int[digits.length()];
        
        // this array is for the digits
        for(int i = 0; i < digits.length(); i++)
            nums[i] = digits.charAt(i) - '0';
            
          
        // this 2D array is for mapping
        int[][] mapping = new int[8][2];
        mapping[0][0] = 'a';
        mapping[1][0] = 'd';
        mapping[2][0] = 'g';
        mapping[3][0] = 'j';
        mapping[4][0] = 'm';
        mapping[5][0] = 'p';
        mapping[6][0] = 't';
        mapping[7][0] = 'w';
        
        for(int i = 0; i < 8; i++)
            mapping[i][1] = 3;
        mapping[5][1] = 4;
        mapping[7][1] = 4;
        
        
        helpAdding(res, "", nums, digits.length(), mapping);
        return res;
    }
    
    public void helpAdding(List<String> res, String s, int[] nums, int len, int[][]mapping) {
        System.out.println("the len is "+len);
        System.out.println(s);
        if(s.length() == len) {
            String copy = new String(s);
            res.add(copy);
        }
        else {
            int offset = nums[s.length()] - 2;
            int start = mapping[offset][0];
            int numOfChar = mapping[offset][1];
            for(int i = 0; i < numOfChar; i++) {
                s = s + (char)(start + i);
                helpAdding(res, s, nums, len, mapping);
                s = s.substring(0, s.length() - 1);
            }
        }
        return;
    }
}
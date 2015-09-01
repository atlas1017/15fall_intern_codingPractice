public class Solution {
    public boolean isScramble(String s1, String s2) {
        if(s1.length() != s2.length())
            return false;
        if(s1.equals(s2))   
            return true;
        char[] arr1 = s1.toCharArray();
        char[] arr2 = s2.toCharArray();
        int[] count = new int[128];
        
        for(char one : arr1)
            count[one]++;
        for(char one : arr2) {
            count[one]--;
            if(count[one] < 0)
                return false;
        }
        
        for(int i = 1; i < arr1.length; i++) {
            if(isScramble(s1.substring(0, i), s2.substring(0, i)) 
                && isScramble(s1.substring(i), s2.substring(i)))
                return true;
            if(isScramble(s1.substring(0, i), s2.substring(arr1.length - i)) 
            && isScramble(s1.substring(i), s2.substring(0, arr1.length - i)))
                return true;
        }
        return false;
    }
}
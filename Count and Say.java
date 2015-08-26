public class Solution {
    public String countAndSay(int n) {
        String s = "1";
        for(int i = 0; i < n - 1; i++)
            s = getNext(s);
        return s;
    }
    
    public String getNext(String str) {
        int pos = 0;
        char[] arr = str.toCharArray();
        String s = "";
        
        while(pos < arr.length) {
            char temp = arr[pos];
            int count = 0;
            while(pos < arr.length && arr[pos] == temp) {
                pos++;
                count++;
            }
            s += count;
            s += temp;
        }
        return s;
    }
}
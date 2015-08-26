public class Solution {
    public String intToRoman(int num) {
        String[] str = {"M","CM","D","CD","C","XC","L","XL","X","IX","V","IV","I"};
        int[] roman = {1000,900,500,400,100,90,50,40,10,9,5,4,1};
        
        String res = help(num, str, roman);
        return res;
    }
    
    public String help(int num, String[] str, int[] roman){
        int cur = 0;
        String res = "";
        int len = roman.length;
        while(cur < len) {
            if(num >= roman[cur]) {
                num -= roman[cur];
                res += str[cur];
            }
            else
                cur++;
        }
        return res;
    }
}
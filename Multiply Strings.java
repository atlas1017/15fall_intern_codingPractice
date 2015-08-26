public class Solution {
    // first problem : the "0" problem -- wipe out all 0s before nonzero nums and also if "" then "0"
    // second : the order of the number: conctanate from left side or the right side; 
    //          pick number from left side or the right side; 
    public String multiply(String num1, String num2) {
        char[] arr = num1.toCharArray();
        String res = "0";
        String one = "0";
        for(int i = 0; i < arr.length; i++) {
            one = multiHelper(arr[i], num2);
            if(!res.equals("0"))
                res += '0';
            res = add(res, one);
        }
        int pos = 0;
        while(pos < res.length() && res.charAt(pos) == '0')
            pos++;
        return res.substring(pos, res.length()).equals("") ? "0" : res.substring(pos, res.length());
    }
    
    public String multiHelper(char one, String num) {
        List<Integer> res = new ArrayList<Integer>();
        int addOn = 0;
        for(int i = num.length() - 1; i >= 0; i--) {
            int temp = (one - '0') * (num.charAt(i) - '0') + addOn;
            res.add(temp % 10);
            addOn = temp / 10;
        }
        if(addOn > 0)
            res.add(addOn);
        int len = res.size();
        String str = "";
        for(int i = 0; i < len; i++)
            str += res.get(len - i - 1);
        return str;
    }
    
    public String add(String s1, String s2) {
        if(s1 == null || s1.length() == 0)
            return s2;
        if(s2 == null || s2.length() == 0)
            return s1;
        int p1 = s1.length() - 1;
        int p2 = s2.length() - 1;
        String res = "";
        int addOn =0;
        while(p1 >= 0 && p2 >= 0) {
            int temp = addOn + (s1.charAt(p1--) - '0') + (s2.charAt(p2--) - '0');
            res = (temp % 10) + res;
            addOn = temp / 10;
        }
        while(p1 >= 0) {
            int temp = addOn + (s1.charAt(p1--) - '0');
            res = (temp % 10) + res;
            addOn = temp / 10;
        }
        while(p2 >= 0) {
            int temp = addOn + (s2.charAt(p2--) - '0');
            res = (temp % 10) + res;
            addOn = temp / 10;
        } 
        if(addOn > 0)
            res = addOn + res;
        return res;
    }
}
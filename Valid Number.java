public class Solution {
    // picky but not tricky
    public boolean isNumber(String s) {
        String one = parse(s);
        if(one == null || one.equals(""))
            return false;
        int posE = -1;
        int pos = 0;
        while(pos < one.length()) {
            if(one.charAt(pos) == 'e' || one.charAt(pos) == 'E') {
                posE = pos;
                break;
            }
            pos++;
        }
        if(posE > 0) {
            String base = one.substring(0, pos);
            String expo = one.substring(pos + 1, one.length());
            return isBase(base) && isExpo(expo);
        }
        else 
            return isBase(one);
    }
    
    public String parse(String s) {
        if(s == null || s.length() == 0)
            return s;
        int p = 0;
        int q = s.length() - 1;
        while(p <= q && s.charAt(p) == ' ')
            p++;
        while(q >= p && s.charAt(q) == ' ')
            q--;
        if(p > q)
            return null;
        return s.substring(p, q + 1);
    }
    
    public boolean isBase(String base) {
        if(base == null || base.length() == 0)
            return false;
        int posDot = -1;
        int pos = 0;
        
        while(pos < base.length()) {
            if(base.charAt(pos) == '.') {
                posDot = pos;
                break;
            }
            pos++;
        }
        if(posDot != -1) {
            if(posDot == 0 && posDot == base.length() - 1)
                return false;
            String one = base.substring(0, posDot);
            String two = base.substring(posDot + 1, base.length());
            if(base.charAt(0) == '-' || base.charAt(0) == '+') {
                one = base.substring(1, posDot);
                if(one.length() == 0 && two.length() == 0)
                    return false;
            }
            return containAllNum(one) && containAllNum(two);
        }
        else {
            if(base.charAt(0) == '-' || base.charAt(0) == '+') {
                base = base.substring(1, base.length());
                if(base.length() == 0)
                    return false;
            }
            return containAllNum(base);
        }
    }
    
    public boolean isExpo(String s) {
        if(s == null || s.length() == 0)
            return false;
        String str = null;
        if(s.charAt(0) == '+' || s.charAt(0) == '-') {
            str = s.substring(1, s.length());
            if(str.length() == 0)
                return false;
            return containAllNum(str);
        }
        else
            return containAllNum(s);
    }
    
    public boolean containAllNum(String s) {
        if(s == null || s.length() == 0)
            return true;
        char[] arr = s.toCharArray();
        for(char one : arr) {
            if(one < '0' || one > '9')
                return false;
        }
        return true;
    }
}
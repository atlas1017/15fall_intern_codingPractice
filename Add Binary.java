public class Solution {
    public String addBinary(String a, String b) {
        char[] a1 = a.toCharArray();
        char[] b1 = b.toCharArray();
        
        int pos1 = a1.length - 1;
        int pos2 = b1.length - 1;
        int addOn = 0;
        
        ArrayList<Integer> res = new ArrayList<Integer>();
        while(pos1 >= 0 && pos2 >= 0){
            int temp = a1[pos1] - '0' + b1[pos2] - '0' + addOn;
            res.add(temp % 2);
            addOn = temp / 2;
            
            pos1--;
            pos2--;
        }
        
        while(pos1 >= 0){
            int temp = a1[pos1] - '0' + addOn;
            res.add(temp % 2);
            addOn = temp / 2;
            pos1--;
        }
        
        while(pos2 >= 0){
            int temp = b1[pos2] - '0' + addOn;
            res.add(temp % 2);
            addOn = temp / 2;
            pos2--;
        }
        
        if(addOn == 1)
            res.add(1);
        
        return transform(res);
    }
    
    public String transform(ArrayList<Integer> l) {
        String res = "";
        for(int i = 0; i < l.size(); i++)
            res += l.get(l.size() - 1 - i);
        return res;
    }
}
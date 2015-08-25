public class Solution {
    public List<String> generateParenthesis(int n) {
        List<List<String>> lists = new ArrayList<List<String>> ();
        List<String> first = new ArrayList<String>();    
        if(n == 0)
            return first;
        first.add("()");
        if(n == 1)
            return first;
        lists.add(first);
        
        int m = 1;
        while(m < n)
        {
            List<String> cur = new ArrayList<String>();
            // split (m + 1)
            for(int i = 0; i <= m - 1; i++) // lists[0] is for 1 and lists[m - 1] is for m
            {
                for(String left : lists.get(i))
                {
                    for(String right : lists.get(m - 1 - i))
                    {
                        String s = left + right;
                        if(!cur.contains(s))
                            cur.add(s);
                    }
                }
                for(String one : lists.get(m - 1))
                {
                    String s = '(' + one + ')';
                    if(!cur.contains(s))
                        cur.add(s);
                }
            }
            lists.add(cur);
            m++;
        }
        return lists.get(n - 1);
    }
}
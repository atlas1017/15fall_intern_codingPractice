public class Solution {
    public List<Integer> getRow(int rowIndex) {
        List<Integer> prev = new ArrayList<Integer>();
        prev.add(1);
        if(rowIndex == 0)
            return prev;
        prev.add(1);
        if(rowIndex == 1)
            return prev;
        
        for(int i = 2; i <= rowIndex; i++)
        {
            List<Integer> cur = new ArrayList<Integer> ();
            cur.add(1);
            for(int j = 1; j < prev.size(); j++)
            {
                cur.add(prev.get(j - 1) + prev.get(j));
            }
            cur.add(1);
            prev.clear();
            prev = cur;
        }
        return prev;
    }
}
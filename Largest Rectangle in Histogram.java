public class Solution {
    public int largestRectangleArea(int[] height) {
        // idea : kind of similar to ideas of trapping water
        // for a height rectangle, we do not care about
        // how tall the middle heights will be when one end 
        // is fixed, instead we will only collect when we find 
        // one that is fmaller than the end
        
        // note : because the stack only store indexes so we 
        // have to keep in mind that each time we have to 
        // translate this into h[index] before we want to use
        // the height
        if(height == null || height.length == 0)
            return 0;
        if(height.length == 1)
            return height[0];
        
        int[] h = new int[height.length + 1];
        for(int i = 0; i < height.length; i++)
            h[i] = height[i];
        h[height.length] = 0;
        
        int res = 0;
        // this will store the index of nodes
        ArrayList<Integer> stack = new ArrayList<Integer>();
        for(int i = 0; i < h.length; i++)
        {
            if(stack.isEmpty() || h[i] > h[stack.get(stack.size() - 1)])
                stack.add(i);
            else
            {
                // in the else part, actually a relatively lower height
                // will collect all bars that higher or equal to this
                // implement this by decrementing by 1
                // and also after all this, the bar itself will be added
                int index = stack.remove(stack.size() - 1);
                int tempH = h[index];
                int tempW = stack.isEmpty() ? i : i - stack.get(stack.size() - 1) - 1;
                res = Math.max(res, tempH * tempW);
                i--;
            }
        }
        return res;
    }
}
public class Solution {
	public double findMedianSortedArrays (int[] n1, int[] n2) {
	    int len = n1.length + n2.length;
	    int p1 = (len + 1) / 2;
	    int p2 = (len + 2) / 2;
	    
	    return (getKth(n1, 0, n2, 0, p1) + getKth(n1, 0, n2, 0, p2)) / 2;
	}
	
	private double getKth(int[] n1, int pos1, int[] n2, int pos2, int k) {
	    if(pos1 >= n1.length) {
	        return n2[pos2 + k - 1];
	    }
	    if(pos2 >= n2.length) {
	        return n1[pos1 + k - 1];
	    }
	    if(k == 1) {
	        return Math.min(n1[pos1], n2[pos2]);
	    }
	    
	    if(n1.length - pos1 > n2.length - pos2) {
	        return getKth(n2, pos2, n1, pos1, k);
	    }

	    int off = Math.min(n1.length - pos1, k/2);
	    int left = k - off;
	    
	    if(n1[off + pos1 - 1] == n2[left + pos2 - 1]) {
	        return (double)n1[off + pos1 - 1];
	    }
	    else if(n1[off + pos1 - 1] > n2[left + pos2 - 1]) {
	        return getKth(n1, pos1, n2, pos2 + left, k - left);
	    }
	    else {
	        return getKth(n1, pos1 + off, n2, pos2, k - off);
	    }
	}
}
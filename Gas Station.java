public class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int len = gas.length;
        int i = 0;
        while(i < len) {
            int far = far(i, gas, cost);
            if(far == -1)
                return i;
            else
                i += far + 1;
        }
        return -1;
    }
    
    public int far(int pos, int[] gas, int[] cost) {
        int cur = pos;
        int left = gas[cur];
        int count = 0;
        while(count < gas.length)
        {
            if(left < cost[cur])
                return (cur + gas.length - pos) % gas.length;
            int next = (cur + 1) % gas.length;
            left = left - cost[cur] + gas[next];
            cur = next;
            count++;
        }
        return -1;
    }
}
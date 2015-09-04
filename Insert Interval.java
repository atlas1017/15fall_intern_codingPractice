/**
 * Definition for an interval.
 * public class Interval {
 *     int start;
 *     int end;
 *     Interval() { start = 0; end = 0; }
 *     Interval(int s, int e) { start = s; end = e; }
 * }
 */
public class Solution {
    public List<Interval> insert(List<Interval> intervals, Interval newInterval) {
        if(intervals.size() == 0) {
            intervals.add(newInterval);
            return intervals;
        }
        List<Interval> overlaps = new ArrayList<Interval>();
        // 对于 ArrayList 的操作 如果用 for(Interval one : intervals) --> intervals.remove(one)
        // 会有 concurrent modification
        for(Interval one : intervals) {
            if(overlap(one, newInterval))
                overlaps.add(one);
        }
        for(Interval one : overlaps)
            intervals.remove(one);
        Interval merged = merge(overlaps, newInterval);
        // 之前尝试过在找overlap的时候顺便确定位置 -- 比较复杂
        int pos = 0;
        while(pos < intervals.size()) {
            Interval temp = intervals.get(pos);
            if(merged.start < temp.start)
                break;
            pos++;
        }
        // this line -- forgot add(int, E)
        intervals.add(pos, merged);
        return intervals;
    }
    
    public boolean overlap(Interval a, Interval b) {
        return (a.start <= b.end && b.start <= a.end);
    }
    
    public Interval merge(List<Interval> overlaps, Interval one) {
        int start = one.start;
        int end = one.end;
        for(Interval i : overlaps) {
            start = Math.min(start, i.start);
            end = Math.max(end, i.end);
        }
        return (new Interval(start, end));
    }
}
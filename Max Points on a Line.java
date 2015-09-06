/**
 * Definition for a point.
 * class Point {
 *     int x;
 *     int y;
 *     Point() { x = 0; y = 0; }
 *     Point(int a, int b) { x = a; y = b; }
 * }
 */
public class Solution {
    private class Line {
        int i;
        int j;
        Point one;
        Point two;
        int count;
        Line(Point a, Point b, int i0, int j0) {
            one = a; 
            two = b;
            count = 2;
            i = i0;
            j = j0;
        }
    }
    public int maxPoints(Point[] points) {
        if(points.length < 2) 
            return points.length;
        
        List<Line> lines = new ArrayList<Line>();
        for(int i = 0; i < points.length - 1; i++) {
            for(int j = i + 1; j < points.length; j++) {
                if(points[i].x != points[j].x || points[i].y != points[j].y) {
                    Line oneLine = new Line(points[i], points[j], i, j);
                    lines.add(oneLine);
                }
            }
        }
        if(lines.isEmpty())
            return points.length;
        for(int i = 0; i < points.length; i++) {
            Point onePoint = points[i];
            for(Line oneLine : lines) {
                helpAdding(i, onePoint, oneLine);
            }
        }
        int max = 2;
        for(Line one : lines)
            max = one.count > max ? one.count : max;
        return max;
    }
    public void helpAdding(int i, Point p, Line l) {
        Point p1 = l.one;
        Point p2 = l.two;
        if(i == l.i || i == l.j)
            return;
        if((p.x == p1.x && p.y == p1.y) || (p.x == p2.x && p.y == p2.y)) {
            l.count++;
            return;
        }
        if(p.y == p1.y && p.y == p2.y) {
            l.count++;
            return;
        }
        float slope1 = ((float)p1.y - p.y) / (p1.x - p.x);
        float slope2 = ((float)p2.y - p.y) / (p2.x - p.x);
        if(slope1 == slope2)
            l.count++;
        return;
    }
}
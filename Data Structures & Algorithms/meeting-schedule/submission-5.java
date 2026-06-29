/**
 * Definition of Interval:
 * public class Interval {
 *     public int start, end;
 *     public Interval(int start, int end) {
 *         this.start = start;
 *         this.end = end;
 *     }
 * }
 */

class Solution {
    public boolean canAttendMeetings(List<Interval> intervals) {
        if (intervals.size() == 0) return true;
        intervals.sort((a, b) -> Integer.compare(a.start, b.start));
        Interval prev = intervals.get(0);
        intervals.remove(0);
        for (Interval interval: intervals) {
            if (interval.end < prev.end || interval.start < prev.end) {
                return false;
            }
            prev = interval;
        }
        return true;
    }
}

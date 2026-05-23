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
        intervals.sort((a, b) -> Integer.compare(a.start, b.start));
        if (intervals == null || intervals.size() == 0) return true;
        Interval prev = intervals.remove(0);
        for (Interval interval: intervals) {
            if (interval.start < prev.end) {
                return false;
            }
            prev = interval;
        }

        return true;
    }
}

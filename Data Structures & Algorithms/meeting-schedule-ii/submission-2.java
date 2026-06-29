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
    public int minMeetingRooms(List<Interval> intervals) {
        intervals.sort((a, b) -> Integer.compare(a.start, b.start));
        Queue<Integer> minHeap = new PriorityQueue<>();
        int rooms_needed = 0;
        for (Interval interval: intervals) {
            minHeap.add(interval.end);

            while (!minHeap.isEmpty() && minHeap.peek() <= interval.start) {
                minHeap.poll();
            }
            rooms_needed = Math.max(rooms_needed, minHeap.size());
        }

        return rooms_needed;
    }
}

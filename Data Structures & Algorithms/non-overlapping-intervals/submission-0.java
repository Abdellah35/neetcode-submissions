class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));

        int prevEnd = intervals[0][1];
        int res = 0;
        for (int i = 1; i < intervals.length; i++) {
            int start = intervals[i][0], end = intervals[i][1];
            if (start >= prevEnd) {
                prevEnd = end;
            } else {
                prevEnd = Math.min(prevEnd, end);
                res++;
            }
        }

        return res;
    }
}

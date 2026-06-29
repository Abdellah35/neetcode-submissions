class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));
        List<int[]> valid = new ArrayList<>();
        valid.add(intervals[0]);
        for (int[] interval: intervals) {
            int[] last = valid.get(valid.size() - 1);
            if (interval[0] >= last[1]) {
                valid.add(interval);
            } else {
                if (interval[1] < last[1]) {
                    valid.remove(valid.size() - 1);
                    valid.add(interval);
                } else {
                    continue;
                }
            }
        }

        return intervals.length - valid.size();
    }
}

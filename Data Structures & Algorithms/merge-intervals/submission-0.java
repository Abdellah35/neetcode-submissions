class Solution {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));
        List<int[]> res = new ArrayList<>();
        res.add(intervals[0]);
        for (int[] interval: intervals) {
            int[] lastAdded = res.get(res.size() - 1);
            if (lastAdded[1] >= interval[0]) {
                res.get(res.size() - 1)[1] = Math.max(lastAdded[1], interval[1]);
            } else {
                res.add(interval);
            }
        }
        return res.toArray(new int[res.size()][]);
    }
}

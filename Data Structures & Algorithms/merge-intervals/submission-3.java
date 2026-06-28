class Solution {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));
        List<int[]> ans = new ArrayList<>();
        ans.add(intervals[0]);
        for (int[] interval: intervals) {
            int[] last = ans.get(ans.size() - 1);
            if (interval[0] > last[1]) {
                ans.add(interval);
            } else {
                interval[0] = Math.min(interval[0], last[0]);
                interval[1] = Math.max(interval[1], last[1]);
                ans.remove(ans.size() - 1);
                ans.add(interval);
            }
        }

        return ans.toArray(new int[ans.size()][]);
    }
}

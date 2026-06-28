class Solution {
    public int[][] merge(int[][] intervals) {
        List<int[]> res = new ArrayList<>();
        for (int[] interval: intervals) {
            res = insert(res, interval);
        }

        return res.toArray(new int[res.size()][]);
    }

    public List<int[]> insert(List<int[]> intervals, int[] newInterval) {
        List<int[]> ans = new ArrayList<>();
        
        for (int[] cur: intervals) {
            if (newInterval == null || cur[1] < newInterval[0]) {
                ans.add(cur);
            } else if (cur[0] > newInterval[1]) {
                ans.add(newInterval);
                ans.add(cur);
                newInterval = null;
            } else {
                newInterval[0] = Math.min(cur[0], newInterval[0]);
                newInterval[1] = Math.max(cur[1], newInterval[1]);
            }
        }
        if (newInterval != null) ans.add(newInterval);

        return new ArrayList<>(ans);
    }
}

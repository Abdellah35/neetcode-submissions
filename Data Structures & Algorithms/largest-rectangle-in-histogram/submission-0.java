class Solution {
    public int largestRectangleArea(int[] heights) {
        int n = heights.length;
        int maxArea = 0;
        Stack<Integer[]> stack = new Stack<>();
        for (int i = 0; i < n; i++) {
            int start = i;
            while (!stack.isEmpty() && stack.peek()[1] > heights[i]) {
                Integer[] cur = stack.pop();
                maxArea = Math.max(maxArea, (i - cur[0]) * cur[1]);
                start = cur[0];
            }
            stack.push(new Integer[]{start, heights[i]});
        }

        while (!stack.isEmpty()) {
            Integer[] cur = stack.pop();
            maxArea = Math.max(maxArea, (n - cur[0]) * cur[1]);
        }

        return maxArea;
    }
}

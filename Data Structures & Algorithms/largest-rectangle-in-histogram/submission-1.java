class Solution {
    public int largestRectangleArea(int[] heights) {
        Stack<int[]> stack = new Stack();
        int maxArea = 0;
        for (int i = 0; i < heights.length; i++) {
            maxArea = Math.max(maxArea, heights[i]);
            int start = i;
            while (!stack.isEmpty() && stack.peek()[1] > heights[i]) {
                int[] remove = stack.pop();
                start = remove[0];
                maxArea = Math.max(maxArea, remove[1] * (i - remove[0]));
            }
            stack.push(new int[]{start, heights[i]});
        }
        while (!stack.isEmpty()) {
            int[] remove = stack.pop();
            maxArea = Math.max(maxArea, remove[1] * (heights.length - remove[0]));
        }
        return maxArea;
    }
}

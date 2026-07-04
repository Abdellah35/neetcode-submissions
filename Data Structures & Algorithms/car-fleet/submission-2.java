class Solution {
    public int carFleet(int target, int[] position, int[] speed) {
        List<int[]> combined = new ArrayList<>();
        for (int i = 0; i < position.length; i++) {
            combined.add(new int[]{position[i], speed[i]});
        }
        combined.sort((a, b) -> Integer.compare(a[0], b[0]));
        Stack<Double> stack = new Stack();
        for (int[] ans: combined) {
            double time = (double)(target - ans[0]) / ans[1];
            while (!stack.isEmpty() && stack.peek() <= time) {
                stack.pop();
            }
            stack.push(time);
        }
        return stack.size();
    }
}

class Solution {
    public int carFleet(int target, int[] position, int[] speed) {
        int n = position.length;
        double[][] pair = new double[n][2];
        Stack<Double> stack = new Stack<>();

        for (int i = 0; i < position.length; i++) {
            pair[i] = new double[]{position[i], speed[i]};
        }
        Arrays.sort(pair, (a, b) -> Double.compare(b[0], a[0]));
        
        for (double[] p: pair) {
            stack.push((double) (target - p[0]) / p[1]);
            if (stack.size() >= 2 && stack.peek() <= stack.get(stack.size() - 2)) {
                stack.pop();
            }
        }

        return stack.size();
    }
}

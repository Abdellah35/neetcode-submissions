class Solution {
    public int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack();
        Set<String> operators = new HashSet<>(Arrays.asList("+", "-", "*","/"));
        for (String s: tokens) {
            if (operators.contains(s)) {
                if (stack.size() < 2) return -1;
                int n2 = stack.pop();
                int n1 = stack.pop();
                if (s.equals("+")) {
                    stack.push(n1 + n2);
                } else if (s.equals("-")) {
                    stack.push(n1 - n2);
                } else if (s.equals("*")) {
                    stack.push(n1 * n2);
                } else {
                    if (n2 == 0) return Integer.MAX_VALUE;
                    stack.push(n1 / n2);
                }
            } else {
                stack.push(Integer.parseInt(s));
            }
        }

        return stack.peek();
    }
}

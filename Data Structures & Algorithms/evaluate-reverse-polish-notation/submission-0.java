class Solution {
    public int evalRPN(String[] tokens) {
        Deque<Integer> stack = new ArrayDeque<>();
        for (String token: tokens) {
            if ("+".equals(token)) {
                stack.push(stack.pop() + stack.pop());
            } else if ("-".equals(token)) {
                int n2 = stack.pop();
                int n1 = stack.pop();
                stack.push(n1 - n2);
            } else if ("*".equals(token)) {
                stack.push((int) stack.pop() * stack.pop());
            } else if ("/".equals(token)) {
                int n2 = stack.pop();
                int n1 = stack.pop();
                stack.push(n1 / n2);
            } else {
                stack.push(Integer.parseInt(token));
            }
        }

        return stack.pop();
    }
}

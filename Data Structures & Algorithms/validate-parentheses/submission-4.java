class Solution {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        for (char c: s.toCharArray()) {
            if (c == ')') {
                if (stack.isEmpty()) return false;
                if (stack.pop() != '(') {
                    return false;
                }
            } else if (c == '}') {
                if (stack.isEmpty()) return false;
                if (stack.pop() != '{') {
                    return false;
                }
            } else if (c == ']') {
                if (stack.isEmpty()) return false;
                if (stack.pop() != '[') {
                    return false;
                }
            } else {
                stack.push(c);
            }
        }

        return stack.isEmpty();
    }
}

class Solution {
    public boolean isValid(String s) {
        Map<Character, Character> map = new HashMap<>();
        map.put(')', '(');
        map.put('}', '{');
        map.put(']', '[');
        Deque<Character> stack = new ArrayDeque<>();
        for (char ch: s.toCharArray()) {
            if (map.containsKey(ch)) {
                Character top = stack.isEmpty() ? '#' : stack.pop();
                
                if (top != map.get(ch)) {
                    return false;
                }
            } else {
                stack.push(ch);
            }
        }

        return stack.isEmpty();

    }
}

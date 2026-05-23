class Solution {
    public int lengthOfLongestSubstring(String s) {
        Set<Character> window = new HashSet<>();
        int length = 0, L = 0;

        for (int R = 0; R < s.length();  R++) {
            while (window.contains(s.charAt(R))) {
                window.remove(s.charAt(L));
                L += 1;
            }
            window.add(s.charAt(R));
            System.out.println(window);
            length = Math.max(length, window.size());
        }

        return length;
    }

}

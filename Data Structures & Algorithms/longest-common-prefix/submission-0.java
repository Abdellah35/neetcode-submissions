class Solution {
    public String longestCommonPrefix(String[] strs) {
        int minLen = strs[0].length();
        for (String st: strs) {
            if (minLen > st.length()) {
                minLen = st.length();
            }
        }
        int i = 0;
        while (i < minLen) {
            for (int j = 1; j < strs.length; j++) {
                if (strs[j].charAt(i) != strs[j - 1].charAt(i)) {
                    return strs[0].substring(0,i);
                }
            }
            i++;
        }

        return strs[0].substring(0,i);
    }
}
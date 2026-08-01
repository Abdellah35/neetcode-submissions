class Solution {
    public String shortestCommonSupersequence(String str1, String str2) {
        int N = str1.length(), M = str2.length();
        String[] prev = new String[M + 1];
        for (int i = 0; i < M; i++) {
            prev[i] = str2.substring(i);
        }
        prev[M] = "";
        for (int i = N - 1; i > -1; i--) {
            String[] cur = new String[M + 1];
            cur[M] = str1.substring(i);
            for (int j = M - 1; j > -1; j--) {
                if (str1.charAt(i) == str2.charAt(j)) {
                    cur[j] = str1.charAt(i) + prev[j + 1];
                } else {
                    String n1 = str1.charAt(i) + prev[j];
                    String n2 = str2.charAt(j) + cur[j + 1];
                    cur[j] = n1.length() > n2.length() ? n2 : n1;
                }
            }
            prev = cur;
        }
        return prev[0];
    }
}
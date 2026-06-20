class Solution {
    public boolean isInterleave(String s1, String s2, String s3) {
        Boolean[][][] memo = new Boolean[s1.length()][s2.length()][s3.length()];
        return lcs(0, 0, 0, s1, s2, s3, memo);
    }

    private boolean lcs(int i1, int i2, int i3, String s1, String s2, String s3, Boolean[][][] memo) {
        int l1 = s1.length(), l2 = s2.length(), l3 = s3.length();
        if (i1 == l1 && i2 == l2) {
            return i3 == l3;
        } else if (i1 == l1) {
            return s2.substring(i2, l2).equals(s3.substring(i3, l3));
        } else if (i2 == l2) {
            return s1.substring(i1, l1).equals(s3.substring(i3, l3));
        } else if (i3 == l3) {
            return false;
        } if (memo[i1][i2][i3] != null) return memo[i1][i2][i3];
        memo[i1][i2][i3] = false;
        if (s1.charAt(i1) == s3.charAt(i3) && s2.charAt(i2) == s3.charAt(i3)) {
            memo[i1][i2][i3] = lcs(i1 + 1, i2, i3 + 1, s1, s2, s3, memo) || lcs(i1, i2 + 1, i3 + 1, s1, s2, s3, memo);
        } else if (s2.charAt(i2) == s3.charAt(i3)) {
            memo[i1][i2][i3] =  lcs(i1, i2 + 1, i3 + 1, s1, s2, s3, memo);
        } else if (s1.charAt(i1) == s3.charAt(i3)) {
            memo[i1][i2][i3] = lcs(i1 + 1, i2, i3 + 1, s1, s2, s3, memo);
        }
        return memo[i1][i2][i3];
    }
}

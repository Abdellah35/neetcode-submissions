class Solution {
    public int characterReplacement(String s, int k) {
        char[] count = new char[26];
        int maxFreq = 0;
        int L = 0, res = 0;

        for (int R = 0; R < s.length(); R++) {
            int rightIndx = s.charAt(R) - 'A';
            count[rightIndx]++;

            maxFreq = Math.max(maxFreq, count[rightIndx]);

            while ((R - L + 1) - maxFreq > k) {
                int leftIndx = s.charAt(L++) - 'A';
                count[leftIndx]--;
            }
            res = Math.max(res, R - L + 1);
        }

        return res;
    }
}

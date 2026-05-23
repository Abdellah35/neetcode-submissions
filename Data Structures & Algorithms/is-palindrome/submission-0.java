class Solution {
    public boolean isPalindrome(String s) {
        String cleanS = s.replaceAll("[^a-zA-Z0-9]", "").toLowerCase();

        int left = 0;
        int right = cleanS.length() - 1;

        while (left < right) {
            if (cleanS.charAt(left) != cleanS.charAt(right)) return false;

            left++;
            right--;
        }
        return true;
    }
}

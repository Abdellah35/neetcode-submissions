class Solution {
    public int lengthOfLastWord(String s) {
        String[] lastword = s.split(" ");
        int lindex = lastword.length - 1;
        return lastword[lindex].length();
    }
}
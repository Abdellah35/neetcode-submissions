class Solution {
    public String multiply(String num1, String num2) {
        long n1 = 0, n2 = 0;
        for (char ch: num1.toCharArray()) {
            n1 = n1 * 10 + Character.getNumericValue(ch);
        }
        for (char ch: num2.toCharArray()) {
            n2 = n2 * 10 + Character.getNumericValue(ch);
        }

        return Long.toString(n1 * n2);
    }
}

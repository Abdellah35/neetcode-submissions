class Solution {
    public int numOfSubarrays(int[] arr, int k, int threshold) {
        int count = 0;
        int total = 0;
        int L = 0;
        
        for (int R = 0; R < arr.length; R++) {
            total += arr[R];
            if (R - L + 1 > k) {
                total -= arr[L];
                L++;
            }

            if (R - L + 1 == k && (total / k) >= threshold) {
                count++;
            }
        }

        return count;
    }
}
class Solution {
    public int numOfSubarrays(int[] arr, int k, int threshold) {
        int L = 0;
        int total = 0;
        int count = 0;
        List<Integer> window = new ArrayList<>();

        for (int R = 0; R < arr.length; R++) {

            total += arr[R];
            if (R - L + 1 >= k) {
                if ((total / k) >= threshold) {
                    count += 1;
                }
                total -= arr[L];
                L++;
            }
        }

        return count;
    }
}
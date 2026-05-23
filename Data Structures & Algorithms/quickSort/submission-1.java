// Definition for a pair.
// class Pair {
//     int key;
//     String value;
//
//     public Pair(int key, String value) {
//         this.key = key;
//         this.value = value;
//     }
// }
class Solution {
    public List<Pair> quickSort(List<Pair> pairs) {
        return helper(pairs, 0, pairs.size() - 1);
    }

    private List<Pair> helper(List<Pair> pairs, int s, int e) {
        if (e <= s) return pairs;

        Pair pivot = pairs.get(e);
        int left = s;

        for (int i = s; i < e; i++) {
            if (pairs.get(i).key < pivot.key) {
                Pair tmp = pairs.get(i);
                pairs.set(i, pairs.get(left));
                pairs.set(left, tmp);
                left++;
            }
        }

        pairs.set(e, pairs.get(left));
        pairs.set(left, pivot);

        helper(pairs, s, left - 1);
        helper(pairs, left + 1, e);

        return pairs;
    }
}

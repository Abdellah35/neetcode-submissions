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
        return sort(pairs, 0, pairs.size() - 1);
    }

    private List<Pair> sort(List<Pair> pairs, int s, int e) {
        if (e - s + 1 <= 1 ) {
            return pairs;
        }

        Pair pivot = pairs.get(e);
        int left = s;

        for (int i=s; i < e + 1; i++) {
            if (pairs.get(i).key < pivot.key) {
                Pair temp = pairs.get(left);
                pairs.set(left, pairs.get(i));
                pairs.set(i, temp);
                left++;
            }
        }

        pairs.set(e, pairs.get(left));
        pairs.set(left, pivot);

        sort(pairs, s, left - 1);
        sort(pairs, left + 1, e);

        return pairs;
    }
}

// Definition for a pair.
// class Pair {
//     public int key;
//     public String value;
//
//     public Pair(int key, String value) {
//         this.key = key;
//         this.value = value;
//     }
// }
class Solution {
    public List<Pair> mergeSort(List<Pair> pairs) {
        return mergeSort(pairs, 0, pairs.size() - 1);
    }

    private List<Pair> mergeSort(List<Pair> pairs, int l, int r) {

        if (l < r) {
            int m = (l + r) / 2;

            mergeSort(pairs, l, m);
            mergeSort(pairs, m + 1, r);
            merge(pairs, l, m, r);
        }
        
        return pairs;
    }

    private List<Pair> merge(List<Pair> pairs, int l, int m, int r) {
        int length1 = m - l + 1;
        int length2 = r - m;

        List<Pair> L = new ArrayList<>();
        List<Pair> R = new ArrayList<>();

        for (int i = 0; i < length1; i++) {
            L.add(pairs.get(l + i));
        }
        for (int j = 0; j < length2; j++) {
            R.add(pairs.get(m + j + 1));
        }

        int i = 0;
        int j = 0;
        int k = l;

        while (i < length1 && j < length2) {
            if (L.get(i).key <= R.get(j).key) {
                pairs.set(k++, L.get(i++));
            } else {
                pairs.set(k++, R.get(j++));
            }
        }

        while (i < length1) {
            pairs.set(k++, L.get(i++));
        }

        while (j < length2) {
            pairs.set(k++, R.get(j++));
        }

        return pairs;
    }
}

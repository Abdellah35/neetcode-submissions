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
        return mergeSortHelper(pairs, 0, pairs.size() - 1);
    }

    private List<Pair> mergeSortHelper(List<Pair> pairs, int s, int e) {
        if (e - s + 1 <= 1) return pairs;

        int m = (e + s) / 2;
        mergeSortHelper(pairs, s, m);
        mergeSortHelper(pairs, m + 1, e);
        merge(pairs, s, m, e);
        return pairs;
    }

    private List<Pair> merge(List<Pair> pairs, int s, int m, int e) {
        int l = m - s + 1;
        int r = e - m;

        List<Pair> L = new ArrayList<>();
        List<Pair> R = new ArrayList<>();

        for (int i = 0; i < l; i++) {
            L.add(pairs.get(s + i));
        }

        for (int j = 0; j < r; j++) {
            R.add(pairs.get(m + 1 + j));
        }

        int i = 0, j = 0, k = s;
        while (i < l && j < r) {
            if (L.get(i).key > R.get(j).key) {
                pairs.set(k++, R.get(j++));
            } else {
                pairs.set(k++, L.get(i++));
            }
        }

        while (i < l) {
            pairs.set(k++, L.get(i++));
        }

        while(j < r) {
            pairs.set(k++, R.get(j++));
        }

        return pairs;
    }
}

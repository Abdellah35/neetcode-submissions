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
            int m = (r + l) / 2;

            mergeSort(pairs, l, m);
            mergeSort(pairs, m + 1, r);
            merge(pairs, l, m, r);
        }

        return pairs;
    }

    private void merge(List<Pair> pairs, int l, int m, int r) {
        List<Pair> L = new ArrayList<>(pairs.subList(l, m + 1));

        List<Pair> R = new ArrayList<>(pairs.subList(m + 1, r + 1));

        int i = 0, j = 0, k = l;

        while (i < L.size() && j < R.size()) {
            if (L.get(i).key <= R.get(j).key) {
                pairs.set(k++, L.get(i++));
            } else {
                pairs.set(k++, R.get(j++));
            }
        }

        while (i < L.size()) {
            pairs.set(k++, L.get(i++));
        }

        while (j < R.size()) {
            pairs.set(k++, R.get(j++));
        }
    }
}

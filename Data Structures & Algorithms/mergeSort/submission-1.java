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

    public List<Pair> mergeSort(List<Pair> arr, int l, int r) {
        if (l < r) {
            int m = l + (r - l) / 2;
            mergeSort(arr, l, m);
            mergeSort(arr, m+1, r);
            merge(arr, l, m, r);
        }

        return arr;
    }

    public List<Pair> merge(List<Pair> arr, int l, int m, int r) {

        List<Pair> p1 = new ArrayList<>(arr.subList(l, m + 1));
        List<Pair> p2 = new ArrayList<>(arr.subList(m + 1, r + 1));

        int i = 0;
        int j = 0;
        int k = l;

        while (i < p1.size() && j < p2.size()) {
            if (p1.get(i).key <= p2.get(j).key) {
                arr.set(k++, p1.get(i++));
            } else {
                arr.set(k++, p2.get(j++));
            }
        }

        while (i < p1.size()) arr.set(k++, p1.get(i++));

        while (j < p2.size()) arr.set(k++, p2.get(j++));

        return arr;
    }
}

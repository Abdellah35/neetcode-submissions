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
            int m = (r + l) / 2;
            mergeSort(arr, l, m);
            mergeSort(arr, m+1, r);
            merge(arr, l, m, r);
        }

        return arr;
    }

    public List<Pair> merge(List<Pair> arr, int l, int m, int r) {

        List<Pair> p1 = new ArrayList<>();
        List<Pair> p2 = new ArrayList<>();

        int length1 = m - l + 1;
        int length2 = r - m;

        for (int i=0; i<length1; i++) {
            p1.add(arr.get(l + i));
        }

        for (int i=0; i<length2; i++) {
            p2.add(arr.get(m + 1 + i));
        }
        int i = 0;
        int j = 0;
        int k = l;

        while (i < length1 && j < length2) {
            if (p1.get(i).key <= p2.get(j).key) {
                arr.set(k, p1.get(i));
                i++;
            } else {
                arr.set(k, p2.get(j));
                j++;
            }

            k++;
        }

        while (i < length1) {
            arr.set(k++, p1.get(i));
            i++;
        }

        while (j < length2) {
            arr.set(k++, p2.get(j));
            j++;
        }

        return arr;
    }
}

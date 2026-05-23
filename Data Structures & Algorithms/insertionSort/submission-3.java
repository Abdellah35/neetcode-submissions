// Definition for a pair
// class Pair {
//     int key;
//     String value;
//
//     Pair(int key, String value) {
//         this.key = key;
//         this.value = value;
//     }
// }
public class Solution {
    public List<List<Pair>> insertionSort(List<Pair> pairs) {
        int n = pairs.size();
        if (n == 0) return new ArrayList<>();
        List<List<Pair>> res = new ArrayList<>();
        res.add(new ArrayList<>(pairs));
        for (int i = 1; i < n; i++) {
            int j = i - 1;
            while (j >= 0 && pairs.get(j + 1).key < pairs.get(j).key) {
                Pair tmp = pairs.get(j + 1);
                pairs.set(j + 1, pairs.get(j));
                pairs.set(j, tmp);
                j--;
            }
            res.add(new ArrayList<>(pairs));
        }

        return res;
    }
}

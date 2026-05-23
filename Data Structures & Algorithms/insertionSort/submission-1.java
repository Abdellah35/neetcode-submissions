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
        if (pairs.size() == 0) return new ArrayList<List<Pair>>();
        List<List<Pair>> res = new ArrayList<List<Pair>>();
        res.add(new ArrayList<>(pairs));
        for (int i=1; i<pairs.size(); i++) {
            int j = i - 1;
            while (j>=0 && pairs.get(j).key > pairs.get(j+1).key) {
                Pair temp = pairs.get(j);
                pairs.set(j, pairs.get(j+1));
                pairs.set(j+1, temp);
                j--;
            }
            res.add(new ArrayList<>(pairs));
        }

        return res;
    }
}

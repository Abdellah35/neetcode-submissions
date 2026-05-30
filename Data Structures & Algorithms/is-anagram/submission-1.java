class Solution {
    public boolean isAnagram(String s, String t) {
        Map<Character, Integer> countS = new HashMap<>();
        for (char c: s.toCharArray()) {
            if (countS.containsKey(c)) {
                countS.put(c, countS.get(c) + 1);
            } else {
                countS.put(c, 1);
            }
        }

        for (char c: t.toCharArray()) {
            if (countS.containsKey(c)) {
                countS.put(c, countS.get(c) - 1);

                if (countS.get(c) == 0) {
                    countS.remove(c);
                }
            } else {
                return false;
            }
        }

        return countS.isEmpty();
    }
}

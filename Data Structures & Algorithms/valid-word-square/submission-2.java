class Solution {
    public boolean validWordSquare(List<String> words) {
        int rows = words.size();

        for (int i = 0; i < rows; i++) {
            String row = words.get(i);
            if (row.length() > rows) return false;
            for (int j = 0; j < rows; j++) {
                String word = words.get(j);
                if (word.length() > i) {
                    if (row.length() <= j || word.charAt(i) != row.charAt(j)) {
                        return false;
                    }
                }
            }
        }

        return true;
    }
}

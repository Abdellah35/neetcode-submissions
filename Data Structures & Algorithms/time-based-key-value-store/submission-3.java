class TimeMap {
    Map<String, List<Pair<Integer, String>>> map;
    public TimeMap() {
        map = new HashMap<>();
    }
    
    public void set(String key, String value, int timestamp) {
        map.putIfAbsent(key, new ArrayList<>());
        map.get(key).add(new Pair(timestamp, value));
    }
    
    public String get(String key, int timestamp) {
        String ans = "";
        List<Pair<Integer, String>> list = map.getOrDefault(key, new ArrayList<>());
        int l = 0, r = list.size() - 1;
        while (l <= r) {
            int mid = l + (r - l) / 2;
            if (list.get(mid).getKey() <= timestamp) {
                ans = list.get(mid).getValue();
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }

        return ans;
    }
}

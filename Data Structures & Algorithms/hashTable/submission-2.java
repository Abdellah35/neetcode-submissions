class HashTable {
    List<Integer[]> map;
    int size;
    int capacity;
    private static final Integer[] TOMBSTONE = new Integer[]{-1, -1};

    public HashTable(int capacity) {
        this.capacity = capacity;
        map = new ArrayList<>();
        for (int i = 0; i < capacity; i++) {
            map.add(null);
        }
        size = 0;
    }

    public void insert(int key, int value) {
        int index = key % capacity;
        int firstTombstone = -1;
        while (map.get(index) != null) {
            if (map.get(index) == TOMBSTONE) {
                if (firstTombstone == -1) firstTombstone = index;
            } else if (map.get(index)[0] == key) {
                map.get(index)[1] = value;
                return;
            }
            index = (index + 1) % capacity;
        }
        int insertAt = (firstTombstone != -1) ? firstTombstone : index;
        map.set(insertAt, new Integer[]{key, value});
        size++;
        if (2 * size >= capacity) {
            resize();
        }
    }

    public int get(int key) {
        int index = key % capacity;

        while (map.get(index) != null) {
            Integer[] entry = map.get(index);
            if (entry != TOMBSTONE && entry[0] == key) {
                return entry[1];
            }
            index = (index + 1) % capacity;
        }

        return -1;
    }

    public boolean remove(int key) {
        int index = key % capacity;
        while (map.get(index) != null) {
            Integer[] entry = map.get(index);
            if (entry != TOMBSTONE && entry[0] == key) {
                map.set(index, TOMBSTONE);
                this.size--;
                return true;
            }
            index = (index + 1) % capacity;
        }

        return false;
    }

    public int getSize() {
        return this.size;
    }

    public int getCapacity() {
        return this.capacity;
    }

    public void resize() {
        List<Integer[]> oldMap = this.map;
        List<Integer[]> newMap = new ArrayList<>();
        capacity = 2 * capacity;

        for (int i = 0; i < capacity; i++) {
            newMap.add(null);
        }
        this.map = newMap;

        this.size = 0;
        for (Integer[] p: oldMap) {
            if (p != null && p != TOMBSTONE){
                insert(p[0], p[1]);
            }
        }
    }

}

class Pair {
    int key;
    int val;
    Pair(int key, int value) {
        this.key = key;
        this.val = value;
    }
}

class HashTable {
    int cap;
    int size;
    Pair[] map;


    public HashTable(int capacity) {
        this.cap = capacity;
        this.size = 0;
        this.map = new Pair[this.cap];
    }

    public void insert(int key, int value) {
        int index = key % this.cap;

        while (true) {
            if (map[index] == null) {
                map[index] = new Pair(key, value);
                this.size += 1;
                
                if (this.size >= this.cap / 2) {
                    resize();
                }
                return;
            }
            else if (this.map[index].key == key) {
                this.map[index].val = value;
                return;
            }

            index += 1;
            index = index % this.cap;
        }
    }

    public int get(int key) {
        int index = key % this.cap;
        while (this.map[index] != null) {
            if (this.map[index].key == key) {
                return this.map[index].val;
            }

            index += 1;
            index = index % this.cap;
        }

        return -1;
    }

    public boolean remove(int key) {
        int index = key % this.cap;

        while (this.map[index] != null) {
            if (this.map[index].key == key) {
                this.map[index] = null;
                this.size -= 1;
                return true;
            }

            index += 1;
            index = index % this.cap;
        }

        return false;
    }

    public int getSize() {
        return this.size;
    }

    public int getCapacity() {
        return this.cap;
    }

    public void resize() {
        this.cap = 2 * this.cap;
        Pair[] newMap = new Pair[this.cap];

        Pair[] oldMap= this.map;
        this.map = newMap;
        this.size = 0;

        for (Pair pair: oldMap) {
            if (pair != null) {
                insert(pair.key, pair.val);
            }
        }

    }
}

class DynamicArray {
    int capacity;
    int length;
    int[] arr;

    public DynamicArray(int capacity) {
        this.arr = new int[capacity];
        this.capacity = capacity;
        this.length = 0;
    }

    public int get(int i) {
        if (i < this.length) {
            return this.arr[i];
        }

        return -1;
    }

    public void set(int i, int n) {
        if (i < this.length) {
            this.arr[i] = n;
        }
    }

    public void pushback(int n) {
        if (this.length == this.capacity) {
            this.resize();
        }

        this.arr[this.length] = n;
        this.length++;
    }

    public int popback() {
        if (this.length > 0) {
            this.length--;
            return this.arr[this.length];
        }

        return -1;
    }

    private void resize() {
        this.capacity = 2 * this.capacity;

        int[] newArray = new int[this.capacity];

        for (int i=0; i<this.length;i++) {
            newArray[i] = this.arr[i];
        }
        

        this.arr = newArray;
    }

    public int getSize() {

        return this.length;
    }

    public int getCapacity() {

        return this.capacity;
    }
}

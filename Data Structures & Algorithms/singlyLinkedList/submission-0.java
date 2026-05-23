class LinkedList {

    ArrayList<Integer> linked;

    public LinkedList() {
        linked = new ArrayList<>();
    }

    public int get(int index) {
        if (index < linked.size()) {
            return linked.get(index);
        }

        return -1;
    }

    public void insertHead(int val) {
        linked.add(0, val);
    }

    public void insertTail(int val) {
        linked.add(val);
    }

    public boolean remove(int index) {
        if (index < linked.size()) {
            linked.remove(index);
            return true;
        }

        return false;
    }

    public ArrayList<Integer> getValues() {
        return linked;
    }
}

class MyHashSet {
    Bucket[] buckets;
    public MyHashSet() {
        buckets = new Bucket[500];
    }
    
    public void add(int key) {
        int idx = key % 500;
        if(buckets[idx] == null) {
            buckets[idx] = new Bucket();
        }
        buckets[idx].put(key);
    }
    
    public void remove(int key) {
        int idx = key % 500;
        if (buckets[idx] == null) {
            return;
        }
        buckets[idx].remove(key);
    
    }
    
    public boolean contains(int key) {
        int idx = key % 500;
        if (buckets[idx] == null) {
            return false;
        }
        return buckets[idx].contains(key);
    }
}

class Bucket {
    LinkedList<Integer> values;

    Bucket() {
        values = new LinkedList<>();
    }

    public int put(int value) {
        if (!values.contains(value)) {
            values.add(value);
            return value;
        }
        return -1;
    }

    public boolean contains(int value) {
        if (!values.contains(value)) {
            return false;
        }
        return true;
    }

    public int remove(int value) {
        if (!values.contains(value)) {
            return -1;
        }
        values.remove(Integer.valueOf(value));
        return value;
    }
}

/**
 * Your MyHashSet object will be instantiated and called as such:
 * MyHashSet obj = new MyHashSet();
 * obj.add(key);
 * obj.remove(key);
 * boolean param_3 = obj.contains(key);
 */
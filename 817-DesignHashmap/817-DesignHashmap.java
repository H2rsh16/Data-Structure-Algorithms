// Last updated: 22/05/2026, 11:22:58
import java.util.*;

class MyHashMap {
    private static final double LOAD_FACTOR = 0.75;
    private int capacity = 16;
    private int size = 0;

    private List<Entry>[] buckets;

    static class Entry {
        int key, value;
        Entry(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }

    public MyHashMap() {
        buckets = new List[capacity];
        for (int i = 0; i < capacity; i++) {
            buckets[i] = new LinkedList<>();
        }
    }

    private int getIndex(int key) {
        return Integer.hashCode(key) & (capacity - 1); // Faster than % capacity
    }

    public void put(int key, int value) {
        if ((double) size / capacity > LOAD_FACTOR) {
            resize();
        }

        int index = getIndex(key);
        for (Entry entry : buckets[index]) {
            if (entry.key == key) {
                entry.value = value;
                return;
            }
        }

        buckets[index].add(new Entry(key, value));
        size++;
    }

    public int get(int key) {
        int index = getIndex(key);
        for (Entry entry : buckets[index]) {
            if (entry.key == key) {
                return entry.value;
            }
        }
        return -1;
    }

    public void remove(int key) {
        int index = getIndex(key);
        Iterator<Entry> iterator = buckets[index].iterator();
        while (iterator.hasNext()) {
            if (iterator.next().key == key) {
                iterator.remove();
                size--;
                return;
            }
        }
    }

    private void resize() {
        capacity *= 2;
        List<Entry>[] newBuckets = new List[capacity];
        for (int i = 0; i < capacity; i++) {
            newBuckets[i] = new LinkedList<>();
        }

        for (List<Entry> bucket : buckets) {
            for (Entry entry : bucket) {
                int index = Integer.hashCode(entry.key) & (capacity - 1);
                newBuckets[index].add(entry);
            }
        }

        buckets = newBuckets;
    }
}

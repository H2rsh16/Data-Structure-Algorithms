// Last updated: 22/05/2026, 11:24:12
import java.util.*;
class RandomizedSet {
    private Map<Integer, Integer> itemToIndex;
    private List<Integer> itemArr;
    private Random random;


    public RandomizedSet() {
        itemToIndex = new HashMap<>();
        itemArr = new ArrayList<>();
        random = new Random();
    }
    
    public boolean insert(int val) {
        if (itemToIndex.containsKey(val)) {
            return false;
        }

        int index = itemArr.size();
        itemToIndex.put(val, index);
        itemArr.add(val);
        return true;
    }
    
    public boolean remove(int val) {
        if (!itemToIndex.containsKey(val)) {
            return false;
        }

        int index = itemToIndex.get(val);
        int lastItem = itemArr.get(itemArr.size() - 1);

        itemToIndex.put(lastItem, index);
        itemArr.set(index, lastItem);
        itemArr.remove(itemArr.size() - 1);
        itemToIndex.remove(val);
        return true;
    }
    
    public int getRandom() {
        int index = random.nextInt(itemArr.size());
        return itemArr.get(index);
    }
}

/**
 * Your RandomizedSet object will be instantiated and called as such:
 * RandomizedSet obj = new RandomizedSet();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */
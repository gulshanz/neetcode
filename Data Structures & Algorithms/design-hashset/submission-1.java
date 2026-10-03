
class MyHashSet {
    boolean[] nums;

    public MyHashSet() {
        nums = new boolean[10000000];
    }

    public void add(int key) {
        nums[key] = true;
    }

    public void remove(int key) {
        nums[key] = false;
    }

    public boolean contains(int key) {
        return nums[key];
    }
}

/**
 * Your MyHashSet object will be instantiated and called as such:
 * MyHashSet obj = new MyHashSet();
 * obj.add(key);
 * obj.remove(key);
 * boolean param_3 = obj.contains(key);
 */

//  [Node(), Node()]
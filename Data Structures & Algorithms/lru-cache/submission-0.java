class LRUCache {

    class Node {
        int key;
        int val;
        Node prev;
        Node next;

        Node(int key, int val) {
            this.key = key;
            this.val = val;
        }
    }

    Node left = new Node(0, 0);   // LRU side
    Node right = new Node(0, 0);  // MRU side

    HashMap<Integer, Node> cache = new HashMap<>();
    int capacity;

    public LRUCache(int capacity) {
        this.capacity = capacity;

        left.next = right;
        right.prev = left;
    }

    void remove(Node node) {
        Node prev = node.prev;
        Node next = node.next;

        prev.next = next;
        next.prev = prev;
    }

    void insert(Node node) {
        Node prev = right.prev;

        prev.next = node;
        node.prev = prev;

        node.next = right;
        right.prev = node;
    }

    public int get(int key) {
        if (!cache.containsKey(key)) {
            return -1;
        }

        Node node = cache.get(key);

        // Move accessed node to MRU position
        remove(node);
        insert(node);

        return node.val;
    }

    public void put(int key, int value) {

        // Key already exists
        if (cache.containsKey(key)) {
            Node node = cache.get(key);

            node.val = value;

            // Move updated node to MRU position
            remove(node);
            insert(node);

            return;
        }

        // New key
        Node newNode = new Node(key, value);

        cache.put(key, newNode);
        insert(newNode);

        // Capacity exceeded
        if (cache.size() > capacity) {

            // left.next is the Least Recently Used node
            Node lru = left.next;

            remove(lru);
            cache.remove(lru.key);
        }
    }
}
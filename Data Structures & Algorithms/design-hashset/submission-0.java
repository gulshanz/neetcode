class Node {
    int val;
    Node next;

    Node(int value) {
        this.val = value;
    }
}

class MyHashSet {
    Node head;

    public MyHashSet() {
        head = null;
    }

    public void add(int key) {
        Node node = new Node(key);
        if (contains(key)) {
            return;
        }
        node.next = head;
        head = node;
    }

    public void remove(int key) {
        if (!contains(key))
            return;

        Node temp = head;
        Node prev = null;
        
        while (temp != null) {
            if (temp.val == key) {
                // first element need to remove
                if (prev == null) {
                    Node newHead = temp.next;
                    temp.next = null;
                    head = newHead;
                } else {
                    Node nextNode = temp.next;
                    temp.next = null;
                    prev.next = nextNode;
                }
                return;
            }
            prev = temp;
            temp = temp.next;
        }
    }

    public boolean contains(int key) {
        if (head == null)
            return false;
        Node temp = head;
        while (temp != null) {
            if (temp.val == key)
                return true;
            temp = temp.next;
        }
        return false;
    }
}

/**
 * Your MyHashSet object will be instantiated and called as such:
 * MyHashSet obj = new MyHashSet();
 * obj.add(key);
 * obj.remove(key);
 * boolean param_3 = obj.contains(key);
 */
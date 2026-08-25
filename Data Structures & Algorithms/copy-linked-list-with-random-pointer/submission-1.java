/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {
    public Node copyRandomList(Node head) {
        Node curr = head;
        if(head==null) return null;

        // create adjecent items
        while (curr != null) {
            Node currNext = curr.next;
            Node newNode = new Node(curr.val);
            curr.next = newNode;
            newNode.next = currNext;
            curr = newNode.next;
        }

        curr = head;
        // attach random pointers
        while (curr != null) {
            Node newNode = curr.next;
            if (curr.random != null) {
                newNode.random = curr.random.next;
            }
            curr = newNode.next;
        }

        // seperate the nodes
        Node copyHead = head.next;

        curr = head;
        while (curr != null) {
            Node copy = curr.next;

            curr.next = copy.next;

            if (copy.next != null) {
                copy.next = copy.next.next;
            }

            curr = curr.next;
        }

        return copyHead;

    }
}

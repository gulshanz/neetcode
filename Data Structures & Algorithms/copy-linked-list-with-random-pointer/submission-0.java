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
        Node temp = new Node(-1);
        Node copy = temp;
        Node curr = head;
        HashMap<Node, Node> map = new HashMap<>();
        while(curr!=null){
            Node newNode = new Node(curr.val);
            map.put(curr, newNode);
            copy.next = newNode;
            curr = curr.next;
            copy = copy.next;
        }

        curr = head;
        copy = temp.next;
        while(curr!=null){
            Node random = curr.random;
            if(random!=null){
                copy.random = map.get(curr.random);
            }
            copy = copy.next;
            curr = curr.next;
        }
        return temp.next;
    }
}

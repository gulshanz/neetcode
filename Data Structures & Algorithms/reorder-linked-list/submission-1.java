/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */

class Solution {
    public void reorderList(ListNode head) {
        // count the total nodes
        int n = 0;
        ListNode slow = head;
        ListNode fast = head;
        while(fast!=null && fast.next!=null){
            fast = fast.next.next;
            slow = slow.next;
        }

        ListNode temp = slow;
        
        ListNode secondHalf = slow.next;
        ListNode firstHalf = head;
        
        // seperate first and second half
        temp.next = null;


        // reverse the second half
        temp = secondHalf;
        ListNode prev = null;
        while(temp!=null){
            ListNode next = temp.next;
            temp.next = prev;
            prev = temp;
            temp = next;
        }
        
        // get the head of secondhalf
        secondHalf = prev;

        //attach first half to second half one by one

        ListNode front = firstHalf;
        ListNode frontNext = null;
        ListNode back = secondHalf;
        ListNode backNext = null;
        while(front!=null && back!=null){
            frontNext = front.next;
            backNext = back.next;
            front.next = back;
            back.next = frontNext;
            front = frontNext;
            back = backNext;
        }
    }
}

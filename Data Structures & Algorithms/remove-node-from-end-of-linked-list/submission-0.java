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
    public ListNode removeNthFromEnd(ListNode head, int n) {
        int total = 0;
        ListNode temp = head;
        while(temp!=null){
            temp = temp.next;
            total++;
        }

        temp = head;
        int i = 0;
        int required = total-n;
        if(required==0) return head.next;

        while(temp.next!=null){
            if(i == required-1){
                temp.next = temp.next.next;
                break;
            }
            temp = temp.next;
            i++;
        }
        return head;
    }
}

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
    public ListNode swapPairs(ListNode head) {
        if(head==null || head.next==null){
            return head;
        }
        ListNode current=head;
        ListNode newhead=head.next;
        ListNode temp=null;
        while(current!=null && current.next!=null){
            temp=current;
            current=current.next;
            temp.next=current.next;
            current.next=temp;
            current=temp.next;
            if(current!=null && current.next!=null){
            temp.next=current.next;}
        }
        return newhead;
    }
}
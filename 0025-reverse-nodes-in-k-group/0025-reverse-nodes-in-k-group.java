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
    public ListNode reverseKGroup(ListNode head, int k) {
        if(head==null){
            return null;
        }
        int count=0;
        ListNode temp=head;
        ListNode newHead=null;
        ListNode current=null;
        while(temp!=null){
            count++;
            if(count%k==0){
                current=head;
                ListNode prev=null;
                ListNode next=null;
                for(int i=0;i<k;i++){
                    next=current.next;
                    current.next=prev;
                    prev=current;
                    current=next;
                }
                newHead=prev;
                break;
            }
            temp=temp.next;
        }
        if(temp==null){
            return head;
        }
        head.next=reverseKGroup(current,k);
        return newHead;
    }
}
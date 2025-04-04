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
    public ListNode reverseBetween(ListNode head, int l, int r) {
        ListNode temp=head;
        ListNode left=head;
        ListNode leftPrev=null;
        ListNode rightNext=null;
        int index=1;
        while(temp!=null){
            if(index==l-1){
                leftPrev=temp;
            }
            else if(index==l){
                left=temp;
            }
            else if(index==r+1){
                rightNext=temp;
            }
            temp=temp.next;
            index++;
        }
        ListNode current=left;
        ListNode prev=null;
        ListNode next=null;
        for(int i=0;i<r-l+1;i++){
            next=current.next;
            current.next=prev;
            prev=current;
            current=next;
        }
        if(leftPrev!=null){
            leftPrev.next=prev;
        }
        else{
            head=prev;
        }
        if(rightNext!=null)left.next=rightNext;
        else left.next=null;
        return head;
    }
}
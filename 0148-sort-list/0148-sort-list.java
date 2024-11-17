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
    public ListNode sortList(ListNode head) {
        if(head==null || head.next==null){
            return head;
        }
        ListNode slow=head;
        ListNode fast=head;
        ListNode pre=null;
        while(fast!=null && fast.next!=null){
            pre=slow;
            fast=fast.next.next;
            slow=slow.next;
        }
        pre.next=null;
        ListNode l1=sortList(head);
        ListNode l2=sortList(slow);
        return merge(l1,l2);
    }
    public ListNode merge(ListNode l1,ListNode l2){
        ListNode dummy=new ListNode(0);
        ListNode track=dummy;
        while(l1!=null && l2!=null){
            if(l1.val<l2.val){
                track.next=l1;
                l1=l1.next;
            }
            else{
                track.next=l2;
                l2=l2.next;
            }
            track=track.next;
        }
        if(l1!=null){
            track.next=l1;
        }
        if(l2!=null){
            track.next=l2;
        }
        return dummy.next;
    }
}
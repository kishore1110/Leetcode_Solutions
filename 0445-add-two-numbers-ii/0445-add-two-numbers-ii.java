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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int carry=0;
        ListNode temp1=reverse(l1);
        ListNode temp2=reverse(l2);
        ListNode dummy=new ListNode(0);
        ListNode temp3=dummy;
        while(temp1!=null || temp2!=null || carry!=0){
            int value1=temp1==null?0:temp1.val;
            int value2=temp2==null?0:temp2.val;
            int sum=value1+value2+carry;
            carry=sum/10;
            sum%=10;
            temp3.next=new ListNode(sum);
            temp3=temp3.next;
            temp1=temp1!=null?temp1.next:null;
            temp2=temp2!=null?temp2.next:null;
        }
        return reverse(dummy.next);
    }
    public ListNode reverse(ListNode head){
        ListNode current=head;
        ListNode prev=null;
        ListNode next=null;
        while(current!=null){
            next=current.next;
            current.next=prev;
            prev=current;
            current=next;
        }
        return prev;
    }
}
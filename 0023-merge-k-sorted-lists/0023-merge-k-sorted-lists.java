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
    public ListNode mergeKLists(ListNode[] lists) {
        int k=lists.length;
        if(k==0){
            return null;//sanity
        }
        PriorityQueue<ListNode> minHeap=new PriorityQueue<>(k,(a,b)->a.val-b.val);
        for(ListNode heads:lists){
            if(heads!=null)minHeap.offer(heads);
        }
        ListNode newHead=new ListNode(0);
        ListNode prev=newHead;
        while(!minHeap.isEmpty()){
            ListNode node=minHeap.poll();
            prev.next=node;
            prev=node;
            if(node.next!=null){
                minHeap.offer(node.next);
            }
        }
        return newHead.next;
    }
}
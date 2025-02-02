/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}
*/

class Solution {
    public Node cloneGraph(Node node) {
        if(node==null){
            return null;//sanity
        }
        Queue<Node> queue=new LinkedList<>();
        queue.offer(node);
        HashMap<Integer,Node> map=new HashMap<>();
        Node head=null;
        map.put(node.val,new Node(node.val));
        while(!queue.isEmpty()){
            Node nodee=queue.poll();
            Node corresPondingNode=map.get(nodee.val);
            if(head==null){
                head=corresPondingNode;
            }
            for(Node nodeee:nodee.neighbors){
                Node cpn=map.getOrDefault(nodeee.val,new Node(nodeee.val));
                if(!map.containsKey(nodeee.val)){
                    map.put(nodeee.val,cpn);
                    queue.offer(nodeee);
                }
                corresPondingNode.neighbors.add(cpn);
            }
        }
        return head;
    }
}
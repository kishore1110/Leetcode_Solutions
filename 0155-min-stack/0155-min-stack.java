class MinStack {
        node head;
        node tail;
        class node{
            int data;
            int min;
            node next;
            node prev;
            public node(int val){
                data=val;
                next=null;
                prev=null;
                min=val;
            }}
     public MinStack() {
            head=null;
            tail=null;
        }
    
    public void push(int val) {
        node newnode=new node(val);
        if(head==null){
        head=newnode;
        tail=newnode;}
        else{
            newnode.prev=tail;
            tail.next=newnode;
            tail=newnode;
            newnode.min=Math.min(val,tail.prev.min);

        }
    }
    
    public void pop() {
        if(tail==null){
            return;
        }
        if(tail==head){
            tail=null;
            head=null;
        }
        if (tail != null) {
            tail=tail.prev;
            tail.next = null;
        }
    }
    
    public int top() {
        return tail.data;
    }
    
    public int getMin() {
        return tail.min;
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(val);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */
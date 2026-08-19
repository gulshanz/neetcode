class MyQueue {
    Stack<Integer> stack = new Stack<>();
    Stack<Integer> d = new Stack<>();
    int front = -1;

    public MyQueue() {
        
    }
    
    public void push(int x) {
        if(stack.size()==0){
            front = x;
        }
        stack.push(x);
    }
    
    public int pop() {
        int removed = -1;
        while(!stack.isEmpty()){
            if(stack.size()==1){
                removed = stack.pop();
            }else{
                d.push(stack.pop());
            }
        }

        while(!d.isEmpty()){
            int popped = d.pop();
            if(stack.isEmpty()){
                front = popped;
            }
            stack.push(popped);
        }
        return removed;

    }
    
    public int peek() {
        return front;
    }
    
    public boolean empty() {
        return stack.isEmpty();
    }
}

/**
 * Your MyQueue object will be instantiated and called as such:
 * MyQueue obj = new MyQueue();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.peek();
 * boolean param_4 = obj.empty();
 */
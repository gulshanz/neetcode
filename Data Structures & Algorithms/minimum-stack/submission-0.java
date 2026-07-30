class MinStack {
    Stack<Integer> stack = new Stack<>();
    Stack<Integer> minStack = new Stack<>();

    public MinStack() {
        stack = new Stack<>();
        minStack = new Stack<>();
    }
    
    public void push(int value) {
        stack.push(value);
        if(minStack.isEmpty() || value<=minStack.peek()){
            minStack.push(value);
        }
    }
    
    public void pop() {
        int removed = stack.pop();
        if(minStack.peek()==removed){
            minStack.pop();
        }
    }
    
    public int top() {
        return stack.peek();
    }
    
    public int getMin() {
        return minStack.peek();
    }
}

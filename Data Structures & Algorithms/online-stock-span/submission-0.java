class StockSpanner {
        Stack<Integer> stack = new Stack<>();
    ArrayList<Integer> list = new ArrayList<>();

    public StockSpanner() {
        
    }
    
    public int next(int price) {
        list.add(price);
        int currentIndex = list.size() - 1;

        if(list.size()==1){
            stack.push(list.size()-1);
            return 1;
        }

        if(list.get(stack.peek())>price){
            stack.push(currentIndex);
            return 1;
        }

        
        while(!stack.isEmpty() && list.get(stack.peek())<=price){
            stack.pop();
        }
        int span;
        if(stack.isEmpty()) span = currentIndex+1;
        else span = currentIndex - stack.peek();
        stack.push(currentIndex);
        
        return span;
    }
}

/**
 * Your StockSpanner object will be instantiated and called as such:
 * StockSpanner obj = new StockSpanner();
 * int param_1 = obj.next(price);
 */
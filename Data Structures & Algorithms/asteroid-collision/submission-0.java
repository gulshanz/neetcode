class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        // create an empty stack
        Stack<Integer> stack = new Stack<>();
        // iterate through asteroids
        for(int curr : asteroids) {
            while(!stack.isEmpty() && curr<0 && stack.peek()>0){
                if(Math.abs(curr)>stack.peek()){
                    stack.pop();
                } else if(Math.abs(curr)==stack.peek()){
                    stack.pop();
                    curr = 0;
                    break;
                } else {
                    curr = 0;
                    break;
                }
            }    
            if(curr!=0){
                stack.push(curr);
            }
        }
        

        int[] res = new int[stack.size()];
        int i = stack.size()-1;
        while (!stack.isEmpty()) {
            res[i--] = stack.pop();
        }
        return res;
    }
}
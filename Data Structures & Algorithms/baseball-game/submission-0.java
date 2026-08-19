class Solution {
    public int calPoints(String[] operations) {
        Stack<Integer> stack = new Stack<>();
        int sum = 0;

        for (int i = 0; i < operations.length; i++) {
            String curr = operations[i];
            if (curr.equals("+")) {
                int num2 = stack.pop();
                int num1 = stack.pop();
                int num3 = num1+num2;
                stack.push(num1);
                stack.push(num2);
                stack.push(num3);
            } else if (curr.equals("D")) {
                stack.push(stack.peek() * 2);
            } else if (curr.equals("C")) {
                stack.pop();
            } else {
                stack.push(Integer.parseInt(curr));
            }
        }

        while(!stack.isEmpty()){
            sum+=stack.pop();
        }
        return sum;
    }
}
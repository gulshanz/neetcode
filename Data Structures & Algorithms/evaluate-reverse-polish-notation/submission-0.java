class Solution {
    public int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<>();
        int res = 0;

        for (String str : tokens) {
            if (str.equals("+") || str.equals("-") || str.equals("*") || str.equals("/")) {
                int num2 = stack.pop();
                int num1 = stack.pop();
                switch (str) {
                    case "+":
                        stack.push(num1 + num2);
                        break;
                    case "-":
                        stack.push(num1 - num2);
                        break;
                    case "/":
                        stack.push(num1 / num2);
                        break;
                    case "*":
                        stack.push(num1 * num2);
                        break;
                    default:
                        break;
                }
            } else {
                stack.push(Integer.parseInt(str));
            }
        }
        return stack.pop();

    }
}

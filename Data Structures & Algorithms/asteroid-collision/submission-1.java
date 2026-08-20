class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        Stack<Integer> stack = new Stack<>();
        for (int curr : asteroids) {
            while (!stack.isEmpty() && curr < 0 && stack.peek() > 0) {
                int diff = stack.peek() + curr;
                if (diff > 0) {
                    curr = 0;
                } else if (diff < 0) {
                    stack.pop();
                } else {
                    stack.pop();
                    curr = 0;
                }
            }
            if (curr != 0) {
                stack.push(curr);
            }
        }

        int[] res = new int[stack.size()];
        int i = stack.size() - 1;
        while (!stack.isEmpty()) {
            res[i--] = stack.pop();
        }
        return res;
    }
}
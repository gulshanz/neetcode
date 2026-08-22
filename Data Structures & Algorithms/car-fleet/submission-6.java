class Solution {
    public int carFleet(int target, int[] position, int[] speed) {
        TreeMap<Integer, Integer> map = new TreeMap<>(Collections.reverseOrder());
        for(int i=0;i<position.length;i++){
            map.put(position[i], speed[i]);
        }
        Stack<Double> stack = new Stack<>();

        for(Map.Entry<Integer, Integer> entry:map.entrySet()){
            double time = (double) (target - entry.getKey())/entry.getValue();

            if(stack.isEmpty()||time>stack.peek()){
                stack.push(time);
            }
        }
        return stack.size();
    }
}

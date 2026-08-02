class Solution {
    public int carFleet(int target, int[] position, int[] speed) {
        // sort the array based on position
        TreeMap<Integer, Integer> treeMap = new TreeMap<>(Collections.reverseOrder());
        for (int i = 0; i < position.length; i++) {
            treeMap.put(position[i], speed[i]);
        }
        // create a stack probably monotonic stack
        Stack<Double> stack = new Stack<>();
        // traverse the map in reverse order
        for (Map.Entry<Integer, Integer> entry : treeMap.entrySet()) {
            int currPos = entry.getKey();
            int currSpeed = entry.getValue();
            double timeToTarget = (double)(target-currPos)/currSpeed;
            // create a fleet if car will reach the target in less speed than top ones
            if(stack.isEmpty() || timeToTarget>stack.peek()){
                stack.add(timeToTarget);
            }
        }
        // return the fleet lenght which is stack length
        return stack.size();
    }
}

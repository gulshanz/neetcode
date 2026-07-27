class Solution {
    public int longestConsecutive(int[] nums) {
        if(nums.length==0) return 0;

        int max = 1;

        PriorityQueue<Integer> queue = new PriorityQueue<>();
        for(int num:nums){
            queue.offer(num);   
        }
        int curr = 1;
        int prev = queue.poll();
        while(!queue.isEmpty()){
            int polled = queue.poll();
            if(polled==prev) continue;
            if(polled==prev+1){
                curr++;
            }else{
                curr = 1;
            }
            prev = polled;
            
            max = Math.max(curr, max);
        }

        return max;
    }
}

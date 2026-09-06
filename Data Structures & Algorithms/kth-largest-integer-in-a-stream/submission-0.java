class KthLargest {
    int k;
    Queue<Integer> minHeap = new PriorityQueue<>();

    public KthLargest(int k, int[] nums) {
        this.k = k;

        for(int i=0;i<nums.length;i++){
            minHeap.offer(nums[i]);
        }

        while(minHeap.size()>k){
            minHeap.poll();
        }
    }
    
    public int add(int val) {
        minHeap.offer(val);
        if(minHeap.size()>k){
            minHeap.poll();
        }
        return minHeap.peek();
    }
}

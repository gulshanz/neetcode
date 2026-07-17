class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        PriorityQueue<Map.Entry<Integer, Integer>> minHeap = new PriorityQueue<>(
            (a,b) -> a.getValue()-b.getValue()
        );

        HashMap<Integer, Integer> map = new HashMap<>();

        for(int i=0;i<nums.length;i++){
            map.merge(nums[i], 1, Integer::sum);
        }

        for(Map.Entry<Integer, Integer> entry:map.entrySet()){
            minHeap.add(entry);
            if(minHeap.size()>k){
                minHeap.poll();
            }
        }
        int [] res = new int[k];
        for(int i=0;i<k;i++){
            res[i] = minHeap.poll().getKey();
        }
        return res;
    }
}

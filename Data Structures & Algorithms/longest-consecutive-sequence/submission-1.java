class Solution {
    public int longestConsecutive(int[] nums) {
        if (nums.length == 0) return 0;
        HashSet<Integer> set = new HashSet<>();
        int max = 1;
        for(int num:nums){
            set.add(num);
        }


        for(int num:set){
            int curr = 1;
            int nextNeeded = num+1;
            if(set.contains(num-1)) continue;
            
            while(set.contains(nextNeeded)){
                nextNeeded+=1;
                curr++;
            }
            max = Math.max(curr, max);
            if(curr>=nums.length) break;
        }
        return max;
    }
}

class Solution {
    public int[] productExceptSelf(int[] nums) {
        // create a prefix array without curr
        int [] prefix = new int [nums.length];
        int mul = 1;
        for(int i=0;i<nums.length;i++){
            prefix[i] = mul;
            mul*=nums[i];
        }
        // create a suffix array without curr
        int [] sufix = new int [nums.length];
        mul = 1;
        for(int i=nums.length-1;i>=0;i--){
            sufix[i] = mul;
            mul*=nums[i];
        }
        // return result of multiplication of both
        int [] res = new int [nums.length];
        for(int i=0;i<nums.length;i++){
            res[i] = prefix[i]*sufix[i];
        }
        return res;
    }
}  

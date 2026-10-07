class Solution {
    val res = mutableListOf<MutableList<Int>>()

    fun subsets(nums: IntArray): List<List<Int>> {
        dfs(0, nums, mutableListOf<Int>())
        return res
    }

    fun dfs(index:Int, nums:IntArray, curr:MutableList<Int>){
        if(index>=nums.size){
            res.add(curr.toMutableList())
            return
        }

        curr.add(nums[index])
        dfs(index+1, nums, curr)
        curr.removeAt(curr.size-1)
        dfs(index+1, nums, curr)
    }
}

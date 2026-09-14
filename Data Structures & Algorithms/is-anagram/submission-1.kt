class Solution {
    fun isAnagram(s: String, t: String): Boolean {
        val map = HashMap<Char, Int>()

        for(c in s){
            map.merge(c, 1, Int::plus)
        }

        for(c in t){
            if(map[c]==null) return false;
            map.merge(c, 1, Int::minus)
            if(map[c]!! <=0){
                map.remove(c)
            }
        }

        return map.isEmpty()
    }
}

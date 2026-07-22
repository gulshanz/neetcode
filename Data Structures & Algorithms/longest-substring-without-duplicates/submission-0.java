class Solution {
    public int lengthOfLongestSubstring(String s) {
        HashMap<Character, Integer> map = new HashMap<>();

        int p = 0;
        int max = 0;
        for(int i=0;i<s.length();i++){
            char curr = s.charAt(i);
            if(map.containsKey(curr) && map.get(curr)>=p){
                p = map.get(curr)+1;
            }else{
                max = Math.max(max, i-p+1);
            }
            map.put(curr, i);

        }
        return max;
    }
}

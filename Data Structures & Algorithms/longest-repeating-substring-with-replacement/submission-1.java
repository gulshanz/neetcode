class Solution {
    public int characterReplacement(String s, int k) {
        HashMap<Character, Integer> map = new HashMap<>();
        int res = 0;
        int l = 0;
        int maxFreq = 0;

        for (int r = 0; r < s.length(); r++) {
            map.merge(s.charAt(r), 1, Integer::sum);
            maxFreq = getMaxFreq(map);
            while (((r - l + 1) - maxFreq) > k) {
                map.merge(s.charAt(l), -1, Integer::sum);
                l++;
            }

            res = Math.max(res, r - l + 1);
        }
        return res;
    }

    int getMaxFreq(HashMap<Character, Integer> map) {
        int max = 0;

        for(Map.Entry<Character, Integer> entry:map.entrySet()){
            max = Math.max(max, entry.getValue());
        }
        return max;
    }
}

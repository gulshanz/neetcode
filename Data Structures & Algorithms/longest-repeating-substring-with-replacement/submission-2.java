class Solution {
    public int characterReplacement(String s, int k) {
        HashMap<Character, Integer> map = new HashMap<>();
        int res = 0;
        int l = 0;
        int maxFreq = 0;

        for (int r = 0; r < s.length(); r++) {
            map.merge(s.charAt(r), 1, Integer::sum);
            maxFreq = Math.max(maxFreq, map.get(s.charAt(r)));
            while (((r - l + 1) - maxFreq) > k) {
                map.merge(s.charAt(l), -1, Integer::sum);
                l+=1;
            }

            res = Math.max(res, r - l + 1);
        }
        return res;
    }
}

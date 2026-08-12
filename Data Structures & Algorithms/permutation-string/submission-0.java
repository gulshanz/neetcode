class Solution {
    public boolean checkInclusion(String s1, String s2) {
        if (s1.length() > s2.length())
            return false;
        int[] count = new int[26];

        for (char c : s1.toCharArray()) {
            count[c - 'a']++;
        }

        int l = 0;
        for (int r = 0; r < s2.length(); r++) {
            // taking current char in window
            count[s2.charAt(r) - 'a']--;

            // window is too large
            if (r - l + 1 > s1.length()) {
                count[s2.charAt(l) - 'a']++;
                l++;
            }

            // window has same size as that of s1
            if (r - l + 1 == s1.length()) {
                boolean valid = true;
                for (int i = 0; i < 26; i++) {
                    if (count[i] != 0) {
                        valid = false;
                        break;
                    }
                }
                if (valid)
                    return true;
            }
        }
        return false;
    }
}

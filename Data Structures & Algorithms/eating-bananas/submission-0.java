class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int r = Arrays.stream(piles).max().getAsInt();
        int l = 1;
        int res = r;
        while (l <= r) {
            int k = l + (r - l) / 2;
            long currH = 0;
            for (int pile : piles) {
                currH += (pile + k - 1) / k;
            }
            if (currH <= h) {
                res = k;
                r = k - 1;
            } else {
                l = k + 1;
            }
        }
        return res;
    }
}

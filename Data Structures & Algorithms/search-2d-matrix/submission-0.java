class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int t = 0;
        int b = matrix.length - 1;

        while (t <= b) {
            int mid = (t + b) / 2;

            int l = 0;
            int r = matrix[0].length - 1;

            int start = matrix[mid][l];
            int end = matrix[mid][r];

            if (target >= start && target <= end) {
                // perform binary search here
                while (l <= r) {
                    int hMid = (l + r) / 2;
                    int found = matrix[mid][hMid];
                    if (found == target) {
                        return true;
                    }
                    if (target < found) {
                        r = hMid - 1;
                    } else {
                        l = hMid + 1;
                    }
                }
                return false;

            } else if (target < start) {
                b = mid - 1;
            } else {
                t = mid + 1;
            }
        }
        return false;
    }
}

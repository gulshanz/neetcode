class Solution {
    public int[][] kClosest(int[][] points, int k) {
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(
            (a, b) -> Integer.compare(distance(points[b]), distance(points[a])));

        for (int i = 0; i < points.length; i++) {
            maxHeap.offer(i);
            if (maxHeap.size() > k) {
                maxHeap.poll();
            }
        }

        int[][] res = new int[k][2];
        int i = 0;
        while (!maxHeap.isEmpty()) {
            res[i++] = points[maxHeap.poll()];
        }
        return res;
    }

    public int distance(int[] point) {
        return (point[0] * point[0]) + (point[1] * point[1]);
    }
}

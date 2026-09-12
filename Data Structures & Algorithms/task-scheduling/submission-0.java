class Solution {
    public int leastInterval(char[] tasks, int n) {
        HashMap<Character, Integer> map = new HashMap<>();
        for (char c : tasks) {
            map.merge(c, 1, Integer::sum);
        }

        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        maxHeap.addAll(map.values());

        Queue<Pair<Integer, Integer>> queue = new LinkedList<>();

        int time = 0;

        while (!maxHeap.isEmpty() || !queue.isEmpty()) {
            time++;
            if (!maxHeap.isEmpty()) {
                int curr = maxHeap.poll();
                curr--;
                if (curr > 0) {
                    queue.add(new Pair(curr, time + n));
                }
            }
            if (!queue.isEmpty()) {
                if (queue.peek().getValue() == time) {
                    maxHeap.offer(queue.poll().getKey());
                }
            }
        }

        return time;
    }
}

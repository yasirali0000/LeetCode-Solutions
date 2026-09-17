class pair implements Comparable<pair> {
    int num;
    int freq;

    pair(int num, int freq) {
        this.num = num;
        this.freq = freq;
    }

    public int compareTo(pair p) {
        return this.freq - p.freq;
    }
}

class Solution {
    public int[] topKFrequent(int[] nums, int k) {

        HashMap<Integer, Integer> map = new HashMap<>();

        // Frequency count
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        // Min Heap
        PriorityQueue<pair> pq = new PriorityQueue<>();

        for (int num : map.keySet()) {

            int freq = map.get(num);

            pq.add(new pair(num, freq));

            if (pq.size() > k) {
                pq.remove();
            }
        }

        int[] ans = new int[k];

        for (int i = 0; i < k; i++) {
            ans[i] = pq.remove().num;
        }

        return ans;
    }
}
class Solution {
    public long countPairs(int[] nums, int k) {

        HashMap<Integer, Integer> map = new HashMap<>();
        long pairs = 0;

        for (int num : nums) {

            int gcd = gcd(num, k);
            int need = k / gcd;

            for (int key : map.keySet()) {

                if ((long) gcd * key % k == 0) {
                    pairs += map.get(key);
                }
            }

            map.put(gcd, map.getOrDefault(gcd, 0) + 1);
        }

        return pairs;
    }

    public int gcd(int a, int b) {

        while (b != 0) {
            int temp = a % b;
            a = b;
            b = temp;
        }

        return a;
    }
}
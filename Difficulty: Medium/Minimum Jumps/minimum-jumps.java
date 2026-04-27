class Solution {
    static int minJumps(int[] arr) {
        int n = arr.length;

        // edge cases
        if (n == 1) return 0;
        if (arr[0] == 0) return -1;

        int jumps = 1;
        int maxReach = arr[0];
        int steps = arr[0];

        for (int i = 1; i < n; i++) {
            // reached last index
            if (i == n - 1) return jumps;

            // update max reach
            maxReach = Math.max(maxReach, i + arr[i]);

            steps--;

            // no more steps left
            if (steps == 0) {
                jumps++;

                // cannot move further
                if (i >= maxReach) return -1;

                // reset steps
                steps = maxReach - i;
            }
        }

        return -1;
    }
}
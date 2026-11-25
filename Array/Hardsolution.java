import java.util.*;

class Hardsolution  {
     public int smallestUniqueSubarray(int[] nums) {
        int n = nums.length;

        // Step 1: Build suffix array
        Integer[] sa = new Integer[n];

        for (int i = 0; i < n; i++) {
            sa[i] = i;
        }

        int[] rank = nums.clone();
        int[] temp = new int[n];

        for (int k = 1; k < n; k *= 2) {
            final int len = k;
            final int[] r = rank;

            Arrays.sort(sa, (a, b) -> {
                if (r[a] != r[b]) {
                    return Integer.compare(r[a], r[b]);
                }

                int ra = (a + len < n) ? r[a + len] : -1;
                int rb = (b + len < n) ? r[b + len] : -1;

                return Integer.compare(ra, rb);
            });

            temp[sa[0]] = 0;

            for (int i = 1; i < n; i++) {
                int a = sa[i - 1];
                int b = sa[i];

                boolean different = rank[a] != rank[b];

                int ra = (a + k < n) ? rank[a + k] : -1;
                int rb = (b + k < n) ? rank[b + k] : -1;

                if (ra != rb) {
                    different = true;
                }

                temp[b] = temp[a] + (different ? 1 : 0);
            }

            rank = temp.clone();

            if (rank[sa[n - 1]] == n - 1) {
                break;
            }
        }

        // Step 2: Calculate LCP using Kasai's algorithm
        int[] pos = new int[n];

        for (int i = 0; i < n; i++) {
            pos[sa[i]] = i;
        }

        int[] lcp = new int[n];
        int h = 0;

        for (int i = 0; i < n; i++) {
            int r = pos[i];

            if (r == 0) {
                continue;
            }

            int j = sa[r - 1];

            while (i + h < n && j + h < n &&
                   nums[i + h] == nums[j + h]) {
                h++;
            }

            lcp[r] = h;

            if (h > 0) {
                h--;
            }
        }

        // Step 3: Find minimum unique subarray length
        int ans = n;

        for (int i = 0; i < n; i++) {
            int start = sa[i];

            int left = lcp[i];
            int right = (i + 1 < n) ? lcp[i + 1] : 0;

            int maxLcp = Math.max(left, right);

            int required = maxLcp + 1;

            if (required <= n - start) {
                ans = Math.min(ans, required);
            }
        }

        return ans;
    }
}

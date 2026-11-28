 import java.util.*;

class arraysolution {
    public int maximumSaleItems(int[][] items, int budget) {
        int n = items.length;

        int[] freq = new int[n + 1];

        int minPrice = Integer.MAX_VALUE;

        for (int[] item : items) {
            freq[item[0]]++;
            minPrice = Math.min(minPrice, item[1]);
        }

        // Precompute free-copy gains for every factor
        int[] gain = new int[n + 1];

        for (int f = 1; f <= n; f++) {
            int count = 0;

            for (int j = f; j <= n; j += f) {
                count += freq[j];
            }

            gain[f] = count - 1;
        }

        // Group all available boosted copies by price
        TreeMap<Integer, Long> map = new TreeMap<>();

        for (int[] item : items) {
            int factor = item[0];
            int price = item[1];

            if (price < 2 * minPrice && gain[factor] > 0) {
                map.put(
                    price,
                    map.getOrDefault(price, 0L) + gain[factor]
                );
            }
        }

        long remaining = budget;
        long ans = 0;

        // Buy the cheapest boosted copies first
        for (Map.Entry<Integer, Long> entry : map.entrySet()) {
            int price = entry.getKey();
            long count = entry.getValue();

            long buy = Math.min(count, remaining / price);

            ans += buy * 2;
            remaining -= buy * price;
        }

        // Spend remaining budget on the cheapest regular item
        ans += remaining / minPrice;

        return (int) ans;
    }
}

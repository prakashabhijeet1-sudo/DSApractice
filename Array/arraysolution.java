 /*You are given a 2D integer array items, where items[i] = [factori, pricei] represents the ith item. You are also given an integer budget.

There are unlimited copies of each item available for purchase. You may buy any number of copies of any items such that the total cost of the purchased copies is at most budget.

After buying items, you may receive free copies according to the following rules:

Each purchased copy of item i can give you at most one free copy of another item j.
The free item must satisfy i != j and factori divides factorj.
For each ordered pair (i, j), you can receive a free copy of item j from purchases of item i at most once, regardless of how many copies of item i you buy.
The same item j can be received multiple times for free if it is received from purchases of different item types.
Return the maximum total number of item copies you can obtain, including both purchased copies and free copies, while spending at most budget on purchased items.

 
  */
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

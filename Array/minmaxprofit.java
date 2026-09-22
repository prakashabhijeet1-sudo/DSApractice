import java.util.Scanner;

public class minmaxprofit {
    public static void main(String args[]){
        Scanner sc =new Scanner(System.in);
        System.out.println("ENTER THE SIZE OF ARRAY:");
        int n = sc.nextInt();
        int[] prices = new int[n];

        System.out.println("ENTER THE PRICES ACCORDINGLY TO THE DAYWISE ");
        for (int i = 0; i < n; i++) {
            prices[i] = sc.nextInt();
        }

        int minPrice = prices[0];
        int maxProfit = 0;

        for (int i = 1; i < n; i++) {

            if (prices[i] < minPrice) {
                minPrice = prices[i];
            }

            int profit = prices[i] - minPrice;

            if (profit > maxProfit) {
                maxProfit = profit;
            }
        }
         System.out.println("MAXIMUM PROFIT = " + maxProfit);

        sc.close();

    }
    
}

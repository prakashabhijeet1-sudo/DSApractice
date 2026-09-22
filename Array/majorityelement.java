import java.util.Scanner;

public class majorityelement {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter size of array: ");
        int n = sc.nextInt();

        int[] nums = new int[n];

        System.out.println("Enter array elements:");

        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextInt();
        }

        int candidate = nums[0];
        int count = 1;

        // Find candidate
        for (int i = 1; i < n; i++) {

            if (count == 0) {
                candidate = nums[i];
                count = 1;
            }
            else if (nums[i] == candidate) {
                count++;
            }
            else {
                count--;
            }
        }

        // Verify candidate
        int frequency = 0;

        for (int i = 0; i < n; i++) {
            if (nums[i] == candidate) {
                frequency++;
            }
        }

        if (frequency > n / 2) {
            System.out.println("Majority Element = " + candidate);
        }
        else {
            System.out.println("No Majority Element");
        }

        sc.close();
    }
}
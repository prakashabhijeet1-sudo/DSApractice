

import java.util.Scanner;

public class palindrome {

    public static void main(String args[]) {

        Scanner sc = new Scanner(System.in);

        System.out.println("ENTER THE STRING:");

        String s = sc.nextLine();

        String news = s.replaceAll("\\s", "").toLowerCase();

        String reverse = new StringBuilder(news).reverse().toString();

        System.out.println("RESULT");

        if (news.equals(reverse) && !news.isEmpty()) {
            System.out.println("is a palindrome");
        } else {
            System.out.println("not a palindrome");
        }

        sc.close();
    }
}
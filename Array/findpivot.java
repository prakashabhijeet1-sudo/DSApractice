import java.util.Scanner;

public class findpivot{
    public static void main(String args[])
    {
        Scanner sc =new Scanner(System.in);
        System.out.println("ENTER THE SIZE OF ARRAY:\n");
        int n =sc.nextInt();
        int[] arr=new int[n];
        System.out.println("ENTER THE NUMBERS:\n");
        for(int i=0;i<n;i++)
        {
            arr[i]=sc.nextInt();
        }
        System.out.println("Enter the number required :\n");
        int k=sc.nextInt();
        boolean found=false;

        for(int i =0;i<n;i++)
        {
            if(arr[i]==k)
            {
                System.out.println("FOUND AT " +i);
                found =true;
                break;
            }
        }
        if(!found)
             System.out.println("not found");
        sc.close();
    }
}
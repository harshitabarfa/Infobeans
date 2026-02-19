import java.util.*;

public class CheckSortedArr 
{
    public static void main(String[] args) 
    {
        Scanner sc = new Scanner(System.in);
        
        System.out.println("Enter array size:");
        int size = sc.nextInt();
        
        int[] num = new int[size];

        System.out.println("Enter elements:");
        for(int i = 0; i < size; i++) {
            num[i] = sc.nextInt();
        }

        int count = 0;

        for(int i = 0; i < size - 1; i++) 
        {
            if(num[i] > num[i + 1]) {
                count++;
            }
        }

        if(num[size - 1] > num[0]) 
        {
            count++;
        }

        if(count <= 1) 
        {
            System.out.println("True");
        } else {
            System.out.println("False");
        }
    }
}

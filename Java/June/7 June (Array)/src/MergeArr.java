import java.util.*;

public class MergeArr 
{
    public static void main(String[] args) 
    {
        int[] arr1 = {10, 20, 50, 60};
        int[] arr2 = {30, 80, 100};
        
        int n1 = arr1.length, n2 = arr2.length;
        
        int[] arr3 = new int[n1 + n2];

        int i = 0, j = 0, k = 0;

        while (i < n1 && j < n2) 
        {
            if (arr1[i] < arr2[j])
                arr3[k++] = arr1[i++];
            else
                arr3[k++] = arr2[j++];
        }

        while (i < n1)
        	arr3[k++] = arr1[i++];
        while (j < n2) 
        	arr3[k++] = arr2[j++];

        for (int x : arr3) 
        	System.out.print(x + " ");
    }
}

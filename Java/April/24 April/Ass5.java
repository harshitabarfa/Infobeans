class Ass5 
{
public static void main(String[] args) 
{
int[] arr1 = {1, 2, 3};
int[] arr2 = {4, 5, 6};

int l1 = arr1.length;
int l2 = arr2.length;

int[] result = new int[l1 + l2];

for (int i = 0; i < l1; i++) 
{
result[i] = arr1[i];
}

for (int i = 0; i < l2; i++) 
{
result[l1 + i] = arr2[i];
}

for (int i = 0; i < result.length; i++) 
{
System.out.print(result[i] + " ");
}
}
}

class Ass8
{
public static void main(String args[])
{
int[] array1 = {1, 2, 3};
int[] array2 = {4, 5, 6};

int[] result = new int[array1.length + array2.length];

for (int i = 0; i < array1.length; i++) 
{
result[i] = array1[i];
}

for (int i = 0; i < array2.length; i++) 
{
result[array1.length + i] = array2[i];
}

for (int i = 0; i < result.length; i++) 
{
System.out.print(result[i] + " ");
}

}
}

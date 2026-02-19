class Ass6 
{
public static void main(String[] args) 
{
int[] arr = {1, -1, 3, 2, -7, -5, 11, 6};         

int N = arr.length;

rearrange(arr, N);

for (int i = 0; i < N; i++) 
{
System.out.print(arr[i] + " ");
}
}

public static void rearrange(int[] arr, int N)
{
int[] temp = new int[N];
int index = 0;

for (int i = 0; i < N; i++) 
{
if (arr[i] >= 0) 
{
temp[index++] = arr[i];
}
}

for (int i = 0; i < N; i++) 
{
if (arr[i] < 0) 
{
temp[index++] = arr[i];
}
}

for (int i = 0; i < N; i++) 
{
arr[i] = temp[i];
}

}
}
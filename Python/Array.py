arr = [1,2,3,4,5]

print("1.Print all elements:")
for i in arr:
  print(i)

print()

print("2.Print all even numbers:")
for i in arr:
  if(i%2==0):
    print(i)

print()

print("3.Print all odd numbers:")
for i in arr:
  if(i%2!=0):
    print(i)

print()

print("4.Print sum of all numbers:")
total = sum(arr)
print("Total sum:", total)

print()

print("5.Print maximum and minimum numbers:")
print("Maximum number:", max(arr))
print("Minimum number:", min(arr))

print()

print("6.Print reverse array:")
print("Reversed:", arr[::-1])

print()

print("7.Print sum of all even numbers:")
total1 = 0;
for i in arr:
  if(i%2==0):
    total1 += i
print("Sum:", total1)

print()

print("8.Print sum of all odd numbers:")
total2 = 0;
for i in arr:
  if(i%2!=0):
    total2 += i
print("Sum:", total2)

print()

print("9.Print before append values:")
arr.append(6)
print(arr)

print()

print("10.Print average of array element:")
average = sum(arr) / len(arr)
print("Average:", average)

print()

print("11.Check elements:")
if 5 in arr:
    print("Yes")
else:
    print("No")

print()

print("12.print common element in array:")
arr1 = [1, 2, 3]
arr2 = [2, 3, 4]
common = list(set(arr1) & set(arr2))
print("Common elements:", common)

print()

print("13.Count occurrences of an element:")
arr3 = [1, 2, 2, 3, 4]
x = 2
print(f"{x} appears {arr3.count(x)} times")

print()

print("14.Print array in pairs:")
for i in range(len(arr) - 1):
    print(arr[i], arr[i+1])

print()

print("15.Left and right rotate by one:")
arr = arr[1:] + arr[:1]
print("Left rotated:", arr)
arr1 = arr1[-1:] + arr1[:-1]
print("Right rotated:", arr1)
s = "hello world"
print(s)

print()

print("1.Print string:")
for i in s:
  print(i)

print()

print("2.Reverse a string:")
print(s[::-1])

print()

print("3.Check palindrome:")
print("Palindrome" if s == s[::-1] else "Not Palindrome")

print()

print("4.Capitalize first letter of each word:")
print(s.title())

print()

print("5.Replace all spaces with hyphen:")
print(s.replace(" ", "-"))

print()

print("6.Check anagram:")
s1 = "listen"
s2 = "silent"
print("Anagram" if sorted(s1) == sorted(s2) else "Not Anagram")

print()

print("7.Check all characters are alphabet:")
print("All alphabets:", s.isalpha())

print()

print("7.Check all characters are digit:")
s3 = "1234"
print("All digits:", s3.isdigit())

print()

print("8.Count words in a string:")
s4 = "Hello world from Python"
word_count = len(s4.split())
print("Word count:", word_count)

print()

print("9.Find the longest word in a string:")
longest = max(s4.split(), key=len)
print("Longest word:", longest)

print()

print("10.Replace word:")
s5 = "Python is easy"
s5 = s5.replace("easy", "powerful")
print(s5)

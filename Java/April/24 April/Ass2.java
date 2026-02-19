class Book
{
String title;
String author;
int pages;
double price;

void setBookDetails(String t, String a, int p, double pr)
{
title = t;
author = a;
pages = p;
price = pr;
}

void displayBookDeatils()
{
System.out.println("Book title: "+title);
System.out.println("Author name: "+author);
System.out.println("Pages: "+pages);
System.out.println("Price: "+price);
}
}

class Ass2
{
public static void main(String args[])
{

Book b1 = new Book();
Book b2 = new Book();

System.out.println("Book 1: ");

b1.setBookDetails("Atomic Habit", "James clear", 225, 75);
b1.displayBookDeatils();

System.out.println();
System.out.println("Book 2: ");

b2.setBookDetails("Dark Horse", "Gregg Hurwitz", 250, 85);
b2.displayBookDeatils();
}
}
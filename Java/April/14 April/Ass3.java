import java.util.*;

class Ass3 {
    public static void main(String args[]) {

        Scanner sc = new Scanner(System.in);
        System.out.print("Enter first number: ");
        int a = sc.nextInt();
        System.out.print("Enter second number: ");
        int b = sc.nextInt();
        System.out.print("Enter third number: ");
        int c = sc.nextInt();
        System.out.print("Enter fourth number: ");
        int d = sc.nextInt();

        if (a > b) {
            if (a > c) {
                if (a > d) {
                    System.out.println("a is greater");
                } else {
                    System.out.println("d is greater");
                }
            } else {
                if (c > d) {
                    System.out.println("c is greater");
                } else {
                    System.out.println("d is greater");
                }
            }
        } else {
            if (b > c) {
                if (b > d) {
                    System.out.println("b is greater");
                } else {
                    System.out.println("d is greater");
                }
            } else {
                if (c > d) {
                    System.out.println("c is greater");
                } else {
                    System.out.println("d is greater");
                }
            }
        }

    }
}

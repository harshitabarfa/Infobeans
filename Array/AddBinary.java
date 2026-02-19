import java.math.BigInteger;
import java.util.Scanner;

public class AddBinary {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String a = sc.nextLine();
        String b = sc.nextLine();

        BigInteger a1 = new BigInteger(a, 2);
        BigInteger b1 = new BigInteger(b, 2);

        System.out.println(a1.add(b1).toString(2));
    }
}

public class ZigZagStar {
    public static void main(String[] args) {

        int rows = 3;
        int cols = 11;

        for (int i = 1; i <= rows; i++) {
            for (int j = 1; j <= cols; j++) {
                if ((i == 1 || i == 3) && (j == 1 || j == 5 || j == 9)) {
                    System.out.print("*");
                } else if (i == 2 && (j == 3 || j == 7)) {
                    System.out.print("*");
                } else {
                    System.out.print(" ");
                }
            }
            System.out.println();
        }
    }
}

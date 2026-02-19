class HollowDiamondNumbers {
    public static void main(String[] args) {
        int n = 4;

        for (int i = 1; i <= n; i++) {

            for (int s = n - i; s > 0; s--) {
                System.out.print(" ");
            }

            if (i == 1) {
                System.out.print(i);
            } else {
                System.out.print(i);
                for (int sp = 1; sp <= 2 * i - 3; sp++) {
                    System.out.print(" ");
                }
                System.out.print(i);
            }
            System.out.println();
        }

        for (int i = n - 1; i >= 1; i--) {

            for (int s = n - i; s > 0; s--) {
                System.out.print(" ");
            }

            if (i == 1) {
                System.out.print(i);
            } else {
                System.out.print(i);
                for (int sp = 1; sp <= 2 * i - 3; sp++) {
                    System.out.print(" ");
                }
                System.out.print(i);
            }
            System.out.println();
        }
    }
}
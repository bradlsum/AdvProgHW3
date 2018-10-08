import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Board s = new Board();
        int p = 1;

        Scanner sc = new Scanner(System.in);

        System.out.print("enter 1 for cvc or 0 for pvp: ");
        int choice = sc.nextInt();

        sc.nextLine();

        if (choice == 0) {
            s.printBoard();
            while (s.victory('1') == false && s.victory('0') == false) {
                System.out.print("Player " + p + " please enter you move: ");
                String i = sc.nextLine();
                System.out.println(i);

                if ((s.valid(i, '1') == true) & (p == 1)) {
                    s.victory('1');

                    s.move(i, '1');
                    s.printBoard();
                    p = 2;
                } else if ((s.valid(i, '0') == true) & (p == 2)) {
                    s.move(i, '0');
                    s.printBoard();
                    p = 1;
                } else {
                    System.out.println("Invalid input, try again.");
                    s.printBoard();
                }
            }
        } else if (choice == 1) {
            s.printBoard();
            while (s.victory('1') == false && s.victory('0') == false) {
                if (p == 1) {
                    s.botMove('1');
                    s.printBoard();
                    p = 2;
                } else if (p == 2) {
                    s.botMove('0');
                    s.printBoard();
                    p = 1;
                }
            }
        }
        s.count();
    }
}

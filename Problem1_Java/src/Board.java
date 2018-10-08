import java.lang.reflect.Array;
import java.util.*;
public class Board {

    Piece[][] spaces = {{new Piece(), new Piece(), new Piece(), new Piece(), new Piece(), new Piece(), new Piece(), new Piece()},
                        {new Piece(), new Piece(), new Piece(), new Piece(), new Piece(), new Piece(), new Piece(), new Piece()},
                        {new Piece(), new Piece(), new Piece(), new Piece(), new Piece(), new Piece(), new Piece(), new Piece()},
                        {new Piece(), new Piece(), new Piece(), new Piece('1'), new Piece('0'), new Piece(), new Piece(), new Piece()},
                        {new Piece(), new Piece(), new Piece(), new Piece('0'), new Piece('1'), new Piece(), new Piece(), new Piece()},
                        {new Piece(), new Piece(), new Piece(), new Piece(), new Piece(), new Piece(), new Piece(), new Piece()},
                        {new Piece(), new Piece(), new Piece(), new Piece(), new Piece(), new Piece(), new Piece(), new Piece()},
                        {new Piece(), new Piece(), new Piece(), new Piece(), new Piece(), new Piece(), new Piece(), new Piece()}
    };

    String letters = "abcdefgh";
    int [] numbers = {1, 2, 3, 4, 5, 6, 7, 8};

    int getLetterValue(char c){
        if (c == 'a') return 1;
        else if (c == 'b') return 2;
        else if (c == 'c') return 3;
        else if (c == 'd') return 4;
        else if (c == 'e') return 5;
        else if (c == 'f') return 6;
        else if (c == 'g') return 7;
        else if (c == 'h') return 8;

        return 0;
     }

    void printBoard(){
        System.out.println();
        System.out.print(' ');
        System.out.print('\t');
        for (int i = 0; i < 8; i++) {
            System.out.print(i + 1);
            System.out.print('\t');
        }
        System.out.println('\n');
        for (int i = 0; i < 8; i++) {
            System.out.print(letters.charAt(i));
            System.out.print('\t');
            for (int j = 0; j < 8; j++) {
                System.out.print(this.spaces[i][j].value);
                System.out.print('\t');
            }
            System.out.println('\n');
        }
        System.out.println();
    }

    void move(String move, char c) {
        int row = 0;
        int col = 0;
        if (letters.contains(Character.toString(move.charAt(0)))) {
            row = getLetterValue(move.charAt(0)) - 1;
        } else {
            row = move.charAt(0) - 49;
        }
        col = move.charAt(1) - 49;
        this.spaces[row][col].place(c);

        if (this.spaces[row][col].value != '-') {
            if (col < 6) {  // Check right of the move
                if (this.spaces[row][col + 1].value == this.not(c)) {
                    for (int i = col + 2; i < 8; i++) {
                        if (this.spaces[row][i].value != '-') {
                            if (this.spaces[row][i].value == c) {
                                for (int j = col + 1; j < i; j++) {
                                    this.spaces[row][j].flip();

                                }
                                break;
                            }
                        }
                    }
                }
            }

            if (col > 1) { //Check left of the move
                if (this.spaces[row][col - 1].value == this.not(c)) {
                    for (int i = 1; i < col; i++) {
                        if (this.spaces[row][col - i].value != '-') {
                            if (this.spaces[row][col - i].value == c) {
                                for (int j = 1; j < i; j++) {
                                    this.spaces[row][col - j].flip();
                                }
                                break;
                            }
                        }
                    }
                }
            }

            if (row < 6) {  // Check below the input
                if (this.spaces[row + 1][col].value == this.not(c)) {
                    for (int i = 1; i < 8; i++) {
                        {
                            if (this.spaces[i][col].value != '-') {
                                if (this.spaces[i][col].value == c) {
                                    for (int j = row + 1; j < i; j++) {
                                        if (this.spaces[j][col].value != c) {
                                            this.spaces[j][col].flip();
                                        }
                                        break;
                                    }
                                }
                            }
                        }
                    }
                }
            }

            if (row > 1) {  // Check above the input
                if (this.spaces[row - 1][col].value == this.not(c)) {
                    for (int i = 1; i < row; i++) {
                        if (this.spaces[row - i][col].value != '-') {
                            if (this.spaces[row - i][col].value == c) {
                                for (int j = 1; j < i; j++) {
                                    if (this.spaces[row - j][col].value != c) {
                                        this.spaces[row - j][col].flip();
                                    }
                                }
                                break;
                            }
                        }
                    }
                }
            }
        }
    }


    boolean valid(String move, char c) { ;
        int row = 0;
        int col = 0;

        if (letters.contains(Character.toString(move.charAt(0)))) {
            row = getLetterValue(move.charAt(0)) - 1;
        } else {
            row = move.charAt(0) - 49;
        }
        col = move.charAt(1) - 49;

        if (this.spaces[row][col].value == '-') {
            if (col < 6) {  // Check right of the move
                if (this.spaces[row][col + 1].value == this.not(c)) {
                    for (int i = col + 2; i < 8; i++) {
                        if (this.spaces[row][i].value != '-') {
                            if (this.spaces[row][i].value == c) {
                                return true;
                            }
                        }
                    }
                }
            }


            if (col > 1) { //Check left of the move
                if (this.spaces[row][col - 1].value == this.not(c)) {
                    for (int i = 1; i < col; i++) {
                        if (this.spaces[row][col - i].value != '-') {
                            if (this.spaces[row][col - i].value == c) {
                                return true;
                            }
                        }
                    }
                }
            }

            if (row < 6) {  // Check below the input
                if (this.spaces[row + 1][col].value == this.not(c)) {
                    for (int i = 1; i < 8; i++) {
                        if (this.spaces[i][col].value != '-') {
                            if (this.spaces[i][col].value == c) {
                                return true;
                            }
                        }
                    }
                }
            }

            if (row > 1) {  // Check above the input
                if (this.spaces[row - 1][col].value == this.not(c)) {
                    for (int i = 1; i < row; i++) {
                        if (this.spaces[row - i][col].value != '-') {
                            if (this.spaces[row - i][col].value == c) {
                                return true;
                            }
                        }
                    }
                }
            }
        }
        return false;
    }

    boolean victory(char c){
        for ( int i = 1; i < 9; i++) {
            for (int j = 1; j < 9; j++) {
                if (this.valid(Integer.toString(i) + Integer.toString(j), c)) {
                    return false;
                }
            }
        }
        if (c == '1') {
            System.out.println("Player 1 is out of moves.");
        }
        else if (c == '0') {
            System.out.println("Player 2 is out of moves.");
        }
        return true;
    }

    void count(){
        int one = 0;
        int zero = 0;
        for (int i = 1; i < 8; i++) {
            for (int j = 1; j < 8; j++) {
                if (this.spaces[i][j].value == '1') {
                    one = one + 1;
                }
                else if (this.spaces[i][j].value == '0') {
                    zero = zero + 1;
                }
            }
        }
        if (one > zero) {
            System.out.println("Player 1 wins" +  Integer.toString(one) + "-" + Integer.toString(zero) + "!");
        }
        else if (zero > one) {
        System.out.println("Player 2 wins" + Integer.toString(zero) + "-" + Integer.toString(one) + "!");
        }
        else {
            System.out.println("Tie game" + Integer.toString(zero) + "-" + Integer.toString(one) + "!");
        }
    }

    void botMove(char c){
        Random rand = new Random();
        int i = rand.nextInt(8) + 1;
        int j = rand.nextInt(8) + 1;

        String temp1 = Integer.toString(i);
        String temp2 = Integer.toString(j);

        while (this.valid(temp1 + temp2, c) == false) {
            i = rand.nextInt(8) + 1;
            j = rand.nextInt(8) + 1;
            temp1 = Integer.toString(i);
            temp2 = Integer.toString(j);
        }
        if (this.valid(temp1 + temp2, c) == true) this.move(temp1 + temp2, c);
    }

    char not(char c){
        if (c == '0'){
            return '1';
        }
        else if (c == '1'){
            return '0';
        }
        return '_';
    }
}
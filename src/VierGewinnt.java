import java.util.Scanner;

public class VierGewinnt {

    static Scanner scan = new Scanner(System.in);
    static int x = 8;
    static int y = 8;
    static char[][] gameboard = new char[x][y];

    public static void main(String[] args) {

        // Spielzustand
        boolean win = false;

        // Spieler erstellen
        int counter = 0;
        String player1 = "X";
        System.out.println("Player 1: " + player1);
        String player2 = "O";
        System.out.println("Player 2: " + player2);

        String currentPlayer;

        // Spielfeld erstellen
        // Spielfeld befüllen
        fillArray(gameboard, x, y);
        printGameboard(gameboard, x, y);

        // Spiel starten

        while (win == false) {
            if (counter % 2 == 0) {
                currentPlayer = player1;
                counter++;
            } else {
                currentPlayer = player2;
                counter++;
            }
            System.out.println(currentPlayer + " ist an der Reihe!");
            System.out.println("Platziere einen Stein: ");

            // Userinput prüfen
            int setY = checkUserInput();
            // Stein setzen
            while(nextStep(gameboard, x-1, setY - 1, counter) == false){
                // Spalte ist voll
                System.out.println("Wähle eine andere Spalte aus!");
                setY = checkUserInput();
            }
            printGameboard(gameboard, x, y);



        }



        // Überprüfung ob ein Sieg vorliegt
        // horizontal, vertikal, diagonal

        // Spiel zurücksetzen
        // unentschieden


    }

    public static boolean checkWin(char[][] gameboard, int x, int y) {
        int counter = 0;
        // Horizontal
        while(x < 6){
            while(gameboard[x][y] == 'X') {
                x += 1;
                counter++;
                System.out.println(counter);
            }}
        if (counter == 4) {
            System.out.println("SIEG");
            return true;
        }
        return false;
    }

    public static boolean nextStep(char[][] gameboard, int x, int setY, int counter) {
        while (gameboard[x][setY] != '.') {
            if(x != 0) {
                x--;
            }else {
                System.out.println("\u001B[31m" + "Platzieren nicht möglich" + "\u001B[0m");
                return false;
            }
        }
        if(gameboard[x][setY] == '.') {
            if(counter % 2 == 0) {
                gameboard[x][setY] = 'O';
                System.out.println("X: " + x);
                System.out.println("Y: " + setY);
            } else {
                gameboard[x][setY] = 'X';
                System.out.println("X: " + x);
                System.out.println("Y: " + setY);
            }
        }

        return true;
    }

    public static int checkUserInput() {

        while (!scan.hasNextInt()) {
            System.out.println("Gib eine Zahl ein!!!");
            scan.nextLine();

        }
        int number = scan.nextInt();

        if (number < 1 || number > x) {
            System.out.println("Gib eine Zahl zwischen 1 und " + x + " ein!!!");
            return checkUserInput();
        }
        return number;
    }

    public static void printGameboard(char[][] gameboard, int x, int y) {
        printIndex(x);

        for (int i = 0; i < x; i++) {
            for (int j = 0; j < y; j++) {
                System.out.print(gameboard[i][j]);
                System.out.print(' ');
            }
            System.out.println();
        }
        printIndex(x);
    }

    public static void printIndex(int x) {
        for (int i = 0; i < x; i++) {
            System.out.print(i+1 + " ");
        }
        System.out.println();
    }

    public static void fillArray(char[][] gameboard, int x, int y){
        for (int i = 0; i < x; i++) {
            for (int j = 0; j < y; j++) {
                gameboard[i][j] = '.';
            }
        }
    }
}

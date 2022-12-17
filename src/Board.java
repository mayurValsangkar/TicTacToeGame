public class Board {

    private char board[][];
    private int boardSize = 3;
    private char p1Symbol, p2Symbol;
    // Count of number of cells that are filled
    private int count;
    private static final char EMPTY = ' ';
    public static final int PLAYER1WINS = 1;
    public static final int PLAYER2WINS = 2;
    public static final int DRAW = 3;
    public static final int INCOMPLATE = 4;
    public static final int INVALIDMOVE = 5;



    // Creating board matrix of size 3X3.
    public Board(char p1Symbol, char p2Symbol) {
        board = new char[boardSize][boardSize];
        for(int i=0; i<boardSize; i++) {
            for(int j=0; j<boardSize; j++) {
                board[i][j] = EMPTY;
            }
        }
        this.p1Symbol = p1Symbol;
        this.p2Symbol = p2Symbol;
    }

    // Print function to print board after every move.
    public void print() {
        System.out.println("_______________");
        for(int i=0;i<boardSize;i++){
            for(int j=0;j<boardSize;j++){
                System.out.print("| "+ board[i][j] + " |");
            }
            System.out.println();
        }
        System.out.println("_______________");
    }

    public int move(char symbol, int x, int y) {
        if(x<0 || x >= boardSize || y < 0 || y >= boardSize || board[x][y] != EMPTY) {
            return INVALIDMOVE;
        }

        // Filling cell
        board[x][y] = symbol;
        count++;

        // Row check
        if(board[x][0] == board[x][1] && board[x][0] == board[x][2]) {
            return symbol == p1Symbol ? PLAYER1WINS : PLAYER2WINS;
        }

        // Column check
        if(board[0][y] == board[1][y] && board[0][y] == board[2][y]) {
            return symbol == p1Symbol ? PLAYER1WINS : PLAYER2WINS;
        }

        // Diagonal check
        if(board[0][0] != EMPTY && board[0][0] == board[1][1] && board[0][0] == board[2][2]) {
            return symbol == p1Symbol ? PLAYER1WINS : PLAYER2WINS;
        }

        if(board[0][2] != EMPTY && board[0][2] == board[1][1] && board[0][2] == board[2][0]) {
            return symbol == p1Symbol ? PLAYER1WINS : PLAYER2WINS;
        }

        // If all cells in board get filled up
        if(count == boardSize * boardSize) {
            return  DRAW;
        }

        return INCOMPLATE;
    }
}

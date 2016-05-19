import java.util.*;
import java.awt.*;

class TicTacThumb{
    static int playerId = 1;
    public static void main(String[] args){
        char[][] board = new char[3][3];
        Point tile = new Point();
        Scanner s = new Scanner(System.in);

        initBoard(board);
        do{
            displayBoard(board);
            System.out.println("Player " + playerId + " to move:");
            tile.x = s.nextInt();
            tile.y = s.nextInt();
            boolean result = selectTile(playerId, board, tile);
            if( result ) playerId = changePlayer();
        }while( !goalTest(board) );

    }
    static int changePlayer(){
        if( playerId == 1) return 2;
        return 1;
    }

    static void initBoard(char[][] board){
        for(int i = 0; i < 3; i++){
            for(int j = 0; j < 3; j++){
                board[i][j] = '-';
            }
        }
    }

    static void displayBoard(char[][] board){
        for(int i = 0; i < 3; i++){
            for(int j = 0; j < 3; j++){
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
    }

    static boolean goalTest(char[][] board){
        boolean found = false;
        char symbol = '-';
        // check row
        for(int i = 0; i < 3; i++){
            if(board[i][0] ==  board[i][1] && board[i][1] == board[i][2] && board[i][2] != '-'){
                symbol = board[i][0];
                found = true;
                break;
            }
        }
        if( found == false ){
            // check column
            for(int i = 0; i < 3; i++){
                if(board[0][i] ==  board[1][i] && board[1][i] == board[2][i] && board[2][i] != '-'){
                    symbol = board[0][i];
                    found = true;
                    break;
                }
            }
            if( found == false ){
                // check diagonal
                if(board[0][0] ==  board[1][1] && board[1][1] == board[2][2] && board[2][2] != '-'){
                    symbol = board[0][0];
                    found = true;
                }
                else if(board[0][2] ==  board[1][1] && board[1][1] == board[2][0] && board[2][0] != '-' && found == false){
                    symbol = board[0][0];
                    found = true;
                }
            }
        }

        if( symbol == 'X' && found == true ){
            System.out.println("Player 1 wins.");
            return true;
        }
        else if( symbol == 'O' && found == true ){
            System.out.println("Player 2 wins.");
            return true;
        }

        for(int i = 0; i < 3; i++){
            for(int j = 0; j < 3; j++){
                if(board[i][j] == '-') return false;
            }
        }

        System.out.println("Draw.");
        return true;
    }

    static boolean selectTile(int playerId, char[][] board, Point tile){
        // if tile row does not exceed bounds
        if(tile.x >= 0 && tile.x <= 2){
            // if tile col does not exceed bounds
            if(tile.y >= 0 && tile.y <= 2){
                if(board[tile.x][tile.y] == '-'){
                    if( playerId == 1 ) board[tile.x][tile.y] = 'X';
                    else if( playerId == 2 ) board[tile.x][tile.y] = 'O';
                    return true;
                }
                else{
                    System.out.println("Tile is already occupied");
                    return false;
                }
            }
            else{
                System.out.println("COLUMN FAIL");
                return false;
            }
        }
        else{
            System.out.println("ROW FAIL");
            return false;
        }
    }
}


import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;

class Tile extends JButton implements ActionListener {
	int row, col;
	private static Tile[][] board = new Tile[3][3];
    private static String symbol = "X";

	public Tile(int i, int j){
		this.setBackground(Color.black);
		this.setForeground(Color.white);
		this.setOpaque(true);
        this.setFont(new Font("Arial", Font.PLAIN, 90));
		this.row = i;
		this.col = j;
		board[i][j] = this;
	}

    public static void changeSymbol(String s){
        symbol = s;
        System.out.println(s+ " =)))))))))))))))))))))");
        Board.changeDisplay();
    }

	public void actionPerformed(ActionEvent e){
		if( board[this.row][this.col].getText().equals("") ) board[this.row][this.col].selectTile();
        String result = checkWin();
        System.out.println(result);
        if( result != "" ){
            Board.displayResult(result);
        }
	}

	private void selectTile(){
        this.setText(symbol);
        if( symbol == "X" ) symbol = "O";
        else if( symbol == "O" ) symbol = "X";
	}

	private static String checkWin(){
        boolean found = false;
        String symbol = "";
        // check row
        for(int i = 0; i < 3; i++){
            if(board[i][0].getText() ==  board[i][1].getText() && board[i][1].getText() == board[i][2].getText() && board[i][2].getText() != ""){
                symbol = board[i][0].getText();
                found = true;
                break;
            }
        }
        if( found == false ){
            // check column
            for(int i = 0; i < 3; i++){
                if(board[0][i].getText() ==  board[1][i].getText() && board[1][i].getText() == board[2][i].getText() && board[2][i].getText() != ""){
                    symbol = board[0][i].getText();
                    found = true;
                    break;
                }
            }
            if( found == false ){
                // check diagonal
                if(board[0][0].getText() ==  board[1][1].getText() && board[1][1].getText() == board[2][2].getText() && board[2][2].getText() != ""){
                    symbol = board[0][0].getText();
                    found = true;
                }
                else if(board[0][2].getText() ==  board[1][1].getText() && board[1][1].getText() == board[2][0].getText() && board[2][0].getText() != "" && found == false){
                    symbol = board[0][0].getText();
                    found = true;
                }
            }
        }

        if( symbol == "X" && found == true ){
            return "Player 1 wins.";
        }
        else if( symbol == "O" && found == true ){
            return "Player 2 wins.";
        }

        for(int i = 0; i < 3; i++){
            for(int j = 0; j < 3; j++){
                if(board[i][j].getText() == "") return "";
            }
        }

        return "Draw.";
	}
}

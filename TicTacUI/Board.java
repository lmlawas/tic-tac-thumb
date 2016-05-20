
import javax.swing.*;
import java.awt.*;
import java.util.*;

class Board {

    static String result = "";
    static JFrame frame = new JFrame("Tic Tac Thumb");

	public static void main(String[] args){

		//initialize frame and panel
		
		JPanel panel = new JPanel();

		//set panel and frame size
		frame.setPreferredSize(new Dimension(600,600));
		panel.setPreferredSize(new Dimension(600,600));

		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane();
		frame.pack();
		panel.setLayout(new GridLayout(3,3));

		//add buttons
		for(int i=0;i<3;i++){
			for(int j=0;j<3;j++){
				Tile b = new Tile(i, j);
				b.addActionListener(b);
				panel.add(b);
			}
		}

		frame.add(panel);
		frame.setVisible(true);
		
	}

	public static void displayResult(){
		JOptionPane.showMessageDialog(frame, result);
	}
}

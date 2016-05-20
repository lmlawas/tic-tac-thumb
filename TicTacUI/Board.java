
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;

class Board {
    
    static JFrame frame = new JFrame("Tic Tac Thumb");
    static JPanel panel = new JPanel();

	public static void main(String[] args){

		//set panel and frame size
		frame.setPreferredSize(new Dimension(600,600));
		panel.setPreferredSize(new Dimension(600,600));

		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane();
		frame.pack();
		panel.setLayout(new GridLayout(1,2));		

		ActionListener onClick = new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				JButton source = (JButton) e.getSource();
				if( source.getText().equals("X") ) Tile.changeSymbol("X");
				else Tile.changeSymbol("O");				
			}
		};

		JButton b1 = new JButton("X");
		JButton b2 = new JButton("O");
		b1.setFont(new Font("Arial", Font.PLAIN, 100));
		b2.setFont(new Font("Arial", Font.PLAIN, 100));

		b1.addActionListener(onClick);
		b2.addActionListener(onClick);

		panel.add(b1);
		panel.add(b2);

		frame.add(panel);
		frame.setVisible(true);

	}

	public static void displayResult(String result){
		JOptionPane.showMessageDialog(frame, result);
	}

	public static void changeDisplay(){
		frame.setVisible(false);
		frame = new JFrame("Tic Tac Thumb");
		frame.setPreferredSize(new Dimension(600,600));
		panel.setPreferredSize(new Dimension(600,600));

		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane();
		frame.pack();
		
		panel = new JPanel();
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

}

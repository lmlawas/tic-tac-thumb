
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;

class Board {
    
    static JFrame frame; 
    static JPanel panel;

	public static void main(String[] args){
		
		initView();

	}

	public static void initView(){
		frame = new JFrame("Tic Tac Thumb");
		panel = new JPanel();
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
		b1.setFont(new Font("Arial", Font.PLAIN, 200));
		b2.setFont(new Font("Arial", Font.PLAIN, 200));
		b1.setBackground(Color.black);
		b1.setForeground(Color.white);
		b2.setBackground(Color.black);
		b2.setForeground(Color.white);

		b1.addActionListener(onClick);
		b2.addActionListener(onClick);

		panel.add(b1);
		panel.add(b2);

		frame.add(panel);
		frame.setVisible(true);
	}

	public static void displayResult(String result){
		JOptionPane.showMessageDialog(frame, result);

		Object[] options = {"Yes", "No"};

		int choice = JOptionPane.showOptionDialog(frame, "Would you like to play again?", "Tic Tac Thumb", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, options, options[0]);
		if(choice == 0){
			frame.setVisible(false);
			initView();
		}
		else{
			JOptionPane.showMessageDialog(frame, "Bye bye! -insert thumbs up-");
			System.exit(0);
		}
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

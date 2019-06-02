import javax.swing.JOptionPane;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Gui {
	private static int i = 0;
	private JFrame frame;
	private JPanel panel;
	private JTextField field1;
	private JButton button;
	private JButton play;
	private JButton exit;
	private JLabel label;

	public void initComponents() {
		// initialize all objects here
		frame = new JFrame();
		panel = new JPanel();
		field1 = new JTextField(5);
		button = new JButton("Enter Character");
		play = new JButton("Play Again");
		exit = new JButton("Exit");
		label = new JLabel();
		panel.setBackground(Color.DARK_GRAY);
	}

	public void startGame(){

		initComponents();
		// Information About game
		JOptionPane.showMessageDialog(frame,"Computer Will Choose a Random Alphabet and you Have"
				+ " five Turns to Guess it", "Information", JOptionPane.INFORMATION_MESSAGE);

		//Calling a method which will generate a Random Alphabet
		GameLogic.randomNumberGeneration();
		char computerChar = GameLogic.getChar();
		System.out.println("Computer Entered Hidden "+computerChar);

		frame.setTitle("Guess Game");
		frame.setSize(300, 200);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		field1.setColumns(10);
		//Listener for Enter Key
		field1.addKeyListener(new KeyAdapter() {

			@Override
			public void keyPressed(KeyEvent e) {
				if(e.getKeyCode() == KeyEvent.VK_ENTER) {
					button.doClick();
				}
			}
		});

		button.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e){
				String userChar = field1.getText(); 
				char ch = userChar.charAt(0);

				if(GameLogic.getResult(ch) == GameLogic.CHAR_GREATER) {
					JOptionPane.showMessageDialog(frame,"Your Alphabet is Higher than Mine",
							"Hint", JOptionPane.INFORMATION_MESSAGE);
				}
				else if(GameLogic.getResult(ch) == GameLogic.CHAR_SMALLER) {
					JOptionPane.showMessageDialog(frame,"Your Alphabet is Lower Than Mine"
							+ " Than Mine", "Hint", JOptionPane.INFORMATION_MESSAGE);
				}
				else {
					JOptionPane.showMessageDialog(frame,"Congratulations!!! You Won", "",
							JOptionPane.INFORMATION_MESSAGE);
					frame.dispose();
					startGame();
				}

				i++;
				
				//Restricting User to Only have Five Turns to Guess
				if(i == 5){
					JOptionPane.showMessageDialog(frame,"Sorry the Game is Over",
							"You Lose", JOptionPane.INFORMATION_MESSAGE);
					JOptionPane.showMessageDialog(frame, "I Selected "+computerChar, "You Lose", JOptionPane.INFORMATION_MESSAGE);
					frame.dispose();
					i=0;
					startGame();
				}
			}
		});
		
		//Exit Button
		exit.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				System.exit(0);
			}
		});
		
		//Play again Button
		play.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				frame.dispose();
				startGame();
			}
		});
		
		// Signature
		label.setText("Created by Usama");
		label.setOpaque(true);
		label.setBackground(Color.WHITE);
		label.setFont(new Font("Serif", Font.PLAIN, 20));

		panel.add(field1);
		panel.add(button);
		panel.add(play);
		panel.add(exit);
		panel.add(label);

		frame.add(panel);
		frame.setVisible(true);

	}

}

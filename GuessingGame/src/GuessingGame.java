//Desktop game where user try to guess the number from 1 to 100 in limited number tries.
//The guessed number is generated randomly.
//Swing is used

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.SwingConstants;

import java.awt.Color;
import java.awt.Font;
import java.awt.Dimension;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class GuessingGame extends JFrame {

	private int theNumber;				// guessed number that user tries to guess
	private int numberOfTriesMax = 7; 	// maximum number of user's tries to guess the number
	private int numberOfTries; 			// remaining number of user's tries to guess the number
	
	private JTextField txtGuess;		// text field for entering number
	private JLabel lblOutput;			// label with info for user
	private JButton btnGuess;			// button for guessing
	private JButton btnPlayAgain;		// button for playing new game

	// check if entered number equal to guessed number
	public void checkGuess() {

		String guessText = txtGuess.getText();		// read text with entered number
		String message = "";
		numberOfTries--;
		
		try {
			int guess = Integer.parseInt(guessText); // parse entered number from text
			
			//compare entered number with guessed number
			if (guess < theNumber) {
				message = guess + " is too low. ";
				if (numberOfTries > 0)
					message += "Try again!";
				else {
					message += "You used " + numberOfTriesMax + " tries. You lose! Let's play again!";
					btnGuess.setVisible(false);
					btnPlayAgain.setVisible(true);
				}
			}
			else if (guess > theNumber) {
				message = guess + " is too high. ";
				if (numberOfTries > 0)
					message += "Try again!";
				else {
					message += "You used " + numberOfTriesMax + " tries. You lose! Let's play again!";
					btnGuess.setVisible(false);
					btnPlayAgain.setVisible(true);
				}
			}
			else {
				message = guess + " is correct! You win after " + (numberOfTriesMax - numberOfTries) + 
						" tries! Let's play again!";
				btnGuess.setVisible(false);
				btnPlayAgain.setVisible(true);
			}



		} catch (Exception e) {
			message = "Incorrect value! Enter a whole number between 1 and 100! ";
			if (numberOfTries <= 0) {
				message = "You used " + numberOfTriesMax + " tries. You lose! Let's play again!";
				btnGuess.setVisible(false);
				btnPlayAgain.setVisible(true);
			}
		} finally {
			lblOutput.setText(message);
			txtGuess.requestFocus();
			txtGuess.setText("");
		}
	}

	//start new guessing game
	public void newGame() {
		theNumber = (int)(Math.random()*100 + 1); 	// generate guessed number randomly
		numberOfTries = numberOfTriesMax;			// set number of user's tries to maximum for new game
		btnPlayAgain.setVisible(false);
	}

	//guessing game's window
	public GuessingGame() {

		setForeground(Color.WHITE);
		setBackground(Color.WHITE);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("Lada Hi-Lo Guessing Game");
		getContentPane().setLayout(null);

		JLabel lblTitle = new JLabel("Lada's Hi-Lo Guessing Game");
		lblTitle.setHorizontalAlignment(SwingConstants.CENTER);
		lblTitle.setFont(new Font("Comic Sans MS", Font.BOLD, 16));
		lblTitle.setBounds(1, 24, 434, 28);
		getContentPane().add(lblTitle);

		JLabel lblGuess = new JLabel("Guess a number between 1 and 100:");
		lblGuess.setHorizontalAlignment(SwingConstants.RIGHT);
		lblGuess.setFont(new Font("Comic Sans MS", Font.PLAIN, 13));
		lblGuess.setBounds(1, 76, 301, 21);
		getContentPane().add(lblGuess);

		//text field for entering number
		txtGuess = new JTextField();
		txtGuess.setFont(new Font("Comic Sans MS", Font.PLAIN, 13));
		txtGuess.setBounds(305, 76, 51, 20);
		getContentPane().add(txtGuess);
		txtGuess.setColumns(10);
		txtGuess.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				checkGuess();
			}
		});

		//button for guessing
		btnGuess = new JButton("Guess!");
		btnGuess.setFont(new Font("Comic Sans MS", Font.PLAIN, 13));
		btnGuess.setBounds(172, 121, 89, 23);
		getContentPane().add(btnGuess);
		btnGuess.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				checkGuess();
			}
		});

		//label with info for user
		lblOutput = new JLabel("Enter a number above and click Guess!");
		lblOutput.setFont(new Font("Comic Sans MS", Font.PLAIN, 13));
		lblOutput.setHorizontalAlignment(SwingConstants.CENTER);
		lblOutput.setBounds(1, 168, 434, 21);
		getContentPane().add(lblOutput);
		
		//button for playing new game
		btnPlayAgain = new JButton("Play Again");
		btnPlayAgain.setFont(new Font("Comic Sans MS", Font.PLAIN, 13));
		btnPlayAgain.setBounds(167, 213, 100, 23);
		getContentPane().add(btnPlayAgain);
		btnPlayAgain.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				btnGuess.setVisible(true);
				lblOutput.setText("Enter a number above and click Guess!");
				newGame();
			}
		});
		btnPlayAgain.setVisible(false);
	}

	// program execution
	public static void main(String[] args) {

		GuessingGame theGame = new GuessingGame();	// create guessing game's window
		theGame.setSize(new Dimension(450,300));	
		theGame.setVisible(true);					
		
		theGame.newGame();							// start new guessing game
	}
}

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

	private JTextField txtGuess;
	private JLabel lblOutput;
	private int theNumber;
	private int numberOfTries;

	public void checkGuess() {

		String guessText = txtGuess.getText();
		String message = "";
		numberOfTries--;
		try {
			int guess = Integer.parseInt(guessText);

			if (guess < theNumber) {
				message = guess + " is too low. ";
				if (numberOfTries > 0)
					message += "Try again!";
				else {
					message += "You used 7 tries. You lose! Let's play again!";
					newGame();
				}
			}
			else if (guess > theNumber) {
				message = guess + " is too high. ";
				if (numberOfTries > 0)
					message += "Try again!";
				else {
					message += "You used 7 tries. You lose! Let's play again!";
					newGame();
				}
			}
			else {
				message = guess + " is correct. You win after " + (7-numberOfTries)+ " tries! Let's play again!";
				newGame();
			}



		} catch (Exception e) {
			message = "Enter a whole number between 1 and 100!";
		} finally {
			lblOutput.setText(message);
			txtGuess.requestFocus();
			txtGuess.selectAll();
		}
	}

	public void newGame() {
		theNumber = (int)(Math.random()*100 + 1);
		numberOfTries = 7;
	}

	public GuessingGame() {

		setForeground(Color.WHITE);
		setBackground(Color.WHITE);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("Lada Hi-Lo Guessing Game");
		getContentPane().setLayout(null);

		JLabel lblTitle = new JLabel("Lada's Hi-Lo Guessing Game");
		lblTitle.setHorizontalAlignment(SwingConstants.CENTER);
		lblTitle.setFont(new Font("Comic Sans MS", Font.BOLD, 16));
		lblTitle.setBounds(1, 33, 434, 28);
		getContentPane().add(lblTitle);

		JLabel lblGuess = new JLabel("Guess a number between 1 and 100:");
		lblGuess.setHorizontalAlignment(SwingConstants.RIGHT);
		lblGuess.setFont(new Font("Comic Sans MS", Font.PLAIN, 13));
		lblGuess.setBounds(1, 94, 301, 21);
		getContentPane().add(lblGuess);

		txtGuess = new JTextField();
		txtGuess.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				checkGuess();
			}
		});
		txtGuess.setFont(new Font("Comic Sans MS", Font.PLAIN, 13));
		txtGuess.setBounds(309, 94, 51, 20);
		getContentPane().add(txtGuess);
		txtGuess.setColumns(10);

		JButton btnGuess = new JButton("Guess!");
		btnGuess.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				checkGuess();
			}
		});
		btnGuess.setFont(new Font("Comic Sans MS", Font.PLAIN, 13));
		btnGuess.setBounds(172, 148, 89, 23);
		getContentPane().add(btnGuess);

		lblOutput = new JLabel("Enter a number above and click Guess!");
		lblOutput.setFont(new Font("Comic Sans MS", Font.PLAIN, 13));
		lblOutput.setHorizontalAlignment(SwingConstants.CENTER);
		lblOutput.setBounds(0, 204, 434, 21);
		getContentPane().add(lblOutput);
	}

	public static void main(String[] args) {

		GuessingGame theGame = new GuessingGame();
		theGame.newGame();
		theGame.setSize(new Dimension(450,300));
		theGame.setVisible(true);
	}
}

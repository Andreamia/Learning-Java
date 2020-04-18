// Desktop game where mad story is generated from words entered by user
// and random predefined words.
// Swing is used.

import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.SwingConstants;
import javax.swing.text.SimpleAttributeSet;
import javax.swing.text.StyleConstants;
import javax.swing.text.StyledDocument;

import java.awt.Font;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import java.util.Random;

public class MadStoryGame extends JFrame {
	private JTextField txtAdjective;		// text field for adjective
	private JTextField txtNumber;			// text field for number
	private JTextField txtColor;			// text field for color
	private JTextField txtVerb;				// text field for verb
	
	private JButton btnGenerate;			// button for generating story
	private JButton btnPlayAgain;			// button for playing new game
	private JTextPane txtGeneratedStory;	// text panel for generated text
	
	// parts of story for random selection
	String[] beginning = new String [] {"Once upon a time, ", "A long time ago ", 
			"Long ago and far away, ", "It is said, that ", 
			"Far away and just as long ago "};
	String[] what = new String[] {" lamp, ", " pillow, ", " kettle, ", 
			" table, ", " spoon, "};
	String[] whatDetails = new String[] {" married to ", " who fought with ", 
			" who killed ", " ridden by ", " eaten by "};
	String[] who = new String[] {" dragons, ", " frogs, ", " princesses, ", 
			" knights, ", " robots, "};
	String[] where = new String[] {" from the roof of skyscraper. ", " through the hospital's window. ",
			" across the mole's tunnel. ", " in the really small bottle. ", " on king's head. "};
	String ending = "The end!";

	// generate story and show it
	public void generateStory() {
		
		String adjective = txtAdjective.getText();	// read adjective
		String number = txtNumber.getText();		// read number
		String color = txtColor.getText();			// read color
		String verb = txtVerb.getText();			// read verb in III-rd form
		
		String message;			// generated story

		// select parts of story randomly
		Random rand = new Random();
		int randBeginning = rand.nextInt(beginning.length);
		int randWhat = rand.nextInt(what.length);
		int randWho = rand.nextInt(who.length);
		int randWhatDetails = rand.nextInt(whatDetails.length);
		int randWhere = rand.nextInt(where.length);
	
		// form string with generated story
		message = beginning [randBeginning] + "\n"
				+ adjective + what[randWhat] + whatDetails[randWhatDetails] 
				+ number + " " + color + who[randWho] + "\n" 
				+ verb + "\n" 
				+ where[randWhere] + "\n" 
				+ ending;

		// show generated story
		txtGeneratedStory.setText(message);
		btnGenerate.setVisible(false);
		btnPlayAgain.setVisible(true);
	}
	
	// start new game
	public void newGame () {
		txtAdjective.setText("");
		txtNumber.setText("");
		txtColor.setText("");
		txtVerb.setText("");
		btnGenerate.setVisible(true);
		txtGeneratedStory.setText("");
		btnPlayAgain.setVisible(false);
	}
	
	// game window
	public MadStoryGame() {
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		getContentPane().setLayout(null);
		
		JLabel lblTitle = new JLabel("Lada's Mad Story Game");
		lblTitle.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblTitle.setHorizontalAlignment(SwingConstants.CENTER);
		lblTitle.setBounds(0, 15, 484, 25);
		getContentPane().add(lblTitle);
		
		JLabel lblEnterWords = new JLabel("Enter words for a story:");
		lblEnterWords.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblEnterWords.setHorizontalAlignment(SwingConstants.CENTER);
		lblEnterWords.setBounds(0, 55, 484, 20);
		getContentPane().add(lblEnterWords);
		
		JLabel lblAdjective = new JLabel("Adjective:");
		lblAdjective.setHorizontalAlignment(SwingConstants.RIGHT);
		lblAdjective.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblAdjective.setBounds(0, 93, 83, 14);
		getContentPane().add(lblAdjective);
		
		txtAdjective = new JTextField();
		txtAdjective.setFont(new Font("Tahoma", Font.PLAIN, 13));
		txtAdjective.setBounds(93, 90, 97, 20);
		getContentPane().add(txtAdjective);
		txtAdjective.setColumns(10);
		txtAdjective.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				txtNumber.requestFocus();
			}
		});

		JLabel lblNumber = new JLabel("Number:");
		lblNumber.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNumber.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNumber.setBounds(0, 128, 83, 14);
		getContentPane().add(lblNumber);
		
		txtNumber = new JTextField();
		txtNumber.setFont(new Font("Tahoma", Font.PLAIN, 13));
		txtNumber.setBounds(93, 125, 97, 20);
		getContentPane().add(txtNumber);
		txtNumber.setColumns(10);
		txtNumber.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				txtColor.requestFocus();
			}
		});
		
		JLabel lblColor = new JLabel("Color:");
		lblColor.setHorizontalAlignment(SwingConstants.RIGHT);
		lblColor.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblColor.setBounds(233, 93, 83, 14);
		getContentPane().add(lblColor);
		
		txtColor = new JTextField();
		txtColor.setFont(new Font("Tahoma", Font.PLAIN, 13));
		txtColor.setBounds(332, 90, 97, 20);
		getContentPane().add(txtColor);
		txtColor.setColumns(10);
		txtColor.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				txtVerb.requestFocus();
			}
		});

		JLabel lblVerb = new JLabel("Verb in III-rd form:");
		lblVerb.setHorizontalAlignment(SwingConstants.RIGHT);
		lblVerb.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblVerb.setBounds(200, 128, 122, 14);
		getContentPane().add(lblVerb);
		
		txtVerb = new JTextField();
		txtVerb.setFont(new Font("Tahoma", Font.PLAIN, 13));
		txtVerb.setBounds(332, 125, 95, 20);
		getContentPane().add(txtVerb);
		txtVerb.setColumns(10);
		txtVerb.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnGenerate.requestFocus();
			}
		});
		
		btnGenerate = new JButton("Generate Story");
		btnGenerate.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnGenerate.setBounds(175, 160, 133, 23);
		getContentPane().add(btnGenerate);
		btnGenerate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				generateStory();	// generate story and show it
				btnPlayAgain.requestFocus();
			}
		});
		
		btnPlayAgain = new JButton("Play Again");
		btnPlayAgain.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnPlayAgain.setBounds(189, 319, 106, 23);
		getContentPane().add(btnPlayAgain);
		btnPlayAgain.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				newGame();			// start new game
			}
		});
		btnPlayAgain.setVisible(false);
		
		txtGeneratedStory = new JTextPane();
		txtGeneratedStory.setBackground(Color.LIGHT_GRAY);
		txtGeneratedStory.setEditable(false);
		txtGeneratedStory.setForeground(Color.BLUE);
		txtGeneratedStory.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 15));
		txtGeneratedStory.setBounds(23, 198, 438, 106);
		getContentPane().add(txtGeneratedStory);
		
		StyledDocument doc = txtGeneratedStory.getStyledDocument();
		SimpleAttributeSet center = new SimpleAttributeSet();
		StyleConstants.setAlignment(center, StyleConstants.ALIGN_CENTER);
		doc.setParagraphAttributes(0, doc.getLength(), center, false);

	}

	public static void main(String[] args) {
		
		MadStoryGame madStoryGame = new MadStoryGame(); //window for new game
		madStoryGame.setSize(500, 400);;
		madStoryGame.setVisible(true);
		
		madStoryGame.newGame(); // start new game

	}
}

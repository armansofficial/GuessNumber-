package Guess_Game;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.NumberFormat;
import java.util.Random;

import javax.swing.*; 
public class GuessNumber extends JFrame {

	private int generateNumber;
	private int attemp;
	private JLabel label;
	private JTextField textField;
	private JButton submitButton;
	
	public GuessNumber() {
		setTitle("Number Guess Game");
		setSize(400, 400);
		label=new JLabel("Enter Number between 1 to 100");
	 textField = new JTextField(30);
     submitButton = new JButton("Submit");
     
     submitButton.addActionListener(new ActionListener() {
         @Override
         public void actionPerformed(ActionEvent e)
         {
        	 checkGuessIsCorrect(); 
        	 }
         }
    		 
    		 );
     
     generateNumber=generateNumber();
     System.out.println(generateNumber);
   
	setLayout(new FlowLayout());
	add(label);
	add(textField);
	add(submitButton);
	
	
	setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	setVisible(true);
	
   
	}
	 //Method for generate rando number
		public static int generateNumber() {
			Random ran=new Random();
	         
			return ran.nextInt(100)+1;
			
		}
	
	
	
	
	//Logic to check is correct or Not...
	
	public  void checkGuessIsCorrect() {
		try {
	int orginalNumber=Integer.parseInt(textField.getText());
		attemp++;
		if (orginalNumber==generateNumber) {
			JOptionPane.showMessageDialog(this, "Congratulation you are winner in: " +attemp+ " attemp", " Winner", JOptionPane.INFORMATION_MESSAGE );
		    dispose();
		}
		
		else if(orginalNumber>generateNumber) {
			JOptionPane.showMessageDialog(this, "Try Again.! You are to high..", "Try Again", JOptionPane.WARNING_MESSAGE);
		}
		else {
			JOptionPane.showMessageDialog(this, "Try Again.! You are to Close..", "Try Again", JOptionPane.WARNING_MESSAGE);
			
		}
		}
		catch(NumberFormatException nfe) {
			JOptionPane.showConfirmDialog(this, "Enter Only Number", "Try Again.!!", JOptionPane.WARNING_MESSAGE);
		}
	}
	public static void main(String[] args) {
		GuessNumber gm=new GuessNumber();
		
		
	}

}

/* ----------------------------------------------------------------------
 * Coder:	Ian Bantoto
 * Date:	February 23, 2015
 * ----------------------------------------------------------------------
 * 							      Purpose
 * ---------------------------------------------------------------------
 * - Main interface for win/loss input
 * - Connects to all other parts of program (like a main screen)
 * ----------------------------------------------------------------------
 * 							       To Do
 * ----------------------------------------------------------------------
 * Implement ELO Formula from https://metinmediamath.wordpress.com/2013/11/27/how-to-calculate-the-elo-rating-including-example
 * ----------------------------------------------------------------------
 */

import java.awt.*;
import java.awt.event.*;
import java.io.IOException;

import javax.swing.*;

public class makeEdit extends JFrame implements ActionListener{
	
	private static final long serialVersionUID = 1L;
	
	JLabel nameLabel = new JLabel("Name: ");
	JLabel editLabel = new JLabel("Name/Score: ");
	
	TextField nameText = new TextField(5);
	TextField editText = new TextField(5);
	
	JButton editNameButton = new JButton("Edit Name");
	JButton editScoreButton = new JButton("Edit Score");
	
	public makeEdit ( String title ){
		super( title );
		
		JPanel pane = new JPanel(new GridBagLayout());
		GridBagConstraints c = new GridBagConstraints();
		
		c.weightx = 0.5;
		c.fill = GridBagConstraints.BOTH;
		c.insets = new Insets(15,15,0,0);
	    c.gridx = 0;
	    c.gridy = 0;
		pane.add(nameLabel, c);
		
		c.fill = GridBagConstraints.BOTH;
		c.insets = new Insets(15,15,0,0);
	    c.gridx = 1;
	    c.gridy = 0;
		pane.add(nameText, c);
		
		c.fill = GridBagConstraints.BOTH;
		c.gridx = 2;
	    c.gridy = 0;
		pane.add(editNameButton, c);
		
		c.weightx = 0.5;
		c.fill = GridBagConstraints.BOTH;
		c.insets = new Insets(15,15,0,0);
	    c.gridx = 0;
	    c.gridy = 1;
		pane.add(editLabel, c);
		
		c.fill = GridBagConstraints.BOTH;
		c.insets = new Insets(15,15,0,0);
	    c.gridx = 1;
	    c.gridy = 1;
		pane.add(editText, c);
		
		c.fill = GridBagConstraints.BOTH;
		c.insets = new Insets(15,15,0,0);
	    c.gridx = 2;
	    c.gridy = 1;
		pane.add(editScoreButton, c);
		
		add(pane);
		
		editNameButton.addActionListener(this);
		editScoreButton.addActionListener(this);
		
		setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
	}
	
	@Override
	public void actionPerformed( ActionEvent e){
		
		JButton button = (JButton)e.getSource();
		
		// Destroy and hide the JFrame object
		setVisible(false);
		dispose();
		
		if(button.equals(editNameButton)){
			try {
				EditData.editName(nameText.getText(),editText.getText());
			} catch (NumberFormatException | IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			// Destroy and hide the JFrame object
			setVisible(false);
			dispose();
		}else if(button.equals(editScoreButton)){
			try {
				EditData.editScore(nameText.getText(),Integer.parseInt(editText.getText()));
			} catch (NumberFormatException | IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			// Destroy and hide the JFrame object
			setVisible(false);
			dispose();
		}
		
		try {
			Interface.run();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}
	
	public static void main( String[] args ){
		run();
	}

	public static void run() {
		// TODO Auto-generated method stub
		makeEdit frame1  = new makeEdit( "Edit Entries" );
	    
   		frame1.setSize( 300, 200 );
    	frame1.setVisible(true);  
    	frame1.setResizable(false);
	}
}

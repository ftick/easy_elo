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

public class makeAdd extends JFrame implements ActionListener{
	
	private static final long serialVersionUID = 1L;
	
	JLabel nameLabel = new JLabel("Name: ");
	JLabel scoreLabel = new JLabel("Score: ");
	
	TextField nameText = new TextField(5);
	TextField scoreText = new TextField(5);
	
	JButton addButton = new JButton("Add");
	
	public makeAdd ( String title ){
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
		
		c.weightx = 0.5;
		c.fill = GridBagConstraints.BOTH;
		c.gridx = 0;
	    c.gridy = 1;
		pane.add(scoreLabel, c);
		
		c.fill = GridBagConstraints.BOTH;
		c.gridx = 1;
	    c.gridy = 1;
		pane.add(scoreText, c);
		
		c.fill = GridBagConstraints.BOTH;
		c.gridx = 2;
	    c.gridy = 1;
		pane.add(addButton, c);
		
		add(pane);
		
		addButton.addActionListener(this);
		
		setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
	}
	
	@Override
	public void actionPerformed( ActionEvent e) {
		
		JButton button = (JButton)e.getSource();
		
		if(button.equals(addButton)){
			try {
				EditData.addEntry(nameText.getText(),Integer.parseInt(scoreText.getText()));
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
		makeAdd frame1  = new makeAdd( "Add Entries" );
	    
   		frame1.setSize( 300, 200 );
    	frame1.setVisible(true);  
    	frame1.setResizable(false);
	}
}

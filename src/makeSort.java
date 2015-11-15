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

public class makeSort extends JFrame implements ActionListener{
	
	private static final long serialVersionUID = 1L;
	
	JButton alphaUpButton = new JButton("Alpha HI->LO");
	JButton alphaDownButton = new JButton("Alpha LO->HI");
	JButton eloUpButton = new JButton("Elo HI->LO");
	JButton eloDownButton = new JButton("Elo LO->HI");
	
	public makeSort ( String title ){
		super( title );
		
		JPanel pane = new JPanel(new GridBagLayout());
		GridBagConstraints c = new GridBagConstraints();
		
		c.weightx = 0.5;
		c.fill = GridBagConstraints.BOTH;
		c.insets = new Insets(15,15,0,0);
	    c.gridx = 0;
	    c.gridy = 0;
		pane.add(alphaUpButton, c);
		
		c.fill = GridBagConstraints.BOTH;
		c.insets = new Insets(15,15,0,0);
	    c.gridx = 1;
	    c.gridy = 0;
		pane.add(alphaDownButton, c);
		
		c.weightx = 0.5;
		c.fill = GridBagConstraints.BOTH;
		c.gridx = 0;
	    c.gridy = 1;
		pane.add(eloUpButton, c);
		
		c.fill = GridBagConstraints.BOTH;
		c.insets = new Insets(15,15,0,0);
	    c.gridx = 1;
	    c.gridy = 1;
		pane.add(eloDownButton, c);
		
		add(pane);
		
		alphaUpButton.addActionListener(this);
		alphaDownButton.addActionListener(this);
		eloUpButton.addActionListener(this);
		eloDownButton.addActionListener(this);
		
		setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
	}
	
	@Override
	public void actionPerformed( ActionEvent e){
		
		JButton button = (JButton)e.getSource();
		
		// Destroy and hide the JFrame object
		setVisible(false);
		dispose();
		
		if(button.equals(alphaUpButton)){
			try {
				EditData.alphaSort(">");
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} // Destroy and hide the JFrame object
			setVisible(false);
			dispose();
		} else if(button.equals(alphaDownButton)){
			try {
				EditData.alphaSort("<");
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} // Destroy and hide the JFrame object
			setVisible(false);
			dispose();
		} else if(button.equals(eloUpButton)){
			try {
				EditData.eloSort(">");
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} // Destroy and hide the JFrame object
			setVisible(false);
			dispose();
		} else if(button.equals(eloDownButton)){
			try {
				EditData.eloSort("<");
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} // Destroy and hide the JFrame object
			setVisible(false);
			dispose();
		}
		
		try {
			EditData.update();
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
		makeSort frame1  = new makeSort( "Sort Entries" );
	    
   		frame1.setSize( 300, 200 );
    	frame1.setVisible(true);  
    	frame1.setResizable(false);
	}
}

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

import javax.swing.*;

public class Interface extends JFrame implements ActionListener{
	
	private static final long serialVersionUID = 1L;
	
	JTextField entries = new JTextField();
	
	JButton addButton = new JButton("Add Entries");
	JButton removeButton = new JButton("Remove Entries");
	JButton editButton = new JButton("Edit Entries");
	JButton sortButton = new JButton("Sort Entries");
	
	public Interface ( String title ){
		super( title );
		
		JPanel pane = new JPanel(new GridBagLayout());
		GridBagConstraints c = new GridBagConstraints();
		
		c.weightx = 0.5;
		c.fill = GridBagConstraints.BOTH;
		c.insets = new Insets(15,15,0,0);
//	    c.gridx = 0;
	    c.gridy = 0;
		pane.add(entries, c);
		
		c.fill = GridBagConstraints.BOTH;
		c.insets = new Insets(10,10,0,10);
	    c.gridx = 0;
	    c.gridy = 1;
		pane.add(addButton, c);
		
		c.fill = GridBagConstraints.HORIZONTAL;
//		c.insets = new Insets(10,10,0,0);
	    c.gridx = 1;
	    c.gridy = 1;
		pane.add(editButton, c);
		
		c.fill = GridBagConstraints.HORIZONTAL;
//		c.insets = new Insets(10,10,0,0);
	    c.gridx = 2;
	    c.gridy = 1;
		pane.add(removeButton, c);
		
		c.fill = GridBagConstraints.BOTH;
//		c.insets = new Insets(10,10,0,10);
	    c.gridx = 3;
	    c.gridy = 1;
		pane.add(sortButton, c);
		
		add(pane);
		
		entries.setEditable(false);
		
		setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
	}
	
	@Override
	public void actionPerformed( ActionEvent e){
		
	}
	
	public static void main( String[] args ){
		Interface frame  = new Interface( "Home" );
	    
   		frame.setSize( 400, 300 );
    	frame.setVisible(true);  
    	frame.setResizable(false);
	}
}

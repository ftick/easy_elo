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

public class makeRemove extends JFrame implements ActionListener{
	
	private static final long serialVersionUID = 1L;
	
	JLabel nameLabel = new JLabel("Name: ");
	
	TextField nameText = new TextField(5);
	
	JButton removeButton = new JButton("Remove");
	
	public makeRemove ( String title ){
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
		pane.add(removeButton, c);
		
		add(pane);
		
		removeButton.addActionListener(this);
		
		setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
	}
	
	@Override
	public void actionPerformed( ActionEvent e){
		
		JButton button = (JButton)e.getSource();
		
		// Destroy and hide the JFrame object
		setVisible(false);
		dispose();
		
		if(button.equals(removeButton)){
			try {
				EditData.removeEntry(nameText.getText());
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
		makeRemove frame1  = new makeRemove( "Remove Entries" );
	    
   		frame1.setSize( 300, 200 );
    	frame1.setVisible(true);  
    	frame1.setResizable(false);
	}
}

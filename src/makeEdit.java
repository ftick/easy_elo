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
	
	
	
	public makeEdit ( String title ){
		super( title );
		
		JPanel pane = new JPanel(new GridBagLayout());
		GridBagConstraints c = new GridBagConstraints();
		
		setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
	}
	
	@Override
	public void actionPerformed( ActionEvent e){
		// Destroy and hide the JFrame object
		setVisible(false);
		dispose();
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

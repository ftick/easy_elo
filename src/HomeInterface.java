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

public class HomeInterface extends JFrame implements ActionListener{
	
	private static final long serialVersionUID = 1L;
	
	JButton editButton = new JButton("Edit Entries");
	JButton sortButton = new JButton("Sort Entries");
	
	public HomeInterface ( String title ){
		super( title );
		
		JPanel pane = new JPanel(new GridBagLayout());
		GridBagConstraints c = new GridBagConstraints();
		
		setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
	}
	
	@Override
	public void actionPerformed( ActionEvent e){
		
	}
	
	public static void main( String[] args ){
		HomeInterface frame  = new HomeInterface( "Home" );
	    
   		frame.setSize( 600, 400 );
    	frame.setVisible(true);  
    	frame.setResizable(false);
	}
}

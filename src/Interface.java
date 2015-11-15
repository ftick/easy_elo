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

public class Interface extends JFrame implements ActionListener{
	
	private static final long serialVersionUID = 1L;
	
	JLabel entryLabel = new JLabel("Entries");
	TextArea entryBox = new TextArea();
	
	JButton addButton = new JButton("Add Entries");
	JButton removeButton = new JButton("Remove Entries");
	JButton editButton = new JButton("Edit Entries");
	JButton sortButton = new JButton("Sort Entries");
	
	public Interface ( String title ) throws IOException{
		super( title );
		
		EditData.readFile();
		int entries = EditData.entryCount(EditData.fileName, "");
		Entry[] entryList = EditData.entriesAcc;
		
		if(entries==0)
			entryBox.setText(entryList[0].name + " " + entryList[0].score);
		
		int count = entries;
		if(entries > 1) count--;
		for(int i = 0; i < count; i++)
		{
			entryBox.setText(entryBox.getText() + "\n"
					+ entryList[i].name + "   " + entryList[i].score);
		}
		
		setLayout(new FlowLayout());
		
		add(entryLabel);
		add(entryBox);
		
		add(addButton);
		add(editButton);
		add(removeButton);
		add(sortButton);
		
		entryLabel.setFont(entryLabel.getFont().deriveFont(Font.BOLD, 32.0f));
		entryBox.setEditable(false);
		
		addButton.addActionListener(this);
		editButton.addActionListener(this);
		removeButton.addActionListener(this);
		sortButton.addActionListener(this);
		
		setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
	}
	
	@Override
	public void actionPerformed( ActionEvent evt){
		JButton button = (JButton)evt.getSource();
		
		// Destroy and hide the JFrame object
		setVisible(false);
		dispose();
		
		if(button.equals(addButton)){
			makeAdd.run();
		}else if(button.equals(editButton)){
			makeEdit.run();
		}else if(button.equals(removeButton)){
			makeRemove.run();
		}else if(button.equals(sortButton)){
			makeSort.run();
		}
	}
	
	public static void main( String[] args ) throws IOException{
		run();
	}
	
	public static void run() throws IOException{
		Interface frame  = new Interface( "Home" );
	    
   		frame.setSize( 475, 305 );
    	frame.setVisible(true);  
//    	frame.setResizable(false);
	}
}

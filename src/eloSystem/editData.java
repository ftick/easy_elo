package eloSystem;

/* ----------------------------------------------------------------------
 * Coder:	Ian Bantoto
 * Date:	November 15, 2014
 * ----------------------------------------------------------------------
 * 							      Purpose
 * ---------------------------------------------------------------------
 * - Add, edit, or delete entries in 'data.txt'
 * - Sort entries:  alphabetically  / reverse alphabetically
 * 			  and:  ELO low -> high / ELO high -> low
 * - Allow for both commmand and external use
 * ----------------------------------------------------------------------
 * 								External Use
 * ----------------------------------------------------------------------
 * First Use
 * 		1) Copy this java file over to preferred package
 * 		2) Copy "Entry.java" over to preferred package
 * 		3) Run reset method to generate new text file
 * 
 * Later Use
 * 		1) Run 'readFile() method'
 * 		2) Run any method you want
 * ----------------------------------------------------------------------
 */

import java.util.*;
import java.io.*;

public class editData
{
	
	static Scanner scan;
	static Entry[] entriesAcc;
	static String[] namesAcc;
	static String fileName = "data.txt";
	static String testName = "test.txt";
	static boolean done = false;
	static int[] scoresAcc;
	static int maxRow;
	
	public static void main(String[] args) throws IOException
	{
		readFile();
		while(!done)
		{
			select();
			
			if(!done) readFile();
			else break;
		}
	}
	
	public static void select() throws IOException
	{
		boolean inList;
		String name = "";
		int score = 0;
		
		switch(pick())
		{
			case 1:
				System.out.println("\nENTRIES\n");
				for(int i = 0; i < maxRow - 1; i++)
					System.out.println(entriesAcc[i].name);
				inList = true;
				while(inList)
				{
					System.out.print("\nName: ");
					name = scan.next();
					
					if(!contains(namesAcc, name))
					{
						inList = false;
						continue;
					}
					System.out.println("Entry already exists!");
				}
				
				System.out.print("ELO: ");
				score = scan.nextInt();
				
				addEntry(name, score);
				for(int i = 0; i < 30; i++) System.out.println();
				break;
				
			case 2:
				inList = false;
				System.out.println("\nENTRIES\n");
				for(int i = 0; i < maxRow - 1; i++)
					System.out.println(entriesAcc[i].name);
				while(!inList)
				{
					System.out.print("\nName: ");
					name = scan.next();
					
					if(contains(namesAcc, name))
					{
						inList = true;
						continue;
					}
					System.out.println("Entry doesn't exist!");
				}
				
				System.out.print("New name: ");
				String name2 = scan.next();
				
				editName(name, name2);
				for(int i = 0; i < 30; i++) System.out.println();
				break;
				
			case 3:
				inList = false;
				System.out.println("\nENTRIES\n");
				for(int i = 0; i < maxRow - 1; i++)
					System.out.println(entriesAcc[i].name);
				while(!inList)
				{
					System.out.print("\nName: ");
					name = scan.next();
					
					if(contains(namesAcc, name))
					{
						inList = true;
						continue;
					}
					System.out.println("Entry doesn't exist!");
				}
				
				System.out.print("ELO: ");
				score = scan.nextInt();
				
				editScore(name, score);
				for(int i = 0; i < 30; i++) System.out.println();
				break;
				
			case 4:
				inList = false;
				System.out.println("\nENTRIES\n");
				for(int i = 0; i < maxRow - 1; i++)
					System.out.println(entriesAcc[i].name);
				while(!inList)
				{
					System.out.print("\nName: ");
					name = scan.next();
					
					if(contains(namesAcc, name))
					{
						inList = true;
						continue;
					}
					System.out.println("Entry doesn't exist!");
				}
				
				removeEntry(name);
				for(int i = 0; i < 30; i++) System.out.println();
				break;
			
			case 5:
				alphaSort("<");
				System.out.println("\nENTRIES\n");
				for(int i = 0; i < maxRow - 1; i++)
					System.out.println(entriesAcc[i].name);
				update();
				break;
				
			case 6:
				alphaSort(">");
				System.out.println("\nENTRIES\n");
				for(int i = 0; i < maxRow - 1; i++)
					System.out.println(entriesAcc[i].name);
				update();
				break;
			
			case 7:
				eloSort(">");
				System.out.println("\nENTRIES\n");
				for(int i = 0; i < maxRow - 1; i++)
					System.out.println(entriesAcc[i].name);
				update();
				break;
			
			case 8:
				eloSort("<");
				System.out.println("\nENTRIES\n");
				for(int i = 0; i < maxRow - 1; i++)
					System.out.println(entriesAcc[i].name);
				update();
				break;
				
			case 9:
				done = true;
				break;
				
			case 0:
				break;
				
			default:
				System.out.println("Invalid response");
				break;
		}
	}
	
	public static boolean contains(final String[] array, final String key)
	{
        for (final String x : array)
        {
            if (x.toLowerCase().equals(key.toLowerCase())) return true;
        }
        return false;
    }
	
	public static int findKey(int[] array, final int key)
	{
		int result = 0;
        for (int x = 0; x < array.length; x++) {
            if (array[x] == key) result = x;
        }
        return result;
    }
	
	public static int pick()
	{
		scan = new Scanner(System.in);
		
		System.out.println("OPTIONS\n");
		
		System.out.println("1) Add new entry");
		System.out.println("2) Edit name of existing entry");
		System.out.println("3) Edit score of existing entry");
		System.out.println("4) Delete existing entry");
		System.out.println("5) Sort entries by name alphabetically");
		System.out.println("6) Sort entries by name reverse alpabetically");
		System.out.println("7) Sort entries by ELO (high -> low)");
		System.out.println("8) Sort entries by ELO (low -> high)");
		System.out.println("9) Quit");
		System.out.println("0) Reset all data");
		
		System.out.print("\nSelection: ");
		
		return scan.nextInt();
	}
	
	public static int entryCount( String file ) throws IOException
	{
		// Declare variables
		BufferedReader count;
		String text;
		int maxRow;
		
		// Add things from file to scores
		count = new BufferedReader(new FileReader( file ));
		text = count.readLine();
		maxRow = 0;
		
		// Find number of rows
		while(count.ready())
		{
			try
			{
				Integer.parseInt(text);
			}
			catch (NumberFormatException e)
			{
				maxRow++;
			}
			// Set text to next line
			text = count.readLine();
		}
		
		count.close();
		System.out.println("\n" + maxRow + " Entries in file\n");
		return maxRow + 1;
	}
	
	public static int getInt( String text ) 
	{
		String resultStr;
		
		resultStr = text.substring(text.indexOf(" ") + 1);
		return Integer.parseInt(resultStr);
	}
	
	public static String getStr( String text ) 
	{
		String result;
		result = text.substring(0, text.indexOf(" "));
		return result;
	}
	
	public static void readFile() throws IOException
	{
		// Declare variables
		BufferedReader file;
		String[] names;
		String text;
		String name;
		int[] scores;
		int row;
		int score;
		
		// Add things from file to scores
		file = new BufferedReader(new FileReader( fileName ));
		text = file.readLine();
		
		// Find number of entries
		maxRow = entryCount( fileName );
		
		// Create arrays with appropriate size
		names = new String[ maxRow ];
		scores = new int[ maxRow ];
		
		namesAcc = new String[ maxRow - 1 ];
		scoresAcc = new int[ maxRow - 1 ];
		entriesAcc = new Entry[ maxRow - 1];
		
		for(row = 2; row <= maxRow + 1; row++)
		{
			name = getStr(text);
			score = getInt(text);
			
			names[row-2] = name;
			scores[row-2] = score;
			
			text = file.readLine();
		}
		
		file.close();
		
		for(int i = 1; i < maxRow; i++)
		{
			names[i-1] = names[i];
			scores[i-1] = scores[i];
		}
		
		for(int x = 0; x < maxRow - 1; x++)
		{
			namesAcc[x] = names[x];
			scoresAcc[x] = scores[x];
			entriesAcc[x] = new Entry(namesAcc[x], scoresAcc[x]);
		}
	}
	
	public static void addEntry( String name, int score ) throws IOException
	{
		PrintWriter file;
		file = new PrintWriter(new FileWriter( fileName ));
		
		file.println("NAME 0");
		
		for(int s = 0; s < maxRow - 1; s++)
			file.println(entriesAcc[s].name + " " + entriesAcc[s].score);
		
		file.println(name + " " + score);
		file.close();
	}
	
	public static void editName( String name, String name2 ) throws IOException
	{
		PrintWriter file;
		file = new PrintWriter(new FileWriter( fileName ));
		
		file.println("NAME 0");
		
		for(int s = 0; s < maxRow - 1; s++)
		{
			if(!name.toLowerCase().equals(namesAcc[s].toLowerCase()))
				file.println(entriesAcc[s].name + " " + entriesAcc[s].score);
			else
				file.println(name2 + " " + entriesAcc[s].score);
		}
		file.close();
	}
	
	public static void editScore( String name, int score ) throws IOException
	{
		PrintWriter file;
		file = new PrintWriter(new FileWriter( fileName ));
		
		file.println("NAME 0");
		
		for(int s = 0; s < maxRow - 1; s++)
		{
			if(!name.toLowerCase().equals(namesAcc[s].toLowerCase()))
				file.println(entriesAcc[s].name + " " + entriesAcc[s].score);
			else
				file.println(entriesAcc[s].name + " " + score);
		}
		file.close();
	}
	
	public static void removeEntry( String name ) throws IOException
	{
		PrintWriter file;
		file = new PrintWriter(new FileWriter( fileName ));
		
		file.println("NAME 0");
		
		for(int s = 0; s < maxRow - 1; s++)
		{
			if(!name.toLowerCase().equals(entriesAcc[s].name.toLowerCase()))
				file.println(entriesAcc[s].name + " " + entriesAcc[s].score);
		}
		file.close();
	}
	
	public static void alphaSort( String s ) throws IOException
	{
		for (int i = 0; i < entriesAcc.length - 1; i++)
        {
            int index = i;
            if(s == "<")
            	for (int j = i + 1; j < entriesAcc.length; j++)
            		if ((int)(entriesAcc[j].name.charAt(0)) < (int)(entriesAcc[index].name.charAt(0))) 
            			index = j;
            if(s == ">")
            	for (int j = i + 1; j < entriesAcc.length; j++)
            		if ((int)(entriesAcc[j].name.charAt(0)) > (int)(entriesAcc[index].name.charAt(0))) 
            			index = j;
      
            String diffString = entriesAcc[index].name;  
            int diffNumber = entriesAcc[index].score;
            entriesAcc[index].score = entriesAcc[i].score;
            entriesAcc[index].name = entriesAcc[i].name;
            entriesAcc[i].score = diffNumber;
            entriesAcc[i].name = diffString;
        }
	}
	
	public static void eloSort( String s ) throws IOException
	{
		for (int i = 0; i < entriesAcc.length - 1; i++)
        {
            int index = i;
            if(s == "<")
            	for (int j = i + 1; j < entriesAcc.length; j++)
            		if (entriesAcc[j].score < entriesAcc[index].score) 
            			index = j;
            if(s == ">")
            	for (int j = i + 1; j < entriesAcc.length; j++)
                	if (entriesAcc[j].score > entriesAcc[index].score) 
                        index = j;
      
            String diffString = entriesAcc[index].name;  
            int diffNumber = entriesAcc[index].score;
            entriesAcc[index].score = entriesAcc[i].score;
            entriesAcc[index].name = entriesAcc[i].name;
            entriesAcc[i].score = diffNumber;
            entriesAcc[i].name = diffString;
        }
	}
	
	public static void update() throws IOException 
	{
		PrintWriter file;
		file = new PrintWriter(new FileWriter( fileName ));
		
		file.println("NAME 0");
		
		for(int s = 0; s < maxRow - 1; s++) 
			file.println(entriesAcc[s].name + " " + entriesAcc[s].score);
		
		file.close();
	}
	
	public static void reset() throws IOException
	{
		PrintWriter file;
		file = new PrintWriter(new FileWriter( fileName ));
		
		file.println("NAME 0");
		
		file.close();
	}
	
}
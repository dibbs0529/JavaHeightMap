import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

public class HeightMap {

	public static void main(String[] args) throws FileNotFoundException, IOException  {
		// TODO Auto-generated method stub

		/**
		 * Make a program that calls a height map data sheet
		 * That allows you to read, modify, clear, display, save and quit.
		 * 
		 * ****************************************************************
		 * Author: Kody Dibble Title: Terrain Builder 1.0x
		 * Date: 9/13/2016
		 * ****************************************************************
		 * 
		 */
		
		
		
		
		// Class to display various menu options and data.
		
		
			
			
			
		//Variables for height map, file, ROWS, COLS, NewHeight  rows and cols.
			
		HMapData Hmap = new HMapData();
		int[][] OriginalHeightMap = Hmap.Displaymap();
		int[][] HeightMap = Hmap.Displaymap();
		int Height;
		int DHeight;
		int Point;
		final int ROWS = 20;
		final int COLS = 22;
		
		
		
		int NewHeight;
		String Option;
		int row1, col1;
	
		Scanner keyboard = new Scanner(System.in);
		System.out.println("Welcome to terrian builder 1.0x: Please press enter. ");
		Option = keyboard.nextLine();
		String filename = "map.dat";
		File file = new File(filename);
		Scanner infile = new Scanner(file);
		
		//While not equals to Quit
		while (!Option.equals("Quit")){
		
			System.out.println("What Option do you want to execute?: (Read, Display, Modify, Clear, Save, Quit)  ");
			Option = keyboard.nextLine();
			
		if (Option.equals("Display")){
			
			for (int row = 0; row < ROWS; row++){
				
				for(int col = 0; col < COLS; col++){
					
					
					System.out.print(HeightMap[row][col]);
				}
				System.out.println();
			}
			
		}
		
		/***
		 * 
		 * Modify the map.
		 */
		else if (Option.equals("Modify")){
			
			System.out.println("Enter position 1: ");
			row1 = keyboard.nextInt();
			
			System.out.println("Enter position 2: ");
			col1 = keyboard.nextInt();
			
			System.out.println("Enter height. ");
			DHeight = keyboard.nextInt();
			keyboard.nextLine();
			
			for(int r = 0; r < HeightMap.length; r++ ){
				
				for(int c = 0; c < HeightMap[r].length; c++){
					int distance = (int)Math.sqrt((r - row1)*(r - row1) + (c - col1)*(c - col1));
					if(DHeight - distance >= HeightMap[r][c])
						HeightMap[r][c] += DHeight - distance;
						System.out.print(HeightMap[r][c]);

						
				}
				
				System.out.println();
				
				
			}	
				
			
			//For every point within circle calc distance. For every x and y
			
		}
		
		/***
		 * 
		 * Reset the map.
		 */
		else if(Option.equals("Clear")){
			
			System.out.println("Clearing map to original.");
			for(int row = 0; row < ROWS; row++){
				
				for(int col =0; col < COLS; col++){
				
					HeightMap[row][col] = OriginalHeightMap[row][col];
				}
			}
			}
			
		//Save the map.
		else if(Option.equals("Save")){
			
			System.out.println("Saved to File.");
			Hmap.SaveData(HeightMap, filename);
			
			
			
		}
		/**
		 * Read the map.
		 * 
		 */
		else if(Option.equals("Read")){
		
			Hmap.ReadData();
			System.out.print("File has been read, please choose another option.");
		}
		
		/***
		 * 
		 * Quit the builder.
		 */
		if(Option.equals("Quit")){
			
			System.out.print("Thanks for using Terrain builder 1.0x ENJOY!");
			System.exit(0);
		}
			
		}
	
		
		}
}
	

		
	




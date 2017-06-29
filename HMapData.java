import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class HMapData {

	final int ROWS = 20;
	final int COLS = 22;
	int[][] ReadMap;

	/**
	 * 
	 * Display map and the data
	 * 
	 */

	public int[][] Displaymap() throws FileNotFoundException {

		// Variables for H map, file, counter etc..
		int[][] hmap = new int[20][22];
		String filename = "map.dat";
		File file = new File(filename);
		Scanner infile = new Scanner(file);
		String mapdata;
		int rowcount = 0;

		infile.nextLine();

		// Call each line in the file.
		while (infile.hasNextLine()) {

			// Save data from file to a String.
			mapdata = infile.nextLine();

			// Check for white lines.
			if (mapdata.length() > 0) {

				// Get the length of the string and add the data to a 2d array
				for (int i = 0, c = 0; i < mapdata.length(); i = i + 2, c++) {

					hmap[rowcount][c] = Character.getNumericValue(mapdata.charAt(i));

				}
				rowcount++;
			}

			
		}

		return hmap;
		

	}

	/**
	 * Method to save the data of the map.
	 * 
	 */
	
	
	public void SaveData(int[][] array, String filename) throws IOException {

		FileWriter writer = new FileWriter(filename, false);

		PrintWriter printwriter = new PrintWriter(writer);

		for (int row = 0; row < ROWS; row++) {

			for (int col = 0; col < COLS; col++) {

				printwriter.print((array[row][col]));
			}
			printwriter.println();
		}
		printwriter.close();
	}

	/**
	 * Method to read the data.
	 */
	
	public void ReadData() throws FileNotFoundException {

		int[][] hmap = new int[20][22];
		String filename = "map.dat";
		File file = new File(filename);
		Scanner infile = new Scanner(file);
		String mapdata;
		int rowcount = 0;

		infile.nextLine();

		// Call each line in the file.
		while (infile.hasNextLine()) {

			// Save data from file to a String.
			mapdata = infile.nextLine();

			// Check for white lines.
			if (mapdata.length() > 0) {

				// Get the length of the string and add the data to a 2d array
				for (int i = 0, c = 0; i < mapdata.length(); i = i + 2, c++) {

					hmap[rowcount][c] = Character.getNumericValue(mapdata.charAt(i));

				}
				rowcount++;
			}

			hmap = ReadMap;
		}
		infile.close();
	}


	

}

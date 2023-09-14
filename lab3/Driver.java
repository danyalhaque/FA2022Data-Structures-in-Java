package lab3;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

public class Driver {

	public static void main(String[] args) {

		Billboard100 billBoard = new Billboard100();

		File myFile = new File("hot.stuff.2018.csv");
		Scanner userinput = new Scanner(System.in);
		Scanner fileRead;

		try {
			fileRead = new Scanner(myFile);
			fileRead.nextLine();

			while (fileRead.hasNext()) {
				String[] strArray = (fileRead.nextLine().split(",(?=(?:[^\"]*\"[^\"]*\")*[^\"]*$)", -1));
				billBoard.addSong(constructSong(strArray));
			}

		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		File commandFile = new File("commands.txt");
		Scanner commandsScanner;
		int commandVariable;

		// Creates an output file and while commands.txt has inputs still, the loop will
		// run, read each command, and switch statements will activate accordingly
		try {

			PrintWriter pw = new PrintWriter("output");
			commandsScanner = new Scanner(commandFile);
			while (commandsScanner.hasNext()) {

				switch (commandVariable = commandsScanner.nextInt()) {

				case 1: {
					pw.println("***** PRINT ALL ******");
					pw.printf("%-52s| %-10s | %-52s | %-94s | %-99s | %-1s | %-2s | %-2s | %n", "URL", "Week", "Song",
							"Performer", "SongID", "Instance", "Peak Postition", "Weeks On Chart");
					billBoard.printAll(pw);
					pw.printf("%n%n%n%n%n");
					break;
				}
				case 2: {
					pw.println("***** PRINT ALL OVER 12 WEEKS ******");
					pw.printf("%-52s| %-10s | %-52s | %-94s | %-99s | %-1s | %-2s | %-2s | %n", "URL", "Week", "Song",
							"Performer", "SongID", "Instance", "Peak Postition", "Weeks On Chart");
					billBoard.printAllOver12Weeks(pw);
					pw.printf("%n%n%n%n%n");
					break;

				}
				case 3: {

					int month = commandsScanner.nextInt();
					int day = commandsScanner.nextInt();
					int year = commandsScanner.nextInt();
					pw.printf("***** PRINT ALL FROM A %d/%d/%d ******%n", month, day, year);
					pw.printf("%-52s| %-10s | %-52s | %-94s | %-99s | %-1s | %-2s | %-2s | %n", "URL", "Week", "Song",
							"Performer", "SongID", "Instance", "Peak Postition", "Weeks On Chart");
					billBoard.printAllDateOrder(pw);
					pw.printf("%n%n%n%n%n");
					break;

				}
				case 4: {

					String performerName = commandsScanner.nextLine();
					performerName = performerName.substring(1);
					pw.printf("***** PRINT ALL PERFORMED BY %S ******%n", performerName);
					pw.printf("%-52s| %-10s | %-52s | %-94s | %-99s | %-1s | %-2s | %-2s | %n", "URL", "Week", "Song",
							"Performer", "SongID", "Instance", "Peak Postition", "Weeks On Chart");
					billBoard.printPerformedBy(pw, performerName);
					pw.printf("%n%n%n%n%n");
					break;

				}
				case 5: {
					String songName = commandsScanner.nextLine();
					songName = songName.substring(1);
					pw.printf("***** PRINT ALL SONGS WITH NAME %S ******%n", songName);
					pw.printf("%-52s| %-10s | %-52s | %-94s | %-99s | %-1s | %-2s | %-2s | %n", "URL", "Week", "Song",
							"Performer", "SongID", "Instance", "Peak Postition", "Weeks On Chart");
					billBoard.printBySongName(pw, songName);
					pw.printf("%n%n%n%n%n");
					break;
				}
				case 6: {
					pw.println("***** PRINT ALL BY PEAK POSITION ONE ******");
					pw.printf("%-52s| %-10s | %-52s | %-94s | %-99s | %-1s | %-2s | %-2s | %n", "URL", "Week", "Song",
							"Performer", "SongID", "Instance", "Peak Postition", "Weeks On Chart");
					billBoard.printByPeakPostionOfOne(pw);
					pw.printf("%n%n%n%n%n");
					break;

				}
				case 7: {
					pw.println("***** PRINT ALL DATE ORDERED ******");
					pw.printf("%-52s| %-10s | %-52s | %-94s | %-99s | %-1s | %-2s | %-2s | %n", "URL", "Week", "Song",
							"Performer", "SongID", "Instance", "Peak Postition", "Weeks On Chart");
					billBoard.printAllDateOrder(pw);
					pw.printf("%n%n%n%n%n");
					break;

				}
				case 8: {
					pw.println("***** PRINT ALL SONG NAME ORDERED ******");
					pw.printf("%-52s| %-10s | %-52s | %-94s | %-99s | %-1s | %-2s | %-2s | %n", "URL", "Week", "Song",
							"Performer", "SongID", "Instance", "Peak Postition", "Weeks On Chart");
					billBoard.printAllSongNameOrder(pw);
					pw.printf("%n%n%n%n%n");
					break;
				}
				case 9: {
					pw.println("***** PRINT ALL PERFORMER NAME ORDERED ******");
					pw.printf("%-52s| %-10s | %-52s | %-94s | %-99s | %-1s | %-2s | %-2s | %n", "URL", "Week", "Song",
							"Performer", "SongID", "Instance", "Peak Postition", "Weeks On Chart");
					billBoard.printAllPerformerNameOrder(pw);
					pw.printf("%n%n%n%n%n");
					break;
				}

				}

			}
			pw.close();
			System.out.println("Output stored in output file.");

		} catch (FileNotFoundException e) {

			e.printStackTrace();
		}

	}

	// Read one array spot at a time in order for song fields, then construct new
	// song object, then add to list in Billboard100
	public static Song constructSong(String[] strArray) {

		String url = strArray[0];
		Date weekId = new Date(strArray[1]);
		String songName = strArray[2];
		String performerName = strArray[3];
		String songID = strArray[4];
		int instance = Integer.parseInt(strArray[5]);
		int peakPosition = Integer.parseInt(strArray[6]);
		int weeksOnChart = Integer.parseInt(strArray[7]);
		Song song = new Song(url, weekId, songName, performerName, songID, instance, peakPosition, weeksOnChart);
//		System.out.println(song);
		return song;

	}

}

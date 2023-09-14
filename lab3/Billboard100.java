package lab3;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Iterator;
import java.util.Scanner;

public class Billboard100 {

	private SortedArrayCollection<Song> collection = new SortedArrayCollection<Song>();

	public void addSong(Song song) {

		collection.add(song);
//		System.out.println(collection.numElements);
//		System.out.println(collection.get(song));
	}

	// Uses a printwriter to print all the songs line by line to a text file named
	// "printAll"
	public void printAll(PrintWriter pw) throws FileNotFoundException {
		// PrintWriter pw = new PrintWriter("printAll");

		Iterator<Song> iter = collection.iterator();
		while (iter.hasNext()) {
			pw.println(iter.next());

		}

	}

	public void printAllOver12Weeks(PrintWriter pw) {
		Song temp = new Song();
		Iterator<Song> iter = collection.iterator();
		while (iter.hasNext()) {
			temp = (Song) iter.next();
			
			if (temp.olderThan12Weeks(temp)) {
				pw.println(temp);
			}

		}

	}

	public void printAllFromAWeek(PrintWriter pw, int month, int day, int year) {

		Song temp = new Song();
		Date date = new Date(month, day, year);
		Iterator<Song> iter = collection.iterator();
		while (iter.hasNext()) {
			temp = (Song) iter.next();
			
			if (date.equals(temp.getWeekId())) {
				pw.println(temp);
			}

		}

	}

	public void printPerformedBy(PrintWriter pw, String performerName) {

		Song temp = new Song();
		Iterator<Song> iter = collection.iterator();
		while (iter.hasNext()) {
			temp = (Song) iter.next();

			if (temp.performedBy(performerName)) {
				pw.println(temp);
			}

		}

	}

	public void printBySongName(PrintWriter pw, String songName) {
		
		Song temp = new Song();
		Iterator<Song> iter = collection.iterator();
		while (iter.hasNext()) {
			temp = (Song) iter.next();

			if (temp.songIsNamed(songName)) {
				pw.println(temp);
			}

		}

	}

	public void printByInstanceGreaterThanOne(PrintWriter pw) {

		Song temp = new Song();
		Iterator<Song> iter = collection.iterator();
		while (iter.hasNext()) {
			temp = (Song) iter.next();

			if (temp.instanceGreaterThanOne(temp)) {
				pw.println(temp);
			}

		}

	}

	public void printByPeakPostionOfOne(PrintWriter pw) {

		Song temp = new Song();
		Iterator<Song> iter = collection.iterator();
		while (iter.hasNext()) {
			temp = (Song) iter.next();

			if (temp.peakPostionOne(temp)) {
				pw.println(temp);
			}

		}

	}

	public void printAllDateOrder(PrintWriter pw) {

		SortedArrayCollection<Song> dateOrderCollection = new SortedArrayCollection<Song>(Song.dateComparator());
		Iterator<Song> iter = collection.iterator();
		while (iter.hasNext()) {
			dateOrderCollection.add(iter.next());
		}

		Iterator<Song> dateIter = dateOrderCollection.iterator();
		while (dateIter.hasNext()) {
			pw.println(dateIter.next());

		}

	}

	public void printAllSongNameOrder(PrintWriter pw) {

		SortedArrayCollection<Song> songNameOrderCollection = new SortedArrayCollection<Song>(
				Song.songNameComparator());
		Iterator<Song> iter = collection.iterator();
		while (iter.hasNext()) {
			songNameOrderCollection.add(iter.next());
		}

		Iterator<Song> songNameIter = songNameOrderCollection.iterator();
		while (songNameIter.hasNext()) {
			pw.println(songNameIter.next());

		}

	}

	public void printAllPerformerNameOrder(PrintWriter pw) {

		SortedArrayCollection<Song> performerNameOrderCollection = new SortedArrayCollection<Song>(
				Song.performerNameComparator());
		Iterator<Song> iter = collection.iterator();
		while (iter.hasNext()) {
			performerNameOrderCollection.add(iter.next());
		}

		Iterator<Song> performerNameIter = performerNameOrderCollection.iterator();
		while (performerNameIter.hasNext()) {
			pw.println(performerNameIter.next());

		}

	}
}
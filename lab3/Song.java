package lab3;

import java.util.Comparator;

import collectionExample.Person;

public class Song implements Comparable {

	private String url;
	private Date weekId;
	private String songName;
	private String performerName;
	private String songID;
	private int instance;
	private int peakPosition;
	private int weeksOnChart;

	public Song() {

	}

	public Song(String url, Date weekId, String songName, String performerName, String songID, int instance,
			int peakPosition, int weeksOnChart) {

		this.url = url;
		this.weekId = weekId;
		this.songName = songName;
		this.performerName = performerName;
		this.songID = songID;
		this.instance = instance;
		this.peakPosition = peakPosition;
		this.weeksOnChart = weeksOnChart;

	}

	public Date getWeekId() {
		return weekId;
	}

	// Return true if the song is older than 12 weeks on chart
	public boolean olderThan12Weeks(Object obj) {
		Song song;
		if (obj == null) {
			return false;
		} else {
			song = (Song) obj;
			if (song.weeksOnChart > 12) {
				return true;
			}
		}

		return false;

	}
	// Return true if the parameter is equal to the performer name
	public boolean performedBy(String performerName) {

		String tempThisPerformerName = this.performerName.toLowerCase();
		String tempPerformerName = performerName.toLowerCase();
		
		if (tempThisPerformerName.indexOf(tempPerformerName) != -1) {
			
			return true;
		}

		return false;
	}

	// Returns true if the song name is equal to the parameter, ignoring upper cases
	public boolean songIsNamed(String songName) {

		if (songName.equalsIgnoreCase(this.songName)) {
			return true;
		}

		return false;
	}

	// Return true if the instance of the song is greater than one
	public boolean instanceGreaterThanOne(Object obj) {
		Song song;
		if (obj == null) {
			return false;
		}
			song = (Song) obj;
			if (song.instance > 1) {
				return true;
			}
		
		return false;
	}
	
	// Return true if the peak position of the song is one
	public boolean peakPostionOne(Object obj) {
		Song song;
		if (obj == null) {
			return false;
		}
			song = (Song) obj;
			if (song.peakPosition == 1) {
				return true;
			}
		
		return false;
	}

	// Check if two songs are equal through songID
	public boolean equals(Object obj) {
		Song song;
		if (obj == null) {
			return false;
		}
		song = (Song) obj;
		if (song.songID.equals(this.songID)) {
			return true;
		}
		return false;

	}

	// Compare two songs using the SongID
	public int compareTo(Object obj) {

		// typecast o to instance of type Song
		Song song;
		song = (Song) obj;
		if (song.songID.compareTo(this.songID) == 0) {
			return 0;
		}

		if (song.songID.compareTo(this.songID) > 0) {
			return -1;
		}

		if (song.songID.compareTo(this.songID) < 0) {
			return 1;
		}

		return 0;
	}
	
	public static Comparator<Song> dateComparator(){
		return new Comparator<Song>() {
			public int compare(Song s1, Song s2) {
				return s1.weekId.compareTo(s2.weekId);
			}
		};
	}
	
	public static Comparator<Song> songNameComparator(){
		return new Comparator<Song>() {
			public int compare(Song s1, Song s2) {
				return s1.songName.compareTo(s2.songName);
			}
		};
	}
	
	public static Comparator<Song> performerNameComparator(){
		return new Comparator<Song>() {
			public int compare(Song s1, Song s2) {
				return s1.performerName.compareTo(s2.performerName);
			}
		};
	}
	
	
	public String toString() {
		return String.format("%s| %-11s| %-53s| %-95s| %-100s| %-9d| %-15d| %-15d|", url+",", weekId+",", songName+",", performerName+",", songID+",", instance, peakPosition, weeksOnChart);

	}

}

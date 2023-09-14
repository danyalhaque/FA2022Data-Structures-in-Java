package lab3;

public class Date implements Comparable {

	private int month;
	private int day;
	private int year;

	public Date() {

	}

	public Date(int month, int day, int year) {

		this.month = month;
		this.day = day;
		this.year = year;

	}

	public Date(String fullDate) {
		String[] dateArray = fullDate.split("/");
		int month = Integer.parseInt(dateArray[0]);
		int day = Integer.parseInt(dateArray[1]);
		int year = Integer.parseInt(dateArray[2]);

		this.month = month;
		this.day = day;
		this.year = year;

	}

	public String toString() {

		return month + "/" + day + "/" + year;

	}

	public boolean equals(Object obj) {
		Date date;
		if (obj == null) {
			return false;
		}
		date = (Date) obj;
		if (date.year == this.year && date.month == this.month && date.day == this.day) {
			return true;
		}
		return false;

	}

	public int compareTo(Object obj) {
		Date date;
		date = (Date) obj;

		if (date.year > this.year) {
			return 1;
		} else if (date.year < this.year) {
			return -1;
		}

		if (date.month > this.month) {
			return 1;
		} else if (date.month < this.month) {
			return -1;
		}

		if (date.day > this.day) {
			return 1;
		} else if (date.day < this.day) {
			return -1;
		}

		return 0;
	}

}

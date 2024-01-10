
public class Calendar {	
    // Starting the calendar on 1/1/1900
	static int dayOfMonth = 1;   
	static int month = 1;
	static int year = 1900;
	static int dayOfWeek = 2;     // 1.1.1900 was a Monday
	static int nDaysInMonth = 31; // Number of days in January
	
	/** 
	 * Prints the calendar of the given year.
	 */
	public static void main(String args[]) {
		int calendarYear = Integer.parseInt(args[0]);
		String sunday = "";
	 	while (year <= calendarYear) {
            if (year == calendarYear) {
                sunday = (dayOfWeek == 1) ? " Sunday" : "";
                System.out.println(dayOfMonth + "/" + month + "/" + year + sunday);
            }
	 		advance();
        }
	 }
	 // Advances the date (day, month, year) and the day-of-the-week.
	 // If the month changes, sets the number of days in this month.
	 // Side effects: changes the static variables dayOfMonth, month, year, dayOfWeek, nDaysInMonth.
	 private static void advance() {
		dayOfMonth++;
		dayOfWeek++;
		if (dayOfMonth > nDaysInMonth(month, year)) {
			dayOfMonth = 1;
			month++;
		}
		if (month > 12) {
			month = 1;
			year++;
		}
		if (dayOfWeek > 7) {
			dayOfWeek = 1;
		}
	 } 
		 
    // Returns true if the given year is a leap year, false otherwise.
	private static boolean isLeapYear(int year) {
	    boolean isLeap = false;
		if (year % 400 == 0) {
			isLeap = true;
		} else if (year % 100 == 0) {
			isLeap = false;
		} else if (year % 4 == 0) {
			isLeap = true;
		}
		return isLeap;
	}
	 
	// Returns the number of days in the given month and year.
	// April, June, September, and November have 30 days each.
	// February has 28 days in a common year, and 29 days in a leap year.
	// All the other months have 31 days.
	private static int nDaysInMonth(int month, int year) {
		switch (month) {
			case 4:
			case 6:
			case 9:
			case 11:
				return 30;
			case 2:
				if (isLeapYear(year)) {
					return 29;
				} else {
					return 28;
				}
			default:
				return 31;
		}
	}
}

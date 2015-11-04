package it.lucchesi.tools.DateTools;

import java.util.Calendar;

import org.joda.time.DateTimeConstants;
import org.joda.time.Days;
import org.joda.time.LocalDate;

import com.google.common.base.Preconditions;

/**
 * Generic date utilities
 *
 */
public class DateTools {

	/**
	 * @see http://stackoverflow.com/questions/4600034/calculate-number-of-weekdays-between-two-dates-in-java
	 * 
	 * @param start starting date
	 * @param end ending date
	 * 
	 * @return the number of weekdays in the specified period (number of days which aren't Saturday or Sunday)
	 */
	public static long weekdays(LocalDate start, LocalDate end) {
		Preconditions.checkArgument(Preconditions.checkNotNull(start)
				.compareTo(Preconditions.checkNotNull(end)) <= 0);
		
		int w1 = start.getDayOfWeek() == DateTimeConstants.SUNDAY ? 1 : start.getDayOfWeek() + 1;
		int w2 = end.getDayOfWeek() == DateTimeConstants.SUNDAY ? 1 : end.getDayOfWeek() + 1;
		
		// Take back the dates to the closer previous Sunday
		LocalDate d1 = start.plusDays(-w1 + 1);
		LocalDate d2 = end.plusDays(-w2 + 1);
		
		int days = Days.daysBetween(d1, d2.plusDays(1)).getDays();
		long daysWithoutWeekDays = days-(days*2/7);
		
	    // Adjust days to add on (w2) and days to subtract (w1) so that Saturday
	    // and Sunday are not included
	    if (w1 == Calendar.SUNDAY) {
	    	w1 = Calendar.MONDAY;
	    }

	    if(w2 == Calendar.SATURDAY) {
	    	w2 = Calendar.FRIDAY;
	    }
	    
	    return  daysWithoutWeekDays -w1 + w2;
	}
}

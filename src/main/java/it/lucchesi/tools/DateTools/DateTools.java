package it.lucchesi.tools.DateTools;

import java.util.Calendar;
import java.util.Date;

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
	
	/**
	 * Number of weekdays in the specified period (number of days which aren't Saturday or Sunday).
	 * It includes the last day of the interval, i.e. if today is a weekday -> days(new Date(), new Date()) == 1;
	 * 
	 * @see http://stackoverflow.com/questions/4600034/calculate-number-of-weekdays-between-two-dates-in-java
	 * 
	 * @param start starting date
	 * @param end ending date
	 * 
	 * @return the number of weekdays in the specified period (number of days which aren't Saturday or Sunday)
	 */
	public static long days(Date start, Date end){
	    //Ignore argument check

	    Calendar c1 = Calendar.getInstance();
	    c1.setTime(start);
	    int w1 = c1.get(Calendar.DAY_OF_WEEK);
	    c1.add(Calendar.DAY_OF_WEEK, -w1);
	    
	    Calendar c2 = Calendar.getInstance();
	    c2.setTime(end);
	    int w2 = c2.get(Calendar.DAY_OF_WEEK);
	    c2.add(Calendar.DAY_OF_WEEK, -w2);

	    //end Saturday to start Saturday 
	    long days = (c2.getTimeInMillis()-c1.getTimeInMillis())/(1000*60*60*24);
	    long daysWithoutWeekendDays = days-(days*2/7);

	    // Adjust days to add on (w2) and days to subtract (w1) so that Saturday
	    // and Sunday are not included   
	    if (w1 == Calendar.SUNDAY) {
	    		w1 = Calendar.MONDAY;
	    }

	    if(w2 == Calendar.SATURDAY) {
	    	w2 = Calendar.FRIDAY;
	    }

	    return daysWithoutWeekendDays - w1 + w2 + 1;
	}
}

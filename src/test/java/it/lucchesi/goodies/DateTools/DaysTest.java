package it.lucchesi.goodies.DateTools;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Calendar;
import java.util.Date;

import org.joda.time.LocalDate;
import org.junit.Test;

import it.lucchesi.tools.DateTools.DateTools;
import lombok.val;

/**
 * Test weekdays in many months and in specific cases
 */
public class DaysTest { 

	@Test
	public void check2015Months() {
		val workingDaysJanuary2015 = DateTools.days(new LocalDate(2015,1,1).toDate(), new LocalDate(2015,1,31).toDate());
		assertThat(workingDaysJanuary2015).isEqualTo(22);	
		
		val workingDaysFebruary2015 = DateTools.days(new LocalDate(2015,2,1).toDate(), new LocalDate(2015,2,28).toDate());
		assertThat(workingDaysFebruary2015).isEqualTo(20);

		val workingDaysMarch2015 = DateTools.days(new LocalDate(2015,3,1).toDate(), new LocalDate(2015,3,31).toDate());
		assertThat(workingDaysMarch2015).isEqualTo(22);
		
		val workingDaysApril2015 = DateTools.days(new LocalDate(2015,4,1).toDate(), new LocalDate(2015,4,30).toDate());
		assertThat(workingDaysApril2015).isEqualTo(22);

		val workingDaysMay2015 = DateTools.days(new LocalDate(2015,5,1).toDate(), new LocalDate(2015,5,31).toDate());
		assertThat(workingDaysMay2015).isEqualTo(21);

		val workingDaysJune2015 = DateTools.days(new LocalDate(2015,6,1).toDate(), new LocalDate(2015,6,30).toDate());
		assertThat(workingDaysJune2015).isEqualTo(22);

		val workingDaysJuly2015 = DateTools.days(new LocalDate(2015,7,1).toDate(), new LocalDate(2015,7,31).toDate());
		assertThat(workingDaysJuly2015).isEqualTo(23);

		val workingDaysAugust2015 = DateTools.days(new LocalDate(2015,8,1).toDate(), new LocalDate(2015,8,31).toDate());
		assertThat(workingDaysAugust2015).isEqualTo(21);

		val workingDaysSeptember2015 = DateTools.days(new LocalDate(2015,9,1).toDate(), new LocalDate(2015,9,30).toDate());
		assertThat(workingDaysSeptember2015).isEqualTo(22);

		val workingDaysOctober2015 = DateTools.days(new LocalDate(2015,10,1).toDate(), new LocalDate(2015,10,31).toDate());
		assertThat(workingDaysOctober2015).isEqualTo(22);

		val workingDaysNovember2015 = DateTools.days(new LocalDate(2015,11,1).toDate(), new LocalDate(2015,11,30).toDate());
		assertThat(workingDaysNovember2015).isEqualTo(21);

		val workingDaysDecember2015 = DateTools.days(new LocalDate(2015,12,1).toDate(), new LocalDate(2015,12,31).toDate());
		assertThat(workingDaysDecember2015).isEqualTo(23);

	}

	@Test
	public void check2016Months() {
		val workingDaysJanuary2016 = DateTools.days(new LocalDate(2016,1,1).toDate(), new LocalDate(2016,1,31).toDate());
		assertThat(workingDaysJanuary2016).isEqualTo(21);

		val workingDaysFebruary2016 = DateTools.days(new LocalDate(2016,2,1).toDate(), new LocalDate(2016,2,29).toDate());
		assertThat(workingDaysFebruary2016).isEqualTo(21);

		val workingDaysMarch2016 = DateTools.days(new LocalDate(2016,3,1).toDate(), new LocalDate(2016,3,31).toDate());
		assertThat(workingDaysMarch2016).isEqualTo(23);

	}
	
	@Test
	public void checkOneWorkingDayNoWeekend() {
		val oneWorkingDay = DateTools.days(new LocalDate(2015,10,1).toDate(), new LocalDate(2015,10,1).toDate());
		assertThat(oneWorkingDay).isEqualTo(1);
	}
	
	@Test
	public void checkTwoWorkingDaysNoWeekend() {
		val twoWorkingDays = DateTools.days(new LocalDate(2015,10,1).toDate(), new LocalDate(2015,10,2).toDate());
		assertThat(twoWorkingDays).isEqualTo(2);
	}
	
	@Test
	public void checkTwoWorkingDaysWithWeekend() {
		val twoWorkingDays = DateTools.days(new LocalDate(2015,10,2).toDate(), new LocalDate(2015,10,5).toDate());
		assertThat(twoWorkingDays).isEqualTo(2);
	}
	
	@Test
	public void checkOneWorkingDaysWithWeekendStartingSaturday() {
		val oneWorkingDay = DateTools.days(new LocalDate(2015,10,3).toDate(), new LocalDate(2015,10,5).toDate());
		assertThat(oneWorkingDay).isEqualTo(1);
	}
	
	@Test
	public void checkOneWorkingDaysWithWeekendStartingSunday() {
		val oneWorkingDay = DateTools.days(new LocalDate(2015,10,4).toDate(), new LocalDate(2015,10,5).toDate());
		assertThat(oneWorkingDay).isEqualTo(1);
	}
	
	@Test
	public void checkOneWeekNoStartingWeekend() {
		val oneWorkingWeek = DateTools.days(new LocalDate(2015,1,1).toDate(), new LocalDate(2015,1,7).toDate());
		assertThat(oneWorkingWeek).isEqualTo(5);
	}
	
	@Test
	public void checkTwoWeeksNoStartingWeekend() {
		val twoWorkingWeek = DateTools.days(new LocalDate(2015,1,1).toDate(), new LocalDate(2015,1,14).toDate());
		assertThat(twoWorkingWeek).isEqualTo(10);
	}
	
	@Test
	public void checkThreeWeeksNoStartingWeekend() {
		val threeWorkingWeek = DateTools.days(new LocalDate(2015,1,1).toDate(), new LocalDate(2015,1,21).toDate());
		assertThat(threeWorkingWeek).isEqualTo(15);
	}
	
	@Test
	public void checkFourWeeksNoStartingWeekend() {
		val fourWorkingWeek = DateTools.days(new LocalDate(2015,1,1).toDate(), new LocalDate(2015,1,28).toDate());
		assertThat(fourWorkingWeek).isEqualTo(20);
	}
	
	@Test
	public void checkNoStartingWeekend() {
		val fourWorkingWeek = DateTools.days(new LocalDate(2015,1,1).toDate(), new LocalDate(2015,1,30).toDate());
		assertThat(fourWorkingWeek).isEqualTo(22);
	}
	
	@Test
	public void checkEndingSaturday() {
		val endingSaturday = DateTools.days(new LocalDate(2015,1,1).toDate(), new LocalDate(2015,1,3).toDate());
		assertThat(endingSaturday).isEqualTo(2);
	}
	
	@Test
	public void checkEndingSunday() {
		val endingSaturday = DateTools.days(new LocalDate(2015,1,1).toDate(), new LocalDate(2015,1,4).toDate());
		assertThat(endingSaturday).isEqualTo(2);
	}
	
	@Test
	public void checkStartingEndingWeekend() {
		val startEndWe = DateTools.days(new LocalDate(2015,10,3).toDate(), new LocalDate(2015,10,10).toDate());
		assertThat(startEndWe).isEqualTo(5);
	}
	
	@Test
	public void checkStartingEndingSunday() {
		val startEndSunday = DateTools.days(new LocalDate(2015,10,4).toDate(), new LocalDate(2015,10,11).toDate());
		assertThat(startEndSunday).isEqualTo(5);
	}

	@Test
	public void checkStartingSaturdayEndingSunday() {
		val startEndSunday = DateTools.days(new LocalDate(2015,10,3).toDate(), new LocalDate(2015,10,11).toDate());
		assertThat(startEndSunday).isEqualTo(5);
	}
	
	@Test
	public void checkSameWeekDay() {
		val startEndSunday = DateTools.days(new LocalDate(2015,10,2).toDate(), new LocalDate(2015,10,2).toDate());
		assertThat(startEndSunday).isEqualTo(1);
	}
	
	@Test
	public void checkSameWeekDaySaturday() {
		val startEndSameDaySaturday = DateTools.days(new LocalDate(2015,10,3).toDate(), new LocalDate(2015,10,3).toDate());
		assertThat(startEndSameDaySaturday).isEqualTo(0);
	}
	
	@Test
	public void checkSameWeekDaySaunday() {
		val startEndSameDaySunday = DateTools.days(new LocalDate(2015,10,4).toDate(), new LocalDate(2015,10,4).toDate());
		assertThat(startEndSameDaySunday).isEqualTo(0);
	}

	@Test
	public void checkCurrentDate() {
		Date today = new Date();
	    Calendar c1 = Calendar.getInstance();
	    c1.setTime(today);
	    val todayDays = DateTools.days(today, today); 
	    if (c1.get(Calendar.DAY_OF_WEEK) == Calendar.SATURDAY || c1.get(Calendar.DAY_OF_WEEK) == Calendar.SUNDAY) {
	    	assertThat(todayDays).isEqualTo(0);
	    } else {
	    	assertThat(todayDays).isEqualTo(1);
	    }
	}
	
	@Test
	public void checkSundayToSaturday() {
		val startEndSameDaySunday = DateTools.days(new LocalDate(2015,10,8).toDate(), new LocalDate(2015,10,14).toDate());
		assertThat(startEndSameDaySunday).isEqualTo(5);
	}
	
	@Test
	public void checkSaturdayToMonday() {
		val startEndSameDaySunday = DateTools.days(new LocalDate(2015,11,7).toDate(), new LocalDate(2015,11,9).toDate());
		assertThat(startEndSameDaySunday).isEqualTo(1);
	}

}

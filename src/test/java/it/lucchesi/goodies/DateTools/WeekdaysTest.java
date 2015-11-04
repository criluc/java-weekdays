package it.lucchesi.goodies.DateTools;

import static org.assertj.core.api.Assertions.assertThat;

import org.joda.time.LocalDate;
import org.junit.Test;

import it.lucchesi.tools.DateTools.DateTools;
import lombok.val;

/**
 * Test weekdays in many months and in specific cases
 */
public class WeekdaysTest { 

	@Test
	public void check2015Months() {
		val workingDaysJanuary2015 = DateTools.weekdays(new LocalDate(2015,1,1), new LocalDate(2015,1,31));
		assertThat(workingDaysJanuary2015).isEqualTo(22);	
		
		val workingDaysFebruary2015 = DateTools.weekdays(new LocalDate(2015,2,1), new LocalDate(2015,2,28));
		assertThat(workingDaysFebruary2015).isEqualTo(20);

		val workingDaysMarch2015 = DateTools.weekdays(new LocalDate(2015,3,1), new LocalDate(2015,3,31));
		assertThat(workingDaysMarch2015).isEqualTo(22);
		
		val workingDaysApril2015 = DateTools.weekdays(new LocalDate(2015,4,1), new LocalDate(2015,4,30));
		assertThat(workingDaysApril2015).isEqualTo(22);

		val workingDaysMay2015 = DateTools.weekdays(new LocalDate(2015,5,1), new LocalDate(2015,5,31));
		assertThat(workingDaysMay2015).isEqualTo(21);

		val workingDaysJune2015 = DateTools.weekdays(new LocalDate(2015,6,1), new LocalDate(2015,6,30));
		assertThat(workingDaysJune2015).isEqualTo(22);

		val workingDaysJuly2015 = DateTools.weekdays(new LocalDate(2015,7,1), new LocalDate(2015,7,31));
		assertThat(workingDaysJuly2015).isEqualTo(23);

		val workingDaysAugust2015 = DateTools.weekdays(new LocalDate(2015,8,1), new LocalDate(2015,8,31));
		assertThat(workingDaysAugust2015).isEqualTo(21);

		val workingDaysSeptember2015 = DateTools.weekdays(new LocalDate(2015,9,1), new LocalDate(2015,9,30));
		assertThat(workingDaysSeptember2015).isEqualTo(22);

		val workingDaysOctober2015 = DateTools.weekdays(new LocalDate(2015,10,1), new LocalDate(2015,10,31));
		assertThat(workingDaysOctober2015).isEqualTo(22);

		val workingDaysNovember2015 = DateTools.weekdays(new LocalDate(2015,11,1), new LocalDate(2015,11,30));
		assertThat(workingDaysNovember2015).isEqualTo(21);

		val workingDaysDecember2015 = DateTools.weekdays(new LocalDate(2015,12,1), new LocalDate(2015,12,31));
		assertThat(workingDaysDecember2015).isEqualTo(23);

	}

	@Test
	public void check2016Months() {
		val workingDaysJanuary2016 = DateTools.weekdays(new LocalDate(2016,1,1), new LocalDate(2016,1,31));
		assertThat(workingDaysJanuary2016).isEqualTo(21);

		val workingDaysFebruary2016 = DateTools.weekdays(new LocalDate(2016,2,1), new LocalDate(2016,2,29));
		assertThat(workingDaysFebruary2016).isEqualTo(21);

		val workingDaysMarch2016 = DateTools.weekdays(new LocalDate(2016,3,1), new LocalDate(2016,3,31));
		assertThat(workingDaysMarch2016).isEqualTo(23);

	}
	
	@Test
	public void checkOneWorkingDayNoWeekend() {
		val oneWorkingDay = DateTools.weekdays(new LocalDate(2015,10,1), new LocalDate(2015,10,1));
		assertThat(oneWorkingDay).isEqualTo(1);
	}
	
	@Test
	public void checkTwoWorkingDaysNoWeekend() {
		val twoWorkingDays = DateTools.weekdays(new LocalDate(2015,10,1), new LocalDate(2015,10,2));
		assertThat(twoWorkingDays).isEqualTo(2);
	}
	
	@Test
	public void checkTwoWorkingDaysWithWeekend() {
		val twoWorkingDays = DateTools.weekdays(new LocalDate(2015,10,2), new LocalDate(2015,10,5));
		assertThat(twoWorkingDays).isEqualTo(2);
	}
	
	@Test
	public void checkOneWorkingDaysWithWeekendStartingSaturday() {
		val oneWorkingDay = DateTools.weekdays(new LocalDate(2015,10,3), new LocalDate(2015,10,5));
		assertThat(oneWorkingDay).isEqualTo(1);
	}
	
	@Test
	public void checkOneWorkingDaysWithWeekendStartingSunday() {
		val oneWorkingDay = DateTools.weekdays(new LocalDate(2015,10,4), new LocalDate(2015,10,5));
		assertThat(oneWorkingDay).isEqualTo(1);
	}
	
	@Test
	public void checkOneWeekNoStartingWeekend() {
		val oneWorkingWeek = DateTools.weekdays(new LocalDate(2015,1,1), new LocalDate(2015,1,7));
		assertThat(oneWorkingWeek).isEqualTo(5);
	}
	
	@Test
	public void checkTwoWeeksNoStartingWeekend() {
		val twoWorkingWeek = DateTools.weekdays(new LocalDate(2015,1,1), new LocalDate(2015,1,14));
		assertThat(twoWorkingWeek).isEqualTo(10);
	}
	
	@Test
	public void checkThreeWeeksNoStartingWeekend() {
		val threeWorkingWeek = DateTools.weekdays(new LocalDate(2015,1,1), new LocalDate(2015,1,21));
		assertThat(threeWorkingWeek).isEqualTo(15);
	}
	
	@Test
	public void checkFourWeeksNoStartingWeekend() {
		val fourWorkingWeek = DateTools.weekdays(new LocalDate(2015,1,1), new LocalDate(2015,1,28));
		assertThat(fourWorkingWeek).isEqualTo(20);
	}
	
	@Test
	public void checkNoStartingWeekend() {
		val fourWorkingWeek = DateTools.weekdays(new LocalDate(2015,1,1), new LocalDate(2015,1,30));
		assertThat(fourWorkingWeek).isEqualTo(22);
	}
	
	@Test
	public void checkEndingSaturday() {
		val endingSaturday = DateTools.weekdays(new LocalDate(2015,1,1), new LocalDate(2015,1,3));
		assertThat(endingSaturday).isEqualTo(2);
	}
	
	@Test
	public void checkEndingSunday() {
		val endingSaturday = DateTools.weekdays(new LocalDate(2015,1,1), new LocalDate(2015,1,4));
		assertThat(endingSaturday).isEqualTo(2);
	}
	
	@Test
	public void checkStartingEndingWeekend() {
		val startEndWe = DateTools.weekdays(new LocalDate(2015,10,3), new LocalDate(2015,10,10));
		assertThat(startEndWe).isEqualTo(5);
	}
	
	@Test
	public void checkStartingEndingSunday() {
		val startEndSunday = DateTools.weekdays(new LocalDate(2015,10,4), new LocalDate(2015,10,11));
		assertThat(startEndSunday).isEqualTo(5);
	}

	@Test
	public void checkStartingSaturdayEndingSunday() {
		val startEndSunday = DateTools.weekdays(new LocalDate(2015,10,3), new LocalDate(2015,10,11));
		assertThat(startEndSunday).isEqualTo(5);
	}

}

package com.gk;

import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.Period;
import java.time.ZoneId;
import java.time.temporal.ChronoUnit;

/**
 * Period and Duration
 * 
 * The Period class represents a quantity of time in terms of years,months and
 * days.
 * 
 * The Duration class represents a quantity of time in terms of seconds and nano
 * seconds.
 *
 */
public class Period_Duration_Demo {

	public static void main(String[] args) {
		LocalDate initialDate = LocalDate.now();

		// Obtains a Period representing a number of days.
		LocalDate finalDate = initialDate.plus(Period.ofDays(5));

		/*
		 * Obtains a Period consisting of the number of years, months,and days between
		 * two dates.
		 */
		System.out.println(Period.between(initialDate, finalDate).getDays());// 5

		System.out.println(ChronoUnit.DAYS.between(initialDate, finalDate));// 5

		LocalTime initialTime = LocalTime.now();

		// Obtains a Duration representing a number of seconds.
		LocalTime finalTime = initialTime.plus(Duration.ofSeconds(30));

		// Obtains a Duration representing the duration between two temporal objects.
		System.out.println(Duration.between(initialTime, finalTime).getSeconds());// 30

		System.out.println(ChronoUnit.SECONDS.between(initialTime, finalTime));// 30

		LocalTime indianTime = LocalTime.now(ZoneId.of("Asia/Kolkata"));
		LocalTime usaTime = LocalTime.now(ZoneId.of("America/Los_Angeles"));

		long hours = Duration.between(indianTime, usaTime).toHours();
		long minutes = Duration.between(indianTime, usaTime).toMinutes();
		System.out.println("Time Difference Between India and America is " + hours + " hours and "
				+ (minutes - hours * 60) + " minutes.");
		// Time Difference Between India and America is 10 hours and 30 minutes.
	}

}

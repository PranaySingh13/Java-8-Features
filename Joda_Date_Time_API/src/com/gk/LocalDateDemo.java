package com.gk;

import java.time.Clock;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.temporal.ChronoUnit;
import java.time.temporal.TemporalAdjusters;

/**
 * The LocalDate represents a date in ISO format(yyyy-mm-dd) without time. It
 * can be used to store dates like birthdays and paydays.
 *
 */
public class LocalDateDemo {

	public static void main(String[] args) {

		// Obtains the current date from the specified clock.
		LocalDate localDate = LocalDate.now();
		System.out.println(localDate);// 2023-02-02

		// Obtains the current date from the specified clock.
		System.out.println(LocalDate.now(Clock.systemDefaultZone()));// 2023-02-02

		// Obtains the current date from the system clock in the specified time-zone.
		System.out.println(LocalDate.now(ZoneId.of("Europe/Paris")));// 2023-02-02

		// Obtains an instance of LocalDate from a year and day-of-year.
		System.out.println(LocalDate.of(1993, 01, 13));// 1993-01-13

		// Obtains an instance of LocalDate from a year and day-of-year.
		System.out.println(LocalDate.ofYearDay(1993, 13));// 1993-01-13

		// Obtains an instance of LocalDate from a text string such as 2007-12-03.
		System.out.println(LocalDate.parse("1993-01-13"));// 1993-01-13

		System.out.println(localDate.plus(2, ChronoUnit.DAYS));// 2023-02-04

		System.out.println(localDate.plusDays(10));// 2023-02-12

		System.out.println(localDate.plusMonths(2));// 2023-04-02

		System.out.println(localDate.plusWeeks(4));// 2023-03-02

		System.out.println(localDate.plusYears(3));// 2026-02-02

		System.out.println(localDate.minus(2, ChronoUnit.DAYS));// 2023-01-31

		System.out.println(localDate.minusDays(10));// 2023-01-23

		System.out.println(localDate.minusMonths(2));// 2022-12-02

		System.out.println(localDate.minusWeeks(4));// 2023-01-05

		System.out.println(localDate.minusYears(3));// 2020-02-02

		// Gets the day-of-week field, which is an enum DayOfWeek.
		System.out.println(LocalDate.parse("1993-01-13").getDayOfWeek());// WEDNESDAY

		// Gets the day-of-month field.
		System.out.println(LocalDate.parse("1993-02-13").getDayOfMonth());// 13

		// Gets the day-of-year field.
		System.out.println(LocalDate.parse("1993-02-13").getDayOfYear());// 44

		// Checks if this date is before the specified date.
		System.out.println(LocalDate.parse("1993-01-13").isBefore(LocalDate.now()));// true

		// Checks if this date is after the specified date.
		System.out.println(LocalDate.parse("1993-01-13").isAfter(LocalDate.now()));// false

		System.out.println(LocalDate.now().isLeapYear());// false

		// Combines this date with the time of midnight to create a LocalDateTimeat the
		// start of this date.
		System.out.println(LocalDate.parse("1993-01-13").atStartOfDay());// 1993-01-13T00:00

		// Returns an adjusted copy of this date. Returns the "first day of month"
		// adjuster, which returns a new date set tothe first day of the current month.
		System.out.println(LocalDate.parse("1993-01-13").with(TemporalAdjusters.firstDayOfMonth()));// 1993-01-01
	}

}

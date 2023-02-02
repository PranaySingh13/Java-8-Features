package com.gk;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.util.Locale;

/**
 * Java 8 provides APIs for the easy formatting of Date and Time
 *
 */
public class Date_Time_Formatting {

	public static void main(String[] args) {
		LocalDateTime localDateTime = LocalDateTime.now();
		System.out.println(localDateTime);
		// 2023-02-03T03:33:52.438

		/*
		 * Formats this date-time using the specified formatter. DateTimeFormatter is
		 * Formatter for printing and parsing date-time objects.
		 */
		System.out.println(localDateTime.format(DateTimeFormatter.ISO_DATE));
		// 2023-02-03

		System.out.println(localDateTime.format(DateTimeFormatter.ofPattern("dd/MM/yyyy")));
		// 03/02/2023

		/*
		 * ofLocalizedDate returns a locale specific date format for the ISO chronology.
		 * 
		 * FormatStyle is Enumeration of the style of a localized date, time or
		 * date-time formatter.
		 * 
		 * withLocale returns a copy of this formatter with a new locale.
		 * 
		 * A Locale object represents a specific geographical, political,or cultural
		 * region.
		 * 
		 */
		System.out.println(
				localDateTime.format(DateTimeFormatter.ofLocalizedDate(FormatStyle.LONG).withLocale(Locale.UK)));
		// 03 February 2023

		System.out.println(
				localDateTime.format(DateTimeFormatter.ofLocalizedDate(FormatStyle.MEDIUM).withLocale(Locale.UK)));
		// 03-Feb-2023

		System.out.println(
				localDateTime.format(DateTimeFormatter.ofLocalizedDate(FormatStyle.FULL).withLocale(Locale.US)));
		// Friday, February 3, 2023
	}

}

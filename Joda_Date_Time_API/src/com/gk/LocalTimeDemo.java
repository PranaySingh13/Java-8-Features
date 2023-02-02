package com.gk;

import java.time.LocalTime;
import java.time.ZoneId;
import java.time.temporal.ChronoUnit;

/**
 * The LocalTime represents time without a date.
 *
 */
public class LocalTimeDemo {

	public static void main(String[] args) {

		// Obtains the current time from the system clock in the default time-zone.
		LocalTime localTime = LocalTime.now();
		System.out.println(localTime);// 21:05:16.476
		System.out.println(LocalTime.now(ZoneId.of("America/New_York")));// 10:42:36.653

		// Obtains an instance of LocalTime from a text string such as 10:15.
		System.out.println(LocalTime.parse("06:30"));// 06:30

		System.out.println(LocalTime.of(06, 30, 0).plus(1, ChronoUnit.HOURS));// 07:30

		System.out.println(LocalTime.of(06, 30, 0).plus(1, ChronoUnit.MINUTES));// 06:31

		System.out.println(LocalTime.of(06, 30, 0).plus(1, ChronoUnit.SECONDS));// 06:30:01

		System.out.println(LocalTime.parse("06:30").isBefore(LocalTime.MIDNIGHT));// false

		System.out.println(LocalTime.parse("06:30").isAfter(LocalTime.MIDNIGHT));// true

		System.out.println(LocalTime.MAX);// 23:59:59.999999999
		System.out.println(LocalTime.MIN);// 00:00
		System.out.println(LocalTime.NOON);// 12:00

		System.out.println(LocalTime.now().getHour());// 21
		System.out.println(LocalTime.now().plusHours(1));// 22:14:57.072
		System.out.println(LocalTime.now().minusMinutes(10));// 21:04:57.072

	}

}

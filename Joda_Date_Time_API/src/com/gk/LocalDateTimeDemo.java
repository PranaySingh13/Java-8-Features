package com.gk;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.ZoneId;

/**
 * The LocalDateTime is used to represent a combination of Date and Time.
 *
 */
public class LocalDateTimeDemo {

	public static void main(String[] args) {
		LocalDateTime localDateTime = LocalDateTime.now();
		System.out.println(localDateTime);// 2023-02-02T22:02:12.809

		// Obtains an instance of LocalDateTime from a date and time.
		System.out.println(LocalDateTime.of(LocalDate.now(), LocalTime.now()));// 2023-02-02T22:03:14.368

		System.out.println(LocalDateTime.parse("1993-01-13T13:12:10"));// 1993-01-13T13:12:10

		System.out.println(LocalDateTime.MAX);// +999999999-12-31T23:59:59.999999999
		System.out.println(LocalDateTime.MIN);// -999999999-01-01T00:00

		System.out.println(LocalDateTime.now(ZoneId.of("America/New_York")));// 2023-02-02T11:36:23.287

		System.out.println(LocalDateTime.of(1993, 01, 13, 13, 12, 10));// 1993-01-13T13:12:10

	}

}

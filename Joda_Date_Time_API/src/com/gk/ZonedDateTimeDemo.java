package com.gk;

import java.time.LocalDateTime;
import java.time.OffsetDateTime;
import java.time.ZoneId;
import java.time.ZoneOffset;
import java.time.ZonedDateTime;

/**
 * Java 8 provides ZonedDateTime when we need to deal with time zone specific
 * date and time. The ZoneId is an identifier used to represent different
 * zones.There are different time zones and the ZoneId are used to represent
 * them.
 *
 */
public class ZonedDateTimeDemo {

	/**
	 * 
	 */
	public static void main(String[] args) {

		ZoneId zoneId1 = ZoneId.of("Asia/Kolkata");
		ZoneId zoneId2 = ZoneId.of("Asia/Tokyo");

		/*
		 * ZonedDateTime is a date-time with a time-zone in the ISO-8601 calendar
		 * system,such as 2007-12-03T10:15:30+01:00 Europe/Paris.
		 */
		System.out.println(ZonedDateTime.of(LocalDateTime.now(), zoneId1));
		// 2023-02-02T22:14:38.071+05:30[Asia/Kolkata]

		System.out.println(ZonedDateTime.of(LocalDateTime.now(), zoneId2));
		// 2023-02-02T22:14:38.073+09:00[Asia/Tokyo]

		/*
		 * OffsetDateTime is a date-time with an offset from UTC/Greenwich in the
		 * ISO-8601 calendar system,such as 2007-12-03T10:15:30+01:00.
		 * 
		 * ZoneOffset is a time-zone offset from Greenwich/UTC, such as +02:00.
		 */
		System.out.println(OffsetDateTime.of(LocalDateTime.now(), ZoneOffset.ofHours(2)));
		// 2023-02-02T22:18:17.804+02:00
	}

}

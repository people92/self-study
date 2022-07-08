package com.study.example.java.java8;

import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;

public class DateAndTimeClass {

    public static void main(String[] args) {
        Instant instant = Instant.now();
        System.out.println(instant); //기준시 UTC, GMT
        System.out.println(instant.atZone(ZoneId.of("UTC")));

        ZonedDateTime zonedDateTime = instant.atZone(ZoneId.systemDefault());
        System.out.println(zonedDateTime);

        LocalDateTime now = LocalDateTime.now();
        System.out.println(now);

        LocalDateTime birthday = LocalDateTime.of(1992, Month.MARCH, 1, 0, 0);
        System.out.println(birthday);

        ZonedDateTime nowInKorea = ZonedDateTime.now(ZoneId.of("Asia/Seoul"));
        System.out.println(nowInKorea);

        LocalDate today = LocalDate.now();
        LocalDate thisYearBirthday = LocalDate.of(2022, Month.AUGUST, 1);

        Period period = Period.between(today, thisYearBirthday);
        System.out.println(period.getDays());

        Period util = today.until(thisYearBirthday);
        System.out.println(util.getDays());

        Instant instant1 = Instant.now();
        Instant instant2 = instant1.plus(10, ChronoUnit.SECONDS);
        Duration duration = Duration.between(instant1, instant2);
        System.out.println(duration.getSeconds());


        LocalDateTime dateTime = LocalDateTime.now();
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("MM/dd/yyyy");
        System.out.println(dateTime.format(dateTimeFormatter));

        LocalDate parse = LocalDate.parse("07/15/1982", dateTimeFormatter);
        System.out.println(parse);

    }
}

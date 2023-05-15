package com.kaliware.payment.toolschallenge.utils;

import lombok.experimental.UtilityClass;

import java.time.DateTimeException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Objects;

@UtilityClass
public class DateTimeUtils{
  private static final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");

  public static boolean validateDateTime(String dateTimeStr){
    try{
      Objects.requireNonNull(dateTimeStr);
      LocalDateTime dateTime = LocalDateTime.parse(dateTimeStr, formatter);

      int year = dateTime.getYear();
      int month = dateTime.getMonthValue();
      int day = dateTime.getDayOfMonth();
      int hour = dateTime.getHour();
      int minute = dateTime.getMinute();
      int second = dateTime.getSecond();

      if(!isValidMonth(month)){
        return false;
      }

      if(!isValidDay(year, month, day)){
        return false;
      }

      if(!isValidHour(hour)){
        return false;
      }

      return true;

    }catch(DateTimeParseException | NullPointerException e){
      return false;
    }

  }

  private static boolean isValidMonth(int month){
    return month >= 1 && month <= 12;
  }

  private static boolean isValidDay(int year, int month, int day){
    try{
      LocalDate date = LocalDate.of(year, month, day);
      return true;
    }catch(DateTimeException e){
      return false;
    }
  }

  private static boolean isValidHour(int hour){
    return hour >= 0 && hour <= 23;
  }


}

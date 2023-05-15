package com.kaliware.payment.toolschallenge.util;

import com.kaliware.payment.toolschallenge.utils.DateTimeUtils;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
@DisplayName("DateTimeUtils Test")
public class DateTimeUtilsTest{

  @Nested
  @DisplayName("validateDateTime method")
  class validateDateTimeMethod{
    @Test
    @DisplayName("should return true for valid date and time")
    public void shouldReturnTrueForValidDateTime() {
      String dateTimeStr = "01/12/2021 18:30:00";
      Assertions.assertTrue(DateTimeUtils.validateDateTime(dateTimeStr));
    }

    @Test
    @DisplayName("should return false for invalid month")
    public void shouldReturnFalseForInvalidMonth() {
      String dateTimeStr = "01/13/2021 18:30:00";
      Assertions.assertFalse(DateTimeUtils.validateDateTime(dateTimeStr));
    }

    @Test
    @DisplayName("should return false for invalid day")
    public void shouldReturnFalseForInvalidDay() {
      String dateTimeStr = "02/29/2021 18:30:00";
      Assertions.assertFalse(DateTimeUtils.validateDateTime(dateTimeStr));
    }

    @Test
    @DisplayName("should return false for invalid hour")
    public void shouldReturnFalseForInvalidHour() {
      String dateTimeStr = "01/13/2021 24:30:00";
      Assertions.assertFalse(DateTimeUtils.validateDateTime(dateTimeStr));
    }

    @Test
    @DisplayName("should return false for invalid date and time format")
    public void shouldReturnFalseForInvalidDateTimeFormat() {
      String dateTimeStr = "2021-13-01T18:30:00";
      Assertions.assertFalse(DateTimeUtils.validateDateTime(dateTimeStr));
    }

    @Test
    @DisplayName("should return false for null date and time")
    public void shouldReturnFalseForNullDateTime() {
      String dateTimeStr = null;
      Assertions.assertFalse(DateTimeUtils.validateDateTime(dateTimeStr));
    }

    @Test
    @DisplayName("should return false for empty date and time")
    public void shouldReturnFalseForEmptyDateTime() {
      String dateTimeStr = "";
      Assertions.assertFalse(DateTimeUtils.validateDateTime(dateTimeStr));
    }

    @Test
    @DisplayName("should throw DateTimeException for invalid date")
    public void shouldThrowDateTimeExceptionForInvalidDate() {
      Assertions.assertFalse(DateTimeUtils.validateDateTime("02/29/2021 18:30:00"));
    }

    @Test
    @DisplayName("should throw DateTimeException for invalid time")
    public void shouldThrowDateTimeExceptionForInvalidTime() {
      Assertions.assertFalse(DateTimeUtils.validateDateTime("01/13/2021 24:30:00"));
    }
  }
}

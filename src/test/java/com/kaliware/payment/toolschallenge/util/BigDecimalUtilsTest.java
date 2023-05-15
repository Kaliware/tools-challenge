package com.kaliware.payment.toolschallenge.util;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.math.BigDecimal;

import static com.kaliware.payment.toolschallenge.utils.BigDecimalUtils.BigDecimalConverter;

@ExtendWith(SpringExtension.class)
@DisplayName("BigDecimalUtils Test")
public class BigDecimalUtilsTest{

  @Nested
  @DisplayName("BigDecimalConverter Test")
  public class BigDecimalConverterTest{

    @Nested
    @DisplayName("when converting valid input")
    class WhenConvertingValidInput{

      @Test
      @DisplayName("should return BigDecimal with positive integer")
      public void shouldReturnBigDecimalWithPositiveInteger(){
        String input = "12345";
        BigDecimal expectedOutput = new BigDecimal("12345");

        BigDecimal actualOutput = BigDecimalConverter(input);

        Assertions.assertEquals(expectedOutput, actualOutput);
      }

      @Test
      @DisplayName("should return BigDecimal with negative integer")
      public void shouldReturnBigDecimalWithNegativeInteger(){
        String input = "-12345";
        BigDecimal expectedOutput = new BigDecimal("-12345");

        BigDecimal actualOutput = BigDecimalConverter(input);

        Assertions.assertEquals(expectedOutput, actualOutput);
      }

      @Test
      @DisplayName("should return BigDecimal with positive decimal")
      public void shouldReturnBigDecimalWithPositiveDecimal(){
        String input = "123.45";
        BigDecimal expectedOutput = new BigDecimal("123.45");

        BigDecimal actualOutput = BigDecimalConverter(input);

        Assertions.assertEquals(expectedOutput, actualOutput);
      }

      @Test
      @DisplayName("should return BigDecimal with negative decimal")
      public void shouldReturnBigDecimalWithNegativeDecimal(){
        String input = "-123.45";
        BigDecimal expectedOutput = new BigDecimal("-123.45");

        BigDecimal actualOutput = BigDecimalConverter(input);

        Assertions.assertEquals(expectedOutput, actualOutput);
      }

      @Test
      @DisplayName("should return BigDecimal with mixed positive integer and decimal")
      public void shouldReturnBigDecimalWithMixedPositiveIntegerAndDecimal(){
        String input = "12345.67";
        BigDecimal expectedOutput = new BigDecimal("12345.67");

        BigDecimal actualOutput = BigDecimalConverter(input);

        Assertions.assertEquals(expectedOutput, actualOutput);
      }

      @Test
      @DisplayName("should return BigDecimal with mixed negative integer and decimal")
      public void shouldReturnBigDecimalWithMixedNegativeIntegerAndDecimal(){
        String input = "-12345.67";
        BigDecimal expectedOutput = new BigDecimal("-12345.67");

        BigDecimal actualOutput = BigDecimalConverter(input);

        Assertions.assertEquals(expectedOutput, actualOutput);
      }
    }

    @Nested
    @DisplayName("when converting invalid input")
    class WhenConvertingInvalidInput{

      @Test
      @DisplayName("should throw NullPointerException when input is null")
      public void shouldThrowNullPointerExceptionWhenInputIsNull(){
        String input = null;

        Assertions.assertThrows(NullPointerException.class, () -> BigDecimalConverter(input));
      }

      @Test
      @DisplayName("should throw NumberFormatException when input is not a number")
      public void shouldThrowNumberFormatExceptionWhenInputIsNotANumber(){
        String input = "abc";

        Assertions.assertThrows(NumberFormatException.class, () -> BigDecimalConverter(input));
      }
    }
  }

}

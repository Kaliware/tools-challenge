package com.kaliware.payment.toolschallenge.util;

import com.kaliware.payment.toolschallenge.exceptions.ParsingException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static com.kaliware.payment.toolschallenge.utils.NumberUtils.extractNumbers;

@ExtendWith(SpringExtension.class)
@DisplayName("NumberUtils Test")
public class NumberUtilsTest{
  @Test
  @DisplayName("should return numbers from string")
  public void shouldReturnNumbersFromString(){
    String input = "1a2b3c4d5e6f7g8h9i0j";
    long expectedOutput = 1234567890L;
    Assertions.assertEquals(expectedOutput, extractNumbers(input));
  }

  @Test
  @DisplayName("should throw ParsingException for null input")
  public void shouldThrowParsingExceptionForNullInput(){
    String input = null;
    Assertions.assertThrows(ParsingException.class, () -> extractNumbers(input));
  }

  @Test
  @DisplayName("should throw ParsingException for empty input")
  public void shouldThrowParsingExceptionForEmptyInput(){
    String input = "";
    Assertions.assertThrows(ParsingException.class, () -> extractNumbers(input));
  }

  @Test
  @DisplayName("should throw ParsingException for non-numeric input")
  public void shouldThrowParsingExceptionForNonNumericInput(){
    String input = "abc";
    Assertions.assertThrows(ParsingException.class, () -> extractNumbers(input));
  }
}

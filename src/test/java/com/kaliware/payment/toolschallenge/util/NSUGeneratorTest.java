package com.kaliware.payment.toolschallenge.util;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static com.kaliware.payment.toolschallenge.utils.NSUGenerator.generateNSU;

@ExtendWith(SpringExtension.class)
@DisplayName("NSUGenerator Test")
public class NSUGeneratorTest{
  @Test
  @DisplayName("should Return NSU With twenty Character")
  public void shouldReturnAutorizationCodeWithEightCharacter(){
    Assertions.assertEquals(20, generateNSU().length());
  }
}

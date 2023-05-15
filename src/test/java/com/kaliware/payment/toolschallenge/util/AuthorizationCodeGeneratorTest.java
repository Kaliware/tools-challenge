package com.kaliware.payment.toolschallenge.util;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static com.kaliware.payment.toolschallenge.utils.AuthorizationCodeGenerator.generateAuthorizationCode;

@ExtendWith(SpringExtension.class)
@DisplayName("generateAuthorizationCode Test")
public class AuthorizationCodeGeneratorTest{

  @Test
  @DisplayName("should Return AutorizationCode With Eight Character")
  public void shouldReturnAutorizationCodeWithEightCharacter(){
    Assertions.assertEquals(8, generateAuthorizationCode().length());
  }

}

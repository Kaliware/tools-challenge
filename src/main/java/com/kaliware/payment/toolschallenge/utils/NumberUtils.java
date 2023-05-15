package com.kaliware.payment.toolschallenge.utils;

import com.kaliware.payment.toolschallenge.exceptions.ParsingException;
import lombok.experimental.UtilityClass;

import java.util.Objects;

@UtilityClass
public class NumberUtils{


  public static long extractNumbers(String input){
    try{
      Objects.requireNonNull(input, "input: null");
      String stringNumber = input.replaceAll("[^\\d]", "");
      return Long.parseLong(stringNumber);
    }catch(Exception e){
      throw new ParsingException("Erro na conversão de String para long");
    }
  }
}
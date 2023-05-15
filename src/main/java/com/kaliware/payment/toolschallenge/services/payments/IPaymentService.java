package com.kaliware.payment.toolschallenge.services.payments;

import com.kaliware.payment.toolschallenge.dto.PaymentDTO;

import java.util.List;


public interface IPaymentService{

  public PaymentDTO payment(PaymentDTO dto);

  public PaymentDTO refund(String id);

  public PaymentDTO findById(String id);


  public List<PaymentDTO> findAll();


}

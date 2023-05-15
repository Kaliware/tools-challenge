package com.kaliware.payment.toolschallenge.controllers.payments;

import com.kaliware.payment.toolschallenge.dto.PaymentDTO;
import com.kaliware.payment.toolschallenge.services.payments.IPaymentService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/payments")
@Controller
public class PaymentController{

  @Autowired
  private IPaymentService service;

  @PostMapping
  public PaymentDTO payment(@Valid @RequestBody PaymentDTO dto){
    return service.payment(dto);
  }

  @GetMapping(value = "/{id}")
  public PaymentDTO findById(@PathVariable String id){
    return service.findById(id);
  }

  @GetMapping()
  public List<PaymentDTO> findAll(){
    return service.findAll();
  }

  @PostMapping(value = "/cancel/{id}")
  public PaymentDTO refund(@PathVariable String id){
    return service.refund(id);
  }
}

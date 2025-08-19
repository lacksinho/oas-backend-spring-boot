package com.ladam.oas.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ApplicantInvoiceDTO {
    private Long id;
    private String invoiceNo;
    private String payerId;
    private String payerName;
    private String currency;
    private double amount;
    private Double paidAmount;
    private  String controlNumber;
    private String paidStatus;
}

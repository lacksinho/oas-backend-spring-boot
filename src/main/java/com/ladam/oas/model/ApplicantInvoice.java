package com.ladam.oas.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

@Entity
@Table(name = "applicant_bill_invoice")
public class ApplicantInvoice {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "invoice_no")
    private String invoiceNo;

    @Column(name = "payer_id")
    private String payerId;
    private String name;
    private String email;

    @Column(name = "mobile")
    private String mobileNumber;

    @Column(name = "app_round")
    private int appRound;
    private String description;

    @Column(name = "item_code")
    private String itemCode;

    @Column(length = 5)
    private String currency;
    private double amount;

    @Column(name = "paid_amount")
    private Double paidAmount;

    @Column(name = "control_number")
    private  String controlNumber;
    private Integer paid;

}

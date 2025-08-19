package com.ladam.oas.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import com.ladam.oas.model.ApplicantInvoice;

public interface ApplicantInvoiceRepository extends JpaRepository<ApplicantInvoice, Long> {

    Page<ApplicantInvoice> findByNameContainingIgnoreCase(
            String name, Pageable pageable);

    Page<ApplicantInvoice> findByPaidAndNameContainingIgnoreCase(
            Integer paid, String name,
            Pageable pageable
    );

    Page<ApplicantInvoice> findByPaid(Integer paid, Pageable pageable);

    Page<ApplicantInvoice> findByPaidIsNull(Pageable pageable);

    Page<ApplicantInvoice> findByPaidIsNullAndNameContainingIgnoreCase(String name, Pageable pageable);

}

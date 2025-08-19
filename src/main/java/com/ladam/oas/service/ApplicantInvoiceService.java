package com.ladam.oas.service;

import com.ladam.oas.dto.*;

public interface ApplicantInvoiceService {

    ApplicantInvoiceDTO getApplicantInvoiceById(Long id);
    void deleteApplicantInvoiceById(Long id);
    ApplicantInvoiceListDTO getAllApplicantInvoices(int pageNo, int pageSize, String sortBy, String sortDir, String search, Integer paid);
}

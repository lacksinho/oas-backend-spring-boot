package com.ladam.oas.mapper;

import com.ladam.oas.dto.ApplicantInvoiceDTO;
import com.ladam.oas.model.ApplicantInvoice;
import com.ladam.oas.utils.AppConstants;

public class ApplicantInvoiceMapper {

	public static ApplicantInvoiceDTO toDTO(ApplicantInvoice applicantInvoice) {

		if (applicantInvoice == null) {
			return null;
		}
		ApplicantInvoiceDTO applicantInvoiceDTO = new ApplicantInvoiceDTO();
		applicantInvoiceDTO.setId(applicantInvoice.getId());
		applicantInvoiceDTO.setInvoiceNo(applicantInvoice.getInvoiceNo());
		applicantInvoiceDTO.setPayerName(applicantInvoice.getName());
		applicantInvoiceDTO.setPayerId(applicantInvoice.getPayerId());
		applicantInvoiceDTO.setCurrency(applicantInvoice.getCurrency());
		applicantInvoiceDTO.setAmount(applicantInvoice.getAmount());
		applicantInvoiceDTO.setPaidAmount(applicantInvoice.getPaidAmount());
		applicantInvoiceDTO.setControlNumber(applicantInvoice.getControlNumber());
		Integer paid = applicantInvoice.getPaid();
		if (paid != null && paid == AppConstants.PAID_STATUS) {
			applicantInvoiceDTO.setPaidStatus("PAID");
		} else {
			applicantInvoiceDTO.setPaidStatus("NOT PAID");
		}
		
		return applicantInvoiceDTO;
	}

//    public ApplicantInvoice toEntity(ApplicantInvoiceDTO applicantInvoiceDTO) {
//        return null;
//    }

}

package com.ladam.oas.service.impl;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.ladam.oas.dto.ApplicantInvoiceDTO;
import com.ladam.oas.dto.ApplicantInvoiceListDTO;
import com.ladam.oas.exception.OasApiException;
import com.ladam.oas.mapper.ApplicantInvoiceMapper;
import com.ladam.oas.model.ApplicantInvoice;
import com.ladam.oas.repository.ApplicantInvoiceRepository;
import com.ladam.oas.service.ApplicantInvoiceService;
import com.ladam.oas.utils.AppConstants;
import com.ladam.oas.utils.EntityHelperService;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ApplicantInvoiceServiceImpl implements ApplicantInvoiceService {
    private final ApplicantInvoiceRepository applicantInvoiceRepository;
    private final EntityHelperService entityHelperService;

    public ApplicantInvoiceServiceImpl(ApplicantInvoiceRepository applicantInvoiceRepository, EntityHelperService entityHelperService) {
        this.applicantInvoiceRepository = applicantInvoiceRepository;
        this.entityHelperService = entityHelperService;
    }

    @Override
    public ApplicantInvoiceDTO getApplicantInvoiceById(Long id) {
        ApplicantInvoice applicantInvoice = entityHelperService.getApplicantInvoiceByIdOrThrow(id);
        return ApplicantInvoiceMapper.toDTO(applicantInvoice);
    }

    @Override
    public void deleteApplicantInvoiceById(Long id) {
        ApplicantInvoice applicantInvoice = entityHelperService.getApplicantInvoiceByIdOrThrow(id);

        if (applicantInvoice.getPaid()!= null && applicantInvoice.getPaid() == AppConstants.PAID_STATUS) {
            throw new OasApiException(HttpStatus.BAD_REQUEST, "You cannot delete a paid invoice.");
        }

        applicantInvoiceRepository.deleteById(id);
    }


    @Override
    public ApplicantInvoiceListDTO getAllApplicantInvoices(int pageNo, int pageSize, String sortBy, String sortDir, String search, Integer paid) {
        Sort sort = sortDir.equalsIgnoreCase(Sort.Direction.ASC.name()) ? Sort.by(sortBy).ascending()
                : Sort.by(sortBy).descending();
        Pageable pageable = PageRequest.of(pageNo, pageSize, sort);

        Page<ApplicantInvoice> applicantInvoices;

        boolean hasSearch = search != null && !search.trim().isEmpty();
        boolean hasPaidFilter = paid != null;

        if (hasPaidFilter) {
            if (paid == AppConstants.PAID_STATUS) {
                // Paid invoices (paid = 1)
                if (hasSearch) {
                    applicantInvoices = applicantInvoiceRepository.findByPaidAndNameContainingIgnoreCase(1, search, pageable);
                } else {
                    applicantInvoices = applicantInvoiceRepository.findByPaid(1, pageable);
                }
            } else if (paid == AppConstants.NOT_PAID_STATUS) {
                // Not paid invoices (paid IS NULL)
                if (hasSearch) {
                    applicantInvoices = applicantInvoiceRepository.findByPaidIsNullAndNameContainingIgnoreCase(search, pageable);
                } else {
                    applicantInvoices = applicantInvoiceRepository.findByPaidIsNull(pageable);
                }
            } else {
                // Invalid paid filter, fallback to all
                if (hasSearch) {
                    applicantInvoices = applicantInvoiceRepository.findByNameContainingIgnoreCase(search, pageable);
                } else {
                    applicantInvoices = applicantInvoiceRepository.findAll(pageable);
                }
            }
        } else {
            // No paid filter
            if (hasSearch) {
                applicantInvoices = applicantInvoiceRepository.findByNameContainingIgnoreCase(search, pageable);
            } else {
                applicantInvoices = applicantInvoiceRepository.findAll(pageable);
            }
        }

        List<ApplicantInvoice> listOfApplicantInvoices = applicantInvoices.getContent();
        List<ApplicantInvoiceDTO> content = listOfApplicantInvoices.stream().map(
                applicantInvoice -> ApplicantInvoiceMapper.toDTO(applicantInvoice)).collect(Collectors.toList());

        ApplicantInvoiceListDTO applicantInvoiceListDTO = new ApplicantInvoiceListDTO();
        applicantInvoiceListDTO.setContent(content);
        applicantInvoiceListDTO.setPageNo(pageNo);
        applicantInvoiceListDTO.setPageSize(pageSize);
        applicantInvoiceListDTO.setTotalPages(applicantInvoices.getTotalPages());
        applicantInvoiceListDTO.setTotalElements(applicantInvoices.getTotalElements());
        applicantInvoiceListDTO.setLast(applicantInvoices.isLast());
        return applicantInvoiceListDTO;
    }
}
package com.ladam.oas.utils;

import java.util.Collections;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import com.ladam.oas.exception.ResourceNotFoundException;
import com.ladam.oas.model.Applicant;
import com.ladam.oas.model.ApplicantInvoice;
import com.ladam.oas.model.District;
import com.ladam.oas.repository.ApplicantInvoiceRepository;
import com.ladam.oas.repository.ApplicantRepository;
import com.ladam.oas.repository.DistrictRepository;

@Service
public class EntityHelperService {

    private final ApplicantRepository applicantRepository;
    private final ApplicantInvoiceRepository applicantInvoiceRepository;
    private final DistrictRepository districtRepository;

    public EntityHelperService(ApplicantRepository applicantRepository, ApplicantInvoiceRepository applicantInvoiceRepository,DistrictRepository districtRepository) {
        this.applicantRepository = applicantRepository;
        this.applicantInvoiceRepository = applicantInvoiceRepository;
		this.districtRepository = districtRepository;
    }

    public Applicant getApplicantByIdOrThrow(Long applicantId) {
        return applicantRepository.findById(applicantId)
                .orElseThrow(() -> new ResourceNotFoundException("Applicant", "id", applicantId));
    }

    public ApplicantInvoice getApplicantInvoiceByIdOrThrow(Long applicantInvoiceId) {
        return applicantInvoiceRepository.findById(applicantInvoiceId)
                .orElseThrow(() -> new ResourceNotFoundException("Applicant Invoice", "id", applicantInvoiceId));
    }
    
    public District getDistrictByIdOrThrow(Long districtId) {
        return districtRepository.findById(districtId)
            .orElseThrow(() -> new ResourceNotFoundException("District", "id", districtId));
    }
    
    
    public <T, ID> T getByIdOrThrow(JpaRepository<T, ID> repository, ID id, String entityName) {
        return repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException(entityName, "id", id));
    }
    
    
    public <E, D> List<D> mapList(List<E> entities, Function<E, D> mapper) {
		if (entities == null) {
			return Collections.emptyList();
		}
		return entities.stream().map(mapper).collect(Collectors.toUnmodifiableList());
	}


}
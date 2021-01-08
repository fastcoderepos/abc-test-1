package com.fastcode.aaaloc.restcontrollers.core;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import javax.persistence.EntityNotFoundException;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.core.env.Environment;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.fastcode.aaaloc.commons.search.SearchCriteria;
import com.fastcode.aaaloc.commons.search.SearchUtils;
import com.fastcode.aaaloc.commons.search.OffsetBasedPageRequest;
import com.fastcode.aaaloc.application.core.staff.IStaffAppService;
import com.fastcode.aaaloc.application.core.staff.dto.*;
import com.fastcode.aaaloc.application.core.address.IAddressAppService;
import com.fastcode.aaaloc.application.core.payment.IPaymentAppService;
import com.fastcode.aaaloc.application.core.payment.dto.FindPaymentByIdOutput;
import com.fastcode.aaaloc.application.core.rental.IRentalAppService;
import com.fastcode.aaaloc.application.core.rental.dto.FindRentalByIdOutput;
import com.fastcode.aaaloc.application.core.store.IStoreAppService;
import java.util.*;
import java.time.*;
import com.fastcode.aaaloc.commons.logging.LoggingHelper;

@RestController
@RequestMapping("/staff")
@RequiredArgsConstructor
public class StaffController {

	@Qualifier("staffAppService")
	@NonNull protected final IStaffAppService _staffAppService;

    @Qualifier("addressAppService")
	@NonNull  protected final IAddressAppService  _addressAppService;

    @Qualifier("paymentAppService")
	@NonNull  protected final IPaymentAppService  _paymentAppService;

    @Qualifier("rentalAppService")
	@NonNull  protected final IRentalAppService  _rentalAppService;

    @Qualifier("storeAppService")
	@NonNull  protected final IStoreAppService  _storeAppService;

	@NonNull protected final LoggingHelper logHelper;

	@NonNull protected final Environment env;

	@RequestMapping(method = RequestMethod.POST, consumes = {"application/json"}, produces = {"application/json"})
	public ResponseEntity<CreateStaffOutput> create(@RequestBody @Valid CreateStaffInput staff) {
		CreateStaffOutput output=_staffAppService.create(staff);
		Optional.ofNullable(output).orElseThrow(() -> new EntityNotFoundException(String.format("No record found")));

		return new ResponseEntity(output, HttpStatus.OK);
	}

	// ------------ Delete staff ------------
	@ResponseStatus(value = HttpStatus.NO_CONTENT)
	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE, consumes = {"application/json"})
	public void delete(@PathVariable String id) {

    	FindStaffByIdOutput output = _staffAppService.findById(Integer.valueOf(id));
    	Optional.ofNullable(output).orElseThrow(() -> new EntityNotFoundException(String.format("There does not exist a staff with a id=%s", id)));

    	_staffAppService.delete(Integer.valueOf(id));
    }


	// ------------ Update staff ------------
	@RequestMapping(value = "/{id}", method = RequestMethod.PUT, consumes = {"application/json"}, produces = {"application/json"})
	public ResponseEntity<UpdateStaffOutput> update(@PathVariable String id, @RequestBody @Valid UpdateStaffInput staff) {

	    FindStaffByIdOutput currentStaff = _staffAppService.findById(Integer.valueOf(id));
		Optional.ofNullable(currentStaff).orElseThrow(() -> new EntityNotFoundException(String.format("Unable to update. Staff with id=%s not found.", id)));


		staff.setVersiono(currentStaff.getVersiono());
	    UpdateStaffOutput output = _staffAppService.update(Integer.valueOf(id),staff);
		Optional.ofNullable(output).orElseThrow(() -> new EntityNotFoundException(String.format("No record found")));
		return new ResponseEntity(output, HttpStatus.OK);
	}


	@RequestMapping(value = "/{id}", method = RequestMethod.GET, consumes = {"application/json"}, produces = {"application/json"})
	public ResponseEntity<FindStaffByIdOutput> findById(@PathVariable String id) {

    	FindStaffByIdOutput output = _staffAppService.findById(Integer.valueOf(id));
    	Optional.ofNullable(output).orElseThrow(() -> new EntityNotFoundException(String.format("Not found")));

		return new ResponseEntity(output, HttpStatus.OK);
	}

	@RequestMapping(method = RequestMethod.GET, consumes = {"application/json"}, produces = {"application/json"})
	public ResponseEntity find(@RequestParam(value="search", required=false) String search, @RequestParam(value = "offset", required=false) String offset, @RequestParam(value = "limit", required=false) String limit, Sort sort) throws Exception {

		if (offset == null) { offset = env.getProperty("fastCode.offset.default"); }
		if (limit == null) { limit = env.getProperty("fastCode.limit.default"); }

		if(sort == null || sort.isEmpty()) {
			sort = Sort.by(Sort.Direction.ASC, "staffId");
		}
		
		Pageable Pageable = new OffsetBasedPageRequest(Integer.parseInt(offset), Integer.parseInt(limit), sort);
		SearchCriteria searchCriteria = SearchUtils.generateSearchCriteriaObject(search);

		return ResponseEntity.ok(_staffAppService.find(searchCriteria,Pageable));
	}
	@RequestMapping(value = "/{id}/address", method = RequestMethod.GET, consumes = {"application/json"}, produces = {"application/json"})
	public ResponseEntity<GetAddressOutput> getAddress(@PathVariable String id) {
    	GetAddressOutput output= _staffAppService.getAddress(Integer.valueOf(id));
		Optional.ofNullable(output).orElseThrow(() -> new EntityNotFoundException(String.format("Not found")));

		return new ResponseEntity(output, HttpStatus.OK);
	}
	@RequestMapping(value = "/{id}/payments", method = RequestMethod.GET, consumes = {"application/json"}, produces = {"application/json"})
	public ResponseEntity getPayments(@PathVariable String id, @RequestParam(value="search", required=false) String search, @RequestParam(value = "offset", required=false) String offset, @RequestParam(value = "limit", required=false) String limit, Sort sort)throws Exception {
   		if (offset == null) { offset = env.getProperty("fastCode.offset.default"); }
		if (limit == null) { limit = env.getProperty("fastCode.limit.default"); }

		if(sort == null || sort.isEmpty()) {
			sort = Sort.by(Sort.Direction.ASC, "paymentId");
		}
		
		Pageable pageable = new OffsetBasedPageRequest(Integer.parseInt(offset), Integer.parseInt(limit), sort);

		SearchCriteria searchCriteria = SearchUtils.generateSearchCriteriaObject(search);
		Map<String,String> joinColDetails=_staffAppService.parsePaymentsJoinColumn(id);
		Optional.ofNullable(joinColDetails).orElseThrow(() -> new EntityNotFoundException(String.format("Invalid join column")));

		searchCriteria.setJoinColumns(joinColDetails);

    	List<FindPaymentByIdOutput> output = _paymentAppService.find(searchCriteria,pageable);
		Optional.ofNullable(output).orElseThrow(() -> new EntityNotFoundException(String.format("Not found")));

		return new ResponseEntity(output, HttpStatus.OK);
	}
	@RequestMapping(value = "/{id}/rentals", method = RequestMethod.GET, consumes = {"application/json"}, produces = {"application/json"})
	public ResponseEntity getRentals(@PathVariable String id, @RequestParam(value="search", required=false) String search, @RequestParam(value = "offset", required=false) String offset, @RequestParam(value = "limit", required=false) String limit, Sort sort)throws Exception {
   		if (offset == null) { offset = env.getProperty("fastCode.offset.default"); }
		if (limit == null) { limit = env.getProperty("fastCode.limit.default"); }

		if(sort == null || sort.isEmpty()) {
			sort = Sort.by(Sort.Direction.ASC, "rentalId");
		}
		
		Pageable pageable = new OffsetBasedPageRequest(Integer.parseInt(offset), Integer.parseInt(limit), sort);

		SearchCriteria searchCriteria = SearchUtils.generateSearchCriteriaObject(search);
		Map<String,String> joinColDetails=_staffAppService.parseRentalsJoinColumn(id);
		Optional.ofNullable(joinColDetails).orElseThrow(() -> new EntityNotFoundException(String.format("Invalid join column")));

		searchCriteria.setJoinColumns(joinColDetails);

    	List<FindRentalByIdOutput> output = _rentalAppService.find(searchCriteria,pageable);
		Optional.ofNullable(output).orElseThrow(() -> new EntityNotFoundException(String.format("Not found")));

		return new ResponseEntity(output, HttpStatus.OK);
	}
	@RequestMapping(value = "/{id}/store", method = RequestMethod.GET, consumes = {"application/json"}, produces = {"application/json"})
	public ResponseEntity<GetStoreOutput> getStore(@PathVariable String id) {
    	GetStoreOutput output= _staffAppService.getStore(Integer.valueOf(id));
		Optional.ofNullable(output).orElseThrow(() -> new EntityNotFoundException(String.format("Not found")));

		return new ResponseEntity(output, HttpStatus.OK);
	}

}



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
import com.fastcode.aaaloc.application.core.address.IAddressAppService;
import com.fastcode.aaaloc.application.core.address.dto.*;
import com.fastcode.aaaloc.application.core.city.ICityAppService;
import com.fastcode.aaaloc.application.core.customer.ICustomerAppService;
import com.fastcode.aaaloc.application.core.customer.dto.FindCustomerByIdOutput;
import com.fastcode.aaaloc.application.core.customuser.ICustomUserAppService;
import com.fastcode.aaaloc.application.core.customuser.dto.FindCustomUserByIdOutput;
import com.fastcode.aaaloc.application.core.staff.IStaffAppService;
import com.fastcode.aaaloc.application.core.staff.dto.FindStaffByIdOutput;
import com.fastcode.aaaloc.application.core.store.IStoreAppService;
import com.fastcode.aaaloc.application.core.store.dto.FindStoreByIdOutput;
import java.util.*;
import java.time.*;
import com.fastcode.aaaloc.commons.logging.LoggingHelper;

@RestController
@RequestMapping("/address")
@RequiredArgsConstructor
public class AddressController {

	@Qualifier("addressAppService")
	@NonNull protected final IAddressAppService _addressAppService;

    @Qualifier("cityAppService")
	@NonNull  protected final ICityAppService  _cityAppService;

    @Qualifier("customerAppService")
	@NonNull  protected final ICustomerAppService  _customerAppService;

    @Qualifier("customUserAppService")
	@NonNull  protected final ICustomUserAppService  _customUserAppService;

    @Qualifier("staffAppService")
	@NonNull  protected final IStaffAppService  _staffAppService;

    @Qualifier("storeAppService")
	@NonNull  protected final IStoreAppService  _storeAppService;

	@NonNull protected final LoggingHelper logHelper;

	@NonNull protected final Environment env;

	@RequestMapping(method = RequestMethod.POST, consumes = {"application/json"}, produces = {"application/json"})
	public ResponseEntity<CreateAddressOutput> create(@RequestBody @Valid CreateAddressInput address) {
		CreateAddressOutput output=_addressAppService.create(address);
		Optional.ofNullable(output).orElseThrow(() -> new EntityNotFoundException(String.format("No record found")));

		return new ResponseEntity(output, HttpStatus.OK);
	}

	// ------------ Delete address ------------
	@ResponseStatus(value = HttpStatus.NO_CONTENT)
	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE, consumes = {"application/json"})
	public void delete(@PathVariable String id) {

    	FindAddressByIdOutput output = _addressAppService.findById(Integer.valueOf(id));
    	Optional.ofNullable(output).orElseThrow(() -> new EntityNotFoundException(String.format("There does not exist a address with a id=%s", id)));

    	_addressAppService.delete(Integer.valueOf(id));
    }


	// ------------ Update address ------------
	@RequestMapping(value = "/{id}", method = RequestMethod.PUT, consumes = {"application/json"}, produces = {"application/json"})
	public ResponseEntity<UpdateAddressOutput> update(@PathVariable String id, @RequestBody @Valid UpdateAddressInput address) {

	    FindAddressByIdOutput currentAddress = _addressAppService.findById(Integer.valueOf(id));
		Optional.ofNullable(currentAddress).orElseThrow(() -> new EntityNotFoundException(String.format("Unable to update. Address with id=%s not found.", id)));


		address.setVersiono(currentAddress.getVersiono());
	    UpdateAddressOutput output = _addressAppService.update(Integer.valueOf(id),address);
		Optional.ofNullable(output).orElseThrow(() -> new EntityNotFoundException(String.format("No record found")));
		return new ResponseEntity(output, HttpStatus.OK);
	}


	@RequestMapping(value = "/{id}", method = RequestMethod.GET, consumes = {"application/json"}, produces = {"application/json"})
	public ResponseEntity<FindAddressByIdOutput> findById(@PathVariable String id) {

    	FindAddressByIdOutput output = _addressAppService.findById(Integer.valueOf(id));
    	Optional.ofNullable(output).orElseThrow(() -> new EntityNotFoundException(String.format("Not found")));

		return new ResponseEntity(output, HttpStatus.OK);
	}

	@RequestMapping(method = RequestMethod.GET, consumes = {"application/json"}, produces = {"application/json"})
	public ResponseEntity find(@RequestParam(value="search", required=false) String search, @RequestParam(value = "offset", required=false) String offset, @RequestParam(value = "limit", required=false) String limit, Sort sort) throws Exception {

		if (offset == null) { offset = env.getProperty("fastCode.offset.default"); }
		if (limit == null) { limit = env.getProperty("fastCode.limit.default"); }

		if(sort == null || sort.isEmpty()) {
			sort = Sort.by(Sort.Direction.ASC, "addressId");
		}
		
		Pageable Pageable = new OffsetBasedPageRequest(Integer.parseInt(offset), Integer.parseInt(limit), sort);
		SearchCriteria searchCriteria = SearchUtils.generateSearchCriteriaObject(search);

		return ResponseEntity.ok(_addressAppService.find(searchCriteria,Pageable));
	}
	@RequestMapping(value = "/{id}/city", method = RequestMethod.GET, consumes = {"application/json"}, produces = {"application/json"})
	public ResponseEntity<GetCityOutput> getCity(@PathVariable String id) {
    	GetCityOutput output= _addressAppService.getCity(Integer.valueOf(id));
		Optional.ofNullable(output).orElseThrow(() -> new EntityNotFoundException(String.format("Not found")));

		return new ResponseEntity(output, HttpStatus.OK);
	}
	@RequestMapping(value = "/{id}/customers", method = RequestMethod.GET, consumes = {"application/json"}, produces = {"application/json"})
	public ResponseEntity getCustomers(@PathVariable String id, @RequestParam(value="search", required=false) String search, @RequestParam(value = "offset", required=false) String offset, @RequestParam(value = "limit", required=false) String limit, Sort sort)throws Exception {
   		if (offset == null) { offset = env.getProperty("fastCode.offset.default"); }
		if (limit == null) { limit = env.getProperty("fastCode.limit.default"); }

		if(sort == null || sort.isEmpty()) {
			sort = Sort.by(Sort.Direction.ASC, "customerId");
		}
		
		Pageable pageable = new OffsetBasedPageRequest(Integer.parseInt(offset), Integer.parseInt(limit), sort);

		SearchCriteria searchCriteria = SearchUtils.generateSearchCriteriaObject(search);
		Map<String,String> joinColDetails=_addressAppService.parseCustomersJoinColumn(id);
		Optional.ofNullable(joinColDetails).orElseThrow(() -> new EntityNotFoundException(String.format("Invalid join column")));

		searchCriteria.setJoinColumns(joinColDetails);

    	List<FindCustomerByIdOutput> output = _customerAppService.find(searchCriteria,pageable);
		Optional.ofNullable(output).orElseThrow(() -> new EntityNotFoundException(String.format("Not found")));

		return new ResponseEntity(output, HttpStatus.OK);
	}
	@RequestMapping(value = "/{id}/customUsers", method = RequestMethod.GET, consumes = {"application/json"}, produces = {"application/json"})
	public ResponseEntity getCustomUsers(@PathVariable String id, @RequestParam(value="search", required=false) String search, @RequestParam(value = "offset", required=false) String offset, @RequestParam(value = "limit", required=false) String limit, Sort sort)throws Exception {
   		if (offset == null) { offset = env.getProperty("fastCode.offset.default"); }
		if (limit == null) { limit = env.getProperty("fastCode.limit.default"); }

		if(sort == null || sort.isEmpty()) {
			sort = Sort.by(Sort.Direction.ASC, "firstName");
		}
		
		Pageable pageable = new OffsetBasedPageRequest(Integer.parseInt(offset), Integer.parseInt(limit), sort);

		SearchCriteria searchCriteria = SearchUtils.generateSearchCriteriaObject(search);
		Map<String,String> joinColDetails=_addressAppService.parseCustomUsersJoinColumn(id);
		Optional.ofNullable(joinColDetails).orElseThrow(() -> new EntityNotFoundException(String.format("Invalid join column")));

		searchCriteria.setJoinColumns(joinColDetails);

    	List<FindCustomUserByIdOutput> output = _customUserAppService.find(searchCriteria,pageable);
		Optional.ofNullable(output).orElseThrow(() -> new EntityNotFoundException(String.format("Not found")));

		return new ResponseEntity(output, HttpStatus.OK);
	}
	@RequestMapping(value = "/{id}/staffs", method = RequestMethod.GET, consumes = {"application/json"}, produces = {"application/json"})
	public ResponseEntity getStaffs(@PathVariable String id, @RequestParam(value="search", required=false) String search, @RequestParam(value = "offset", required=false) String offset, @RequestParam(value = "limit", required=false) String limit, Sort sort)throws Exception {
   		if (offset == null) { offset = env.getProperty("fastCode.offset.default"); }
		if (limit == null) { limit = env.getProperty("fastCode.limit.default"); }

		if(sort == null || sort.isEmpty()) {
			sort = Sort.by(Sort.Direction.ASC, "staffId");
		}
		
		Pageable pageable = new OffsetBasedPageRequest(Integer.parseInt(offset), Integer.parseInt(limit), sort);

		SearchCriteria searchCriteria = SearchUtils.generateSearchCriteriaObject(search);
		Map<String,String> joinColDetails=_addressAppService.parseStaffsJoinColumn(id);
		Optional.ofNullable(joinColDetails).orElseThrow(() -> new EntityNotFoundException(String.format("Invalid join column")));

		searchCriteria.setJoinColumns(joinColDetails);

    	List<FindStaffByIdOutput> output = _staffAppService.find(searchCriteria,pageable);
		Optional.ofNullable(output).orElseThrow(() -> new EntityNotFoundException(String.format("Not found")));

		return new ResponseEntity(output, HttpStatus.OK);
	}
	@RequestMapping(value = "/{id}/stores", method = RequestMethod.GET, consumes = {"application/json"}, produces = {"application/json"})
	public ResponseEntity getStores(@PathVariable String id, @RequestParam(value="search", required=false) String search, @RequestParam(value = "offset", required=false) String offset, @RequestParam(value = "limit", required=false) String limit, Sort sort)throws Exception {
   		if (offset == null) { offset = env.getProperty("fastCode.offset.default"); }
		if (limit == null) { limit = env.getProperty("fastCode.limit.default"); }

		if(sort == null || sort.isEmpty()) {
			sort = Sort.by(Sort.Direction.ASC, "storeId");
		}
		
		Pageable pageable = new OffsetBasedPageRequest(Integer.parseInt(offset), Integer.parseInt(limit), sort);

		SearchCriteria searchCriteria = SearchUtils.generateSearchCriteriaObject(search);
		Map<String,String> joinColDetails=_addressAppService.parseStoresJoinColumn(id);
		Optional.ofNullable(joinColDetails).orElseThrow(() -> new EntityNotFoundException(String.format("Invalid join column")));

		searchCriteria.setJoinColumns(joinColDetails);

    	List<FindStoreByIdOutput> output = _storeAppService.find(searchCriteria,pageable);
		Optional.ofNullable(output).orElseThrow(() -> new EntityNotFoundException(String.format("Not found")));

		return new ResponseEntity(output, HttpStatus.OK);
	}

}



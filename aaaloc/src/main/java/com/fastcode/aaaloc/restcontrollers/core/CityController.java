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
import com.fastcode.aaaloc.application.core.city.ICityAppService;
import com.fastcode.aaaloc.application.core.city.dto.*;
import com.fastcode.aaaloc.application.core.address.IAddressAppService;
import com.fastcode.aaaloc.application.core.address.dto.FindAddressByIdOutput;
import com.fastcode.aaaloc.application.core.country.ICountryAppService;
import java.util.*;
import java.time.*;
import com.fastcode.aaaloc.commons.logging.LoggingHelper;

@RestController
@RequestMapping("/city")
@RequiredArgsConstructor
public class CityController {

	@Qualifier("cityAppService")
	@NonNull protected final ICityAppService _cityAppService;

    @Qualifier("addressAppService")
	@NonNull  protected final IAddressAppService  _addressAppService;

    @Qualifier("countryAppService")
	@NonNull  protected final ICountryAppService  _countryAppService;

	@NonNull protected final LoggingHelper logHelper;

	@NonNull protected final Environment env;

	@RequestMapping(method = RequestMethod.POST, consumes = {"application/json"}, produces = {"application/json"})
	public ResponseEntity<CreateCityOutput> create(@RequestBody @Valid CreateCityInput city) {
		CreateCityOutput output=_cityAppService.create(city);
		Optional.ofNullable(output).orElseThrow(() -> new EntityNotFoundException(String.format("No record found")));

		return new ResponseEntity(output, HttpStatus.OK);
	}

	// ------------ Delete city ------------
	@ResponseStatus(value = HttpStatus.NO_CONTENT)
	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE, consumes = {"application/json"})
	public void delete(@PathVariable String id) {

    	FindCityByIdOutput output = _cityAppService.findById(Integer.valueOf(id));
    	Optional.ofNullable(output).orElseThrow(() -> new EntityNotFoundException(String.format("There does not exist a city with a id=%s", id)));

    	_cityAppService.delete(Integer.valueOf(id));
    }


	// ------------ Update city ------------
	@RequestMapping(value = "/{id}", method = RequestMethod.PUT, consumes = {"application/json"}, produces = {"application/json"})
	public ResponseEntity<UpdateCityOutput> update(@PathVariable String id, @RequestBody @Valid UpdateCityInput city) {

	    FindCityByIdOutput currentCity = _cityAppService.findById(Integer.valueOf(id));
		Optional.ofNullable(currentCity).orElseThrow(() -> new EntityNotFoundException(String.format("Unable to update. City with id=%s not found.", id)));


		city.setVersiono(currentCity.getVersiono());
	    UpdateCityOutput output = _cityAppService.update(Integer.valueOf(id),city);
		Optional.ofNullable(output).orElseThrow(() -> new EntityNotFoundException(String.format("No record found")));
		return new ResponseEntity(output, HttpStatus.OK);
	}


	@RequestMapping(value = "/{id}", method = RequestMethod.GET, consumes = {"application/json"}, produces = {"application/json"})
	public ResponseEntity<FindCityByIdOutput> findById(@PathVariable String id) {

    	FindCityByIdOutput output = _cityAppService.findById(Integer.valueOf(id));
    	Optional.ofNullable(output).orElseThrow(() -> new EntityNotFoundException(String.format("Not found")));

		return new ResponseEntity(output, HttpStatus.OK);
	}

	@RequestMapping(method = RequestMethod.GET, consumes = {"application/json"}, produces = {"application/json"})
	public ResponseEntity find(@RequestParam(value="search", required=false) String search, @RequestParam(value = "offset", required=false) String offset, @RequestParam(value = "limit", required=false) String limit, Sort sort) throws Exception {

		if (offset == null) { offset = env.getProperty("fastCode.offset.default"); }
		if (limit == null) { limit = env.getProperty("fastCode.limit.default"); }

		if(sort == null || sort.isEmpty()) {
			sort = Sort.by(Sort.Direction.ASC, "cityId");
		}
		
		Pageable Pageable = new OffsetBasedPageRequest(Integer.parseInt(offset), Integer.parseInt(limit), sort);
		SearchCriteria searchCriteria = SearchUtils.generateSearchCriteriaObject(search);

		return ResponseEntity.ok(_cityAppService.find(searchCriteria,Pageable));
	}
	@RequestMapping(value = "/{id}/address", method = RequestMethod.GET, consumes = {"application/json"}, produces = {"application/json"})
	public ResponseEntity getAddress(@PathVariable String id, @RequestParam(value="search", required=false) String search, @RequestParam(value = "offset", required=false) String offset, @RequestParam(value = "limit", required=false) String limit, Sort sort)throws Exception {
   		if (offset == null) { offset = env.getProperty("fastCode.offset.default"); }
		if (limit == null) { limit = env.getProperty("fastCode.limit.default"); }

		if(sort == null || sort.isEmpty()) {
			sort = Sort.by(Sort.Direction.ASC, "addressId");
		}
		
		Pageable pageable = new OffsetBasedPageRequest(Integer.parseInt(offset), Integer.parseInt(limit), sort);

		SearchCriteria searchCriteria = SearchUtils.generateSearchCriteriaObject(search);
		Map<String,String> joinColDetails=_cityAppService.parseAddressJoinColumn(id);
		Optional.ofNullable(joinColDetails).orElseThrow(() -> new EntityNotFoundException(String.format("Invalid join column")));

		searchCriteria.setJoinColumns(joinColDetails);

    	List<FindAddressByIdOutput> output = _addressAppService.find(searchCriteria,pageable);
		Optional.ofNullable(output).orElseThrow(() -> new EntityNotFoundException(String.format("Not found")));

		return new ResponseEntity(output, HttpStatus.OK);
	}
	@RequestMapping(value = "/{id}/country", method = RequestMethod.GET, consumes = {"application/json"}, produces = {"application/json"})
	public ResponseEntity<GetCountryOutput> getCountry(@PathVariable String id) {
    	GetCountryOutput output= _cityAppService.getCountry(Integer.valueOf(id));
		Optional.ofNullable(output).orElseThrow(() -> new EntityNotFoundException(String.format("Not found")));

		return new ResponseEntity(output, HttpStatus.OK);
	}

}



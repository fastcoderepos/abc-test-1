package com.fastcode.aaaloc.application.core.city;

import org.springframework.data.domain.Pageable;
import com.fastcode.aaaloc.application.core.city.dto.*;
import com.fastcode.aaaloc.commons.search.SearchCriteria;

import java.util.*;

public interface ICityAppService {
	
	//CRUD Operations
	
	CreateCityOutput create(CreateCityInput city);

    void delete(Integer id);

    UpdateCityOutput update(Integer id, UpdateCityInput input);

    FindCityByIdOutput findById(Integer id);

    List<FindCityByIdOutput> find(SearchCriteria search, Pageable pageable) throws Exception;
	//Relationship Operations
    
    GetCountryOutput getCountry(Integer cityid);
    
    //Join Column Parsers

	Map<String,String> parseAddressJoinColumn(String keysString);
}


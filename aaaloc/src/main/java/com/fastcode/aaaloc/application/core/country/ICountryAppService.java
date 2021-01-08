package com.fastcode.aaaloc.application.core.country;

import org.springframework.data.domain.Pageable;
import com.fastcode.aaaloc.application.core.country.dto.*;
import com.fastcode.aaaloc.commons.search.SearchCriteria;

import java.util.*;

public interface ICountryAppService {
	
	//CRUD Operations
	
	CreateCountryOutput create(CreateCountryInput country);

    void delete(Integer id);

    UpdateCountryOutput update(Integer id, UpdateCountryInput input);

    FindCountryByIdOutput findById(Integer id);

    List<FindCountryByIdOutput> find(SearchCriteria search, Pageable pageable) throws Exception;
    
    //Join Column Parsers

	Map<String,String> parseCitysJoinColumn(String keysString);
}


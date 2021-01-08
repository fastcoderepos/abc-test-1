package com.fastcode.aaaloc.application.core.staff;

import org.springframework.data.domain.Pageable;
import com.fastcode.aaaloc.application.core.staff.dto.*;
import com.fastcode.aaaloc.commons.search.SearchCriteria;

import java.util.*;

public interface IStaffAppService {
	
	//CRUD Operations
	
	CreateStaffOutput create(CreateStaffInput staff);

    void delete(Integer id);

    UpdateStaffOutput update(Integer id, UpdateStaffInput input);

    FindStaffByIdOutput findById(Integer id);

    List<FindStaffByIdOutput> find(SearchCriteria search, Pageable pageable) throws Exception;
	//Relationship Operations
	//Relationship Operations
    
    GetAddressOutput getAddress(Integer staffid);
    
    GetStoreOutput getStore(Integer staffid);
    
    //Join Column Parsers

	Map<String,String> parsePaymentsJoinColumn(String keysString);

	Map<String,String> parseRentalsJoinColumn(String keysString);
}


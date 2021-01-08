package com.fastcode.aaaloc.application.core.customuser;

import com.fastcode.aaaloc.domain.core.customuser.CustomUserId;
import org.springframework.data.domain.Pageable;
import com.fastcode.aaaloc.application.core.customuser.dto.*;
import com.fastcode.aaaloc.commons.search.SearchCriteria;

import java.util.*;

public interface ICustomUserAppService {
	
	//CRUD Operations
	
	CreateCustomUserOutput create(CreateCustomUserInput customuser);

    void delete(CustomUserId customUserId);

    UpdateCustomUserOutput update(CustomUserId customUserId, UpdateCustomUserInput input);

    FindCustomUserByIdOutput findById(CustomUserId customUserId);

    List<FindCustomUserByIdOutput> find(SearchCriteria search, Pageable pageable) throws Exception;
	//Relationship Operations
    
    GetAddressOutput getAddress(CustomUserId customUserId);
    
    //Join Column Parsers
    
	CustomUserId parseCustomUserKey(String keysString);
}


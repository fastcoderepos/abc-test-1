package com.fastcode.aaaloc.application.core.actor;

import org.springframework.data.domain.Pageable;
import com.fastcode.aaaloc.application.core.actor.dto.*;
import com.fastcode.aaaloc.commons.search.SearchCriteria;

import java.util.*;

public interface IActorAppService {
	
	//CRUD Operations
	
	CreateActorOutput create(CreateActorInput actor);

    void delete(Integer id);

    UpdateActorOutput update(Integer id, UpdateActorInput input);

    FindActorByIdOutput findById(Integer id);

    List<FindActorByIdOutput> find(SearchCriteria search, Pageable pageable) throws Exception;
    
    //Join Column Parsers

	Map<String,String> parseFilmActorsJoinColumn(String keysString);
}


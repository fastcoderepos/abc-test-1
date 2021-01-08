package com.fastcode.aaaloc.application.core.inventory;

import org.springframework.data.domain.Pageable;
import com.fastcode.aaaloc.application.core.inventory.dto.*;
import com.fastcode.aaaloc.commons.search.SearchCriteria;

import java.util.*;

public interface IInventoryAppService {
	
	//CRUD Operations
	
	CreateInventoryOutput create(CreateInventoryInput inventory);

    void delete(Integer id);

    UpdateInventoryOutput update(Integer id, UpdateInventoryInput input);

    FindInventoryByIdOutput findById(Integer id);

    List<FindInventoryByIdOutput> find(SearchCriteria search, Pageable pageable) throws Exception;
	//Relationship Operations
    
    GetFilmOutput getFilm(Integer inventoryid);
    
    //Join Column Parsers

	Map<String,String> parseRentalsJoinColumn(String keysString);
}


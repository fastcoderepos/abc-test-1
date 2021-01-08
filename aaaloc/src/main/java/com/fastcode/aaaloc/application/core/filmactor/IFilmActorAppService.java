package com.fastcode.aaaloc.application.core.filmactor;

import com.fastcode.aaaloc.domain.core.filmactor.FilmActorId;
import org.springframework.data.domain.Pageable;
import com.fastcode.aaaloc.application.core.filmactor.dto.*;
import com.fastcode.aaaloc.commons.search.SearchCriteria;

import java.util.*;

public interface IFilmActorAppService {
	
	//CRUD Operations
	
	CreateFilmActorOutput create(CreateFilmActorInput filmactor);

    void delete(FilmActorId filmActorId);

    UpdateFilmActorOutput update(FilmActorId filmActorId, UpdateFilmActorInput input);

    FindFilmActorByIdOutput findById(FilmActorId filmActorId);

    List<FindFilmActorByIdOutput> find(SearchCriteria search, Pageable pageable) throws Exception;
	//Relationship Operations
	//Relationship Operations
    
    GetActorOutput getActor(FilmActorId filmActorId);
    
    GetFilmOutput getFilm(FilmActorId filmActorId);
    
    //Join Column Parsers
    
	FilmActorId parseFilmActorKey(String keysString);
}


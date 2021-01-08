package com.fastcode.aaaloc.application.extended.filmactor;

import org.springframework.stereotype.Service;
import com.fastcode.aaaloc.application.core.filmactor.FilmActorAppService;

import com.fastcode.aaaloc.domain.extended.filmactor.IFilmActorRepositoryExtended;
import com.fastcode.aaaloc.domain.extended.actor.IActorRepositoryExtended;
import com.fastcode.aaaloc.domain.extended.film.IFilmRepositoryExtended;
import com.fastcode.aaaloc.commons.logging.LoggingHelper;

@Service("filmActorAppServiceExtended")
public class FilmActorAppServiceExtended extends FilmActorAppService implements IFilmActorAppServiceExtended {

	public FilmActorAppServiceExtended(IFilmActorRepositoryExtended filmActorRepositoryExtended,
				IActorRepositoryExtended actorRepositoryExtended,IFilmRepositoryExtended filmRepositoryExtended,IFilmActorMapperExtended mapper,LoggingHelper logHelper) {

		super(filmActorRepositoryExtended,
		actorRepositoryExtended,filmRepositoryExtended,mapper,logHelper);

	}

 	//Add your custom code here
 
}


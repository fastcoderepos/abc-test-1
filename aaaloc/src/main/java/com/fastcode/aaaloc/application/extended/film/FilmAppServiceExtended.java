package com.fastcode.aaaloc.application.extended.film;

import org.springframework.stereotype.Service;
import com.fastcode.aaaloc.application.core.film.FilmAppService;

import com.fastcode.aaaloc.domain.extended.film.IFilmRepositoryExtended;
import com.fastcode.aaaloc.domain.extended.language.ILanguageRepositoryExtended;
import com.fastcode.aaaloc.commons.logging.LoggingHelper;

@Service("filmAppServiceExtended")
public class FilmAppServiceExtended extends FilmAppService implements IFilmAppServiceExtended {

	public FilmAppServiceExtended(IFilmRepositoryExtended filmRepositoryExtended,
				ILanguageRepositoryExtended languageRepositoryExtended,IFilmMapperExtended mapper,LoggingHelper logHelper) {

		super(filmRepositoryExtended,
		languageRepositoryExtended,mapper,logHelper);

	}

 	//Add your custom code here
 
}


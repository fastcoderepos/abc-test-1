package com.fastcode.aaaloc.application.extended.filmcategory;

import org.springframework.stereotype.Service;
import com.fastcode.aaaloc.application.core.filmcategory.FilmCategoryAppService;

import com.fastcode.aaaloc.domain.extended.filmcategory.IFilmCategoryRepositoryExtended;
import com.fastcode.aaaloc.domain.extended.category.ICategoryRepositoryExtended;
import com.fastcode.aaaloc.domain.extended.film.IFilmRepositoryExtended;
import com.fastcode.aaaloc.commons.logging.LoggingHelper;

@Service("filmCategoryAppServiceExtended")
public class FilmCategoryAppServiceExtended extends FilmCategoryAppService implements IFilmCategoryAppServiceExtended {

	public FilmCategoryAppServiceExtended(IFilmCategoryRepositoryExtended filmCategoryRepositoryExtended,
				ICategoryRepositoryExtended categoryRepositoryExtended,IFilmRepositoryExtended filmRepositoryExtended,IFilmCategoryMapperExtended mapper,LoggingHelper logHelper) {

		super(filmCategoryRepositoryExtended,
		categoryRepositoryExtended,filmRepositoryExtended,mapper,logHelper);

	}

 	//Add your custom code here
 
}


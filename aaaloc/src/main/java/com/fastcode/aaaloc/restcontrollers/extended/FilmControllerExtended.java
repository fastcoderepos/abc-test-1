package com.fastcode.aaaloc.restcontrollers.extended;

import org.springframework.web.bind.annotation.*;
import com.fastcode.aaaloc.restcontrollers.core.FilmController;
import com.fastcode.aaaloc.application.extended.film.IFilmAppServiceExtended;
import com.fastcode.aaaloc.application.extended.filmactor.IFilmActorAppServiceExtended;
import com.fastcode.aaaloc.application.extended.filmcategory.IFilmCategoryAppServiceExtended;
import com.fastcode.aaaloc.application.extended.inventory.IInventoryAppServiceExtended;
import com.fastcode.aaaloc.application.extended.language.ILanguageAppServiceExtended;
import org.springframework.core.env.Environment;
import com.fastcode.aaaloc.commons.logging.LoggingHelper;

@RestController
@RequestMapping("/film/extended")
public class FilmControllerExtended extends FilmController {

		public FilmControllerExtended(IFilmAppServiceExtended filmAppServiceExtended, IFilmActorAppServiceExtended filmActorAppServiceExtended, IFilmCategoryAppServiceExtended filmCategoryAppServiceExtended, IInventoryAppServiceExtended inventoryAppServiceExtended, ILanguageAppServiceExtended languageAppServiceExtended,
	     LoggingHelper helper, Environment env) {
		super(
		filmAppServiceExtended,
    	filmActorAppServiceExtended,
    	filmCategoryAppServiceExtended,
    	inventoryAppServiceExtended,
    	languageAppServiceExtended,
		helper, env);
	}

	//Add your custom code here

}


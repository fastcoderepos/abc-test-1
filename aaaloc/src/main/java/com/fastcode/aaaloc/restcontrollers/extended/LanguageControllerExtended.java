package com.fastcode.aaaloc.restcontrollers.extended;

import org.springframework.web.bind.annotation.*;
import com.fastcode.aaaloc.restcontrollers.core.LanguageController;
import com.fastcode.aaaloc.application.extended.language.ILanguageAppServiceExtended;
import com.fastcode.aaaloc.application.extended.film.IFilmAppServiceExtended;
import org.springframework.core.env.Environment;
import com.fastcode.aaaloc.commons.logging.LoggingHelper;

@RestController
@RequestMapping("/language/extended")
public class LanguageControllerExtended extends LanguageController {

		public LanguageControllerExtended(ILanguageAppServiceExtended languageAppServiceExtended, IFilmAppServiceExtended filmAppServiceExtended,
	     LoggingHelper helper, Environment env) {
		super(
		languageAppServiceExtended,
    	filmAppServiceExtended,
		helper, env);
	}

	//Add your custom code here

}


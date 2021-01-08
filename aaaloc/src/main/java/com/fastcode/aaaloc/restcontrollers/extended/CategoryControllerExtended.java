package com.fastcode.aaaloc.restcontrollers.extended;

import org.springframework.web.bind.annotation.*;
import com.fastcode.aaaloc.restcontrollers.core.CategoryController;
import com.fastcode.aaaloc.application.extended.category.ICategoryAppServiceExtended;
import com.fastcode.aaaloc.application.extended.filmcategory.IFilmCategoryAppServiceExtended;
import org.springframework.core.env.Environment;
import com.fastcode.aaaloc.commons.logging.LoggingHelper;

@RestController
@RequestMapping("/category/extended")
public class CategoryControllerExtended extends CategoryController {

		public CategoryControllerExtended(ICategoryAppServiceExtended categoryAppServiceExtended, IFilmCategoryAppServiceExtended filmCategoryAppServiceExtended,
	     LoggingHelper helper, Environment env) {
		super(
		categoryAppServiceExtended,
    	filmCategoryAppServiceExtended,
		helper, env);
	}

	//Add your custom code here

}


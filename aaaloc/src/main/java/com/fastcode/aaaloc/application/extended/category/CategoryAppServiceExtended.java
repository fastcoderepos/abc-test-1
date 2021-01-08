package com.fastcode.aaaloc.application.extended.category;

import org.springframework.stereotype.Service;
import com.fastcode.aaaloc.application.core.category.CategoryAppService;

import com.fastcode.aaaloc.domain.extended.category.ICategoryRepositoryExtended;
import com.fastcode.aaaloc.commons.logging.LoggingHelper;

@Service("categoryAppServiceExtended")
public class CategoryAppServiceExtended extends CategoryAppService implements ICategoryAppServiceExtended {

	public CategoryAppServiceExtended(ICategoryRepositoryExtended categoryRepositoryExtended,
				ICategoryMapperExtended mapper,LoggingHelper logHelper) {

		super(categoryRepositoryExtended,
		mapper,logHelper);

	}

 	//Add your custom code here
 
}


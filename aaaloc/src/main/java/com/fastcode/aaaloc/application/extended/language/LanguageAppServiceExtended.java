package com.fastcode.aaaloc.application.extended.language;

import org.springframework.stereotype.Service;
import com.fastcode.aaaloc.application.core.language.LanguageAppService;

import com.fastcode.aaaloc.domain.extended.language.ILanguageRepositoryExtended;
import com.fastcode.aaaloc.commons.logging.LoggingHelper;

@Service("languageAppServiceExtended")
public class LanguageAppServiceExtended extends LanguageAppService implements ILanguageAppServiceExtended {

	public LanguageAppServiceExtended(ILanguageRepositoryExtended languageRepositoryExtended,
				ILanguageMapperExtended mapper,LoggingHelper logHelper) {

		super(languageRepositoryExtended,
		mapper,logHelper);

	}

 	//Add your custom code here
 
}


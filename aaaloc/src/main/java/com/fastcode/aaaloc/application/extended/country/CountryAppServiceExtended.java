package com.fastcode.aaaloc.application.extended.country;

import org.springframework.stereotype.Service;
import com.fastcode.aaaloc.application.core.country.CountryAppService;

import com.fastcode.aaaloc.domain.extended.country.ICountryRepositoryExtended;
import com.fastcode.aaaloc.commons.logging.LoggingHelper;

@Service("countryAppServiceExtended")
public class CountryAppServiceExtended extends CountryAppService implements ICountryAppServiceExtended {

	public CountryAppServiceExtended(ICountryRepositoryExtended countryRepositoryExtended,
				ICountryMapperExtended mapper,LoggingHelper logHelper) {

		super(countryRepositoryExtended,
		mapper,logHelper);

	}

 	//Add your custom code here
 
}


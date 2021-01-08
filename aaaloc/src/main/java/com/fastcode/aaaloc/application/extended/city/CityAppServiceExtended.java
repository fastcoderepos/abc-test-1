package com.fastcode.aaaloc.application.extended.city;

import org.springframework.stereotype.Service;
import com.fastcode.aaaloc.application.core.city.CityAppService;

import com.fastcode.aaaloc.domain.extended.city.ICityRepositoryExtended;
import com.fastcode.aaaloc.domain.extended.country.ICountryRepositoryExtended;
import com.fastcode.aaaloc.commons.logging.LoggingHelper;

@Service("cityAppServiceExtended")
public class CityAppServiceExtended extends CityAppService implements ICityAppServiceExtended {

	public CityAppServiceExtended(ICityRepositoryExtended cityRepositoryExtended,
				ICountryRepositoryExtended countryRepositoryExtended,ICityMapperExtended mapper,LoggingHelper logHelper) {

		super(cityRepositoryExtended,
		countryRepositoryExtended,mapper,logHelper);

	}

 	//Add your custom code here
 
}


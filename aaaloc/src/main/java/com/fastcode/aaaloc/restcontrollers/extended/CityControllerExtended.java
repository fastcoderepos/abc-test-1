package com.fastcode.aaaloc.restcontrollers.extended;

import org.springframework.web.bind.annotation.*;
import com.fastcode.aaaloc.restcontrollers.core.CityController;
import com.fastcode.aaaloc.application.extended.city.ICityAppServiceExtended;
import com.fastcode.aaaloc.application.extended.address.IAddressAppServiceExtended;
import com.fastcode.aaaloc.application.extended.country.ICountryAppServiceExtended;
import org.springframework.core.env.Environment;
import com.fastcode.aaaloc.commons.logging.LoggingHelper;

@RestController
@RequestMapping("/city/extended")
public class CityControllerExtended extends CityController {

		public CityControllerExtended(ICityAppServiceExtended cityAppServiceExtended, IAddressAppServiceExtended addressAppServiceExtended, ICountryAppServiceExtended countryAppServiceExtended,
	     LoggingHelper helper, Environment env) {
		super(
		cityAppServiceExtended,
    	addressAppServiceExtended,
    	countryAppServiceExtended,
		helper, env);
	}

	//Add your custom code here

}


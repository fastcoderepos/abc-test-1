package com.fastcode.aaaloc.restcontrollers.extended;

import org.springframework.web.bind.annotation.*;
import com.fastcode.aaaloc.restcontrollers.core.AddressController;
import com.fastcode.aaaloc.application.extended.address.IAddressAppServiceExtended;
import com.fastcode.aaaloc.application.extended.city.ICityAppServiceExtended;
import com.fastcode.aaaloc.application.extended.customer.ICustomerAppServiceExtended;
import com.fastcode.aaaloc.application.extended.customuser.ICustomUserAppServiceExtended;
import com.fastcode.aaaloc.application.extended.staff.IStaffAppServiceExtended;
import com.fastcode.aaaloc.application.extended.store.IStoreAppServiceExtended;
import org.springframework.core.env.Environment;
import com.fastcode.aaaloc.commons.logging.LoggingHelper;

@RestController
@RequestMapping("/address/extended")
public class AddressControllerExtended extends AddressController {

		public AddressControllerExtended(IAddressAppServiceExtended addressAppServiceExtended, ICityAppServiceExtended cityAppServiceExtended, ICustomerAppServiceExtended customerAppServiceExtended, ICustomUserAppServiceExtended customUserAppServiceExtended, IStaffAppServiceExtended staffAppServiceExtended, IStoreAppServiceExtended storeAppServiceExtended,
	     LoggingHelper helper, Environment env) {
		super(
		addressAppServiceExtended,
    	cityAppServiceExtended,
    	customerAppServiceExtended,
    	customUserAppServiceExtended,
    	staffAppServiceExtended,
    	storeAppServiceExtended,
		helper, env);
	}

	//Add your custom code here

}


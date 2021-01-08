package com.fastcode.aaaloc.restcontrollers.extended;

import org.springframework.web.bind.annotation.*;
import com.fastcode.aaaloc.restcontrollers.core.StaffController;
import com.fastcode.aaaloc.application.extended.staff.IStaffAppServiceExtended;
import com.fastcode.aaaloc.application.extended.address.IAddressAppServiceExtended;
import com.fastcode.aaaloc.application.extended.payment.IPaymentAppServiceExtended;
import com.fastcode.aaaloc.application.extended.rental.IRentalAppServiceExtended;
import com.fastcode.aaaloc.application.extended.store.IStoreAppServiceExtended;
import org.springframework.core.env.Environment;
import com.fastcode.aaaloc.commons.logging.LoggingHelper;

@RestController
@RequestMapping("/staff/extended")
public class StaffControllerExtended extends StaffController {

		public StaffControllerExtended(IStaffAppServiceExtended staffAppServiceExtended, IAddressAppServiceExtended addressAppServiceExtended, IPaymentAppServiceExtended paymentAppServiceExtended, IRentalAppServiceExtended rentalAppServiceExtended, IStoreAppServiceExtended storeAppServiceExtended,
	     LoggingHelper helper, Environment env) {
		super(
		staffAppServiceExtended,
    	addressAppServiceExtended,
    	paymentAppServiceExtended,
    	rentalAppServiceExtended,
    	storeAppServiceExtended,
		helper, env);
	}

	//Add your custom code here

}


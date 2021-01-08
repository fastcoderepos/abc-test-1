package com.fastcode.aaaloc.restcontrollers.extended;

import org.springframework.web.bind.annotation.*;
import com.fastcode.aaaloc.restcontrollers.core.CustomUserController;
import com.fastcode.aaaloc.application.extended.customuser.ICustomUserAppServiceExtended;
import com.fastcode.aaaloc.application.extended.address.IAddressAppServiceExtended;
import org.springframework.core.env.Environment;
import com.fastcode.aaaloc.commons.logging.LoggingHelper;

@RestController
@RequestMapping("/customUser/extended")
public class CustomUserControllerExtended extends CustomUserController {

		public CustomUserControllerExtended(ICustomUserAppServiceExtended customUserAppServiceExtended, IAddressAppServiceExtended addressAppServiceExtended,
	     LoggingHelper helper, Environment env) {
		super(
		customUserAppServiceExtended,
    	addressAppServiceExtended,
		helper, env);
	}

	//Add your custom code here

}


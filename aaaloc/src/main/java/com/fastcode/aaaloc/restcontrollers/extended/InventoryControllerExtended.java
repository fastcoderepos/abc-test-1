package com.fastcode.aaaloc.restcontrollers.extended;

import org.springframework.web.bind.annotation.*;
import com.fastcode.aaaloc.restcontrollers.core.InventoryController;
import com.fastcode.aaaloc.application.extended.inventory.IInventoryAppServiceExtended;
import com.fastcode.aaaloc.application.extended.film.IFilmAppServiceExtended;
import com.fastcode.aaaloc.application.extended.rental.IRentalAppServiceExtended;
import org.springframework.core.env.Environment;
import com.fastcode.aaaloc.commons.logging.LoggingHelper;

@RestController
@RequestMapping("/inventory/extended")
public class InventoryControllerExtended extends InventoryController {

		public InventoryControllerExtended(IInventoryAppServiceExtended inventoryAppServiceExtended, IFilmAppServiceExtended filmAppServiceExtended, IRentalAppServiceExtended rentalAppServiceExtended,
	     LoggingHelper helper, Environment env) {
		super(
		inventoryAppServiceExtended,
    	filmAppServiceExtended,
    	rentalAppServiceExtended,
		helper, env);
	}

	//Add your custom code here

}


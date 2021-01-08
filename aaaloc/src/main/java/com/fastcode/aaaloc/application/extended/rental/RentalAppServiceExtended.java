package com.fastcode.aaaloc.application.extended.rental;

import org.springframework.stereotype.Service;
import com.fastcode.aaaloc.application.core.rental.RentalAppService;

import com.fastcode.aaaloc.domain.extended.rental.IRentalRepositoryExtended;
import com.fastcode.aaaloc.domain.extended.customer.ICustomerRepositoryExtended;
import com.fastcode.aaaloc.domain.extended.inventory.IInventoryRepositoryExtended;
import com.fastcode.aaaloc.domain.extended.staff.IStaffRepositoryExtended;
import com.fastcode.aaaloc.commons.logging.LoggingHelper;

@Service("rentalAppServiceExtended")
public class RentalAppServiceExtended extends RentalAppService implements IRentalAppServiceExtended {

	public RentalAppServiceExtended(IRentalRepositoryExtended rentalRepositoryExtended,
				ICustomerRepositoryExtended customerRepositoryExtended,IInventoryRepositoryExtended inventoryRepositoryExtended,IStaffRepositoryExtended staffRepositoryExtended,IRentalMapperExtended mapper,LoggingHelper logHelper) {

		super(rentalRepositoryExtended,
		customerRepositoryExtended,inventoryRepositoryExtended,staffRepositoryExtended,mapper,logHelper);

	}

 	//Add your custom code here
 
}


package com.fastcode.aaaloc.application.extended.customer;

import org.springframework.stereotype.Service;
import com.fastcode.aaaloc.application.core.customer.CustomerAppService;

import com.fastcode.aaaloc.domain.extended.customer.ICustomerRepositoryExtended;
import com.fastcode.aaaloc.domain.extended.address.IAddressRepositoryExtended;
import com.fastcode.aaaloc.commons.logging.LoggingHelper;

@Service("customerAppServiceExtended")
public class CustomerAppServiceExtended extends CustomerAppService implements ICustomerAppServiceExtended {

	public CustomerAppServiceExtended(ICustomerRepositoryExtended customerRepositoryExtended,
				IAddressRepositoryExtended addressRepositoryExtended,ICustomerMapperExtended mapper,LoggingHelper logHelper) {

		super(customerRepositoryExtended,
		addressRepositoryExtended,mapper,logHelper);

	}

 	//Add your custom code here
 
}


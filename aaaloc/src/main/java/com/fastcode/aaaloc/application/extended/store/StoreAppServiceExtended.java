package com.fastcode.aaaloc.application.extended.store;

import org.springframework.stereotype.Service;
import com.fastcode.aaaloc.application.core.store.StoreAppService;

import com.fastcode.aaaloc.domain.extended.store.IStoreRepositoryExtended;
import com.fastcode.aaaloc.domain.extended.address.IAddressRepositoryExtended;
import com.fastcode.aaaloc.domain.extended.staff.IStaffRepositoryExtended;
import com.fastcode.aaaloc.commons.logging.LoggingHelper;

@Service("storeAppServiceExtended")
public class StoreAppServiceExtended extends StoreAppService implements IStoreAppServiceExtended {

	public StoreAppServiceExtended(IStoreRepositoryExtended storeRepositoryExtended,
				IAddressRepositoryExtended addressRepositoryExtended,IStaffRepositoryExtended staffRepositoryExtended,IStoreMapperExtended mapper,LoggingHelper logHelper) {

		super(storeRepositoryExtended,
		addressRepositoryExtended,staffRepositoryExtended,mapper,logHelper);

	}

 	//Add your custom code here
 
}


package com.fastcode.aaaloc.application.extended.staff;

import org.springframework.stereotype.Service;
import com.fastcode.aaaloc.application.core.staff.StaffAppService;

import com.fastcode.aaaloc.domain.extended.staff.IStaffRepositoryExtended;
import com.fastcode.aaaloc.domain.extended.address.IAddressRepositoryExtended;
import com.fastcode.aaaloc.domain.extended.store.IStoreRepositoryExtended;
import com.fastcode.aaaloc.commons.logging.LoggingHelper;

@Service("staffAppServiceExtended")
public class StaffAppServiceExtended extends StaffAppService implements IStaffAppServiceExtended {

	public StaffAppServiceExtended(IStaffRepositoryExtended staffRepositoryExtended,
				IAddressRepositoryExtended addressRepositoryExtended,IStoreRepositoryExtended storeRepositoryExtended,IStaffMapperExtended mapper,LoggingHelper logHelper) {

		super(staffRepositoryExtended,
		addressRepositoryExtended,storeRepositoryExtended,mapper,logHelper);

	}

 	//Add your custom code here
 
}


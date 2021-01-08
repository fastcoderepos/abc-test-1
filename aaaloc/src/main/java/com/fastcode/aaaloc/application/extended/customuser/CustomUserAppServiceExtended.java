package com.fastcode.aaaloc.application.extended.customuser;

import org.springframework.stereotype.Service;
import com.fastcode.aaaloc.application.core.customuser.CustomUserAppService;

import com.fastcode.aaaloc.domain.extended.customuser.ICustomUserRepositoryExtended;
import com.fastcode.aaaloc.domain.extended.address.IAddressRepositoryExtended;
import com.fastcode.aaaloc.commons.logging.LoggingHelper;

@Service("customUserAppServiceExtended")
public class CustomUserAppServiceExtended extends CustomUserAppService implements ICustomUserAppServiceExtended {

	public CustomUserAppServiceExtended(ICustomUserRepositoryExtended customUserRepositoryExtended,
				IAddressRepositoryExtended addressRepositoryExtended,ICustomUserMapperExtended mapper,LoggingHelper logHelper) {

		super(customUserRepositoryExtended,
		addressRepositoryExtended,mapper,logHelper);

	}

 	//Add your custom code here
 
}


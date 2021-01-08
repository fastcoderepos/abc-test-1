package com.fastcode.aaaloc.application.extended.inventory;

import org.springframework.stereotype.Service;
import com.fastcode.aaaloc.application.core.inventory.InventoryAppService;

import com.fastcode.aaaloc.domain.extended.inventory.IInventoryRepositoryExtended;
import com.fastcode.aaaloc.domain.extended.film.IFilmRepositoryExtended;
import com.fastcode.aaaloc.commons.logging.LoggingHelper;

@Service("inventoryAppServiceExtended")
public class InventoryAppServiceExtended extends InventoryAppService implements IInventoryAppServiceExtended {

	public InventoryAppServiceExtended(IInventoryRepositoryExtended inventoryRepositoryExtended,
				IFilmRepositoryExtended filmRepositoryExtended,IInventoryMapperExtended mapper,LoggingHelper logHelper) {

		super(inventoryRepositoryExtended,
		filmRepositoryExtended,mapper,logHelper);

	}

 	//Add your custom code here
 
}


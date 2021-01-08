package com.fastcode.aaaloc.application.extended.actor;

import org.springframework.stereotype.Service;
import com.fastcode.aaaloc.application.core.actor.ActorAppService;

import com.fastcode.aaaloc.domain.extended.actor.IActorRepositoryExtended;
import com.fastcode.aaaloc.commons.logging.LoggingHelper;

@Service("actorAppServiceExtended")
public class ActorAppServiceExtended extends ActorAppService implements IActorAppServiceExtended {

	public ActorAppServiceExtended(IActorRepositoryExtended actorRepositoryExtended,
				IActorMapperExtended mapper,LoggingHelper logHelper) {

		super(actorRepositoryExtended,
		mapper,logHelper);

	}

 	//Add your custom code here
 
}


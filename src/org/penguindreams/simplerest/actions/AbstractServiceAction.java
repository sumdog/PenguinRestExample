package org.penguindreams.simplerest.actions;

import org.penguindreams.simplerest.service.ServiceRequest;
import org.penguindreams.simplerest.service.ServiceResponse;

public abstract class AbstractServiceAction {

	public abstract ServiceResponse invoke(ServiceRequest request);
	
}

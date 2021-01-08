package com.fastcode.aaaloc.application.extended.payment;

import org.springframework.stereotype.Service;
import com.fastcode.aaaloc.application.core.payment.PaymentAppService;

import com.fastcode.aaaloc.domain.extended.payment.IPaymentRepositoryExtended;
import com.fastcode.aaaloc.domain.extended.customer.ICustomerRepositoryExtended;
import com.fastcode.aaaloc.domain.extended.rental.IRentalRepositoryExtended;
import com.fastcode.aaaloc.domain.extended.staff.IStaffRepositoryExtended;
import com.fastcode.aaaloc.commons.logging.LoggingHelper;

@Service("paymentAppServiceExtended")
public class PaymentAppServiceExtended extends PaymentAppService implements IPaymentAppServiceExtended {

	public PaymentAppServiceExtended(IPaymentRepositoryExtended paymentRepositoryExtended,
				ICustomerRepositoryExtended customerRepositoryExtended,IRentalRepositoryExtended rentalRepositoryExtended,IStaffRepositoryExtended staffRepositoryExtended,IPaymentMapperExtended mapper,LoggingHelper logHelper) {

		super(paymentRepositoryExtended,
		customerRepositoryExtended,rentalRepositoryExtended,staffRepositoryExtended,mapper,logHelper);

	}

 	//Add your custom code here
 
}


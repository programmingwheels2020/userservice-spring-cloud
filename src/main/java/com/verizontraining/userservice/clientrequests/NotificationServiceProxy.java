package com.verizontraining.userservice.clientrequests;

import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

//@FeignClient(name="notifcation-service", url = "localhost:8090")
@FeignClient(name="zuulapigateway")
@RibbonClient(name="notification-service" )
public interface NotificationServiceProxy {

	@GetMapping("/notification-service/send-registration-email/{email}")
	public String SendRegistrationEmail(@PathVariable("email") String email);
}

package com.ideas2it.user_service.service;

import java.util.HashMap;

import org.springframework.boot.actuate.info.Info.Builder;
import org.springframework.boot.actuate.info.InfoContributor;
import org.springframework.stereotype.Component;

import com.ideas2it.user_service.controller.UserInfoController;

/**
 * InfoService is used to update the user modification count.
 * 
 * @author Vigneshwaran N
 */
@Component
public class InfoService implements InfoContributor {

	@Override
	public void contribute(Builder builder) {
		HashMap<String, Integer> userCount = new HashMap<>();
		userCount.put("NewUser", UserInfoController.saveCount);
		userCount.put("UpdatedUser", UserInfoController.updateCount);
		userCount.put("DeleteUser", UserInfoController.deleteCount);
		builder.withDetail("UserMetrics", userCount);

	}

}

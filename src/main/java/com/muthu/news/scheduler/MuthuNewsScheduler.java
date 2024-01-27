package com.muthu.news.scheduler;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

import com.muthu.news.service.PaymentService;
import com.razorpay.RazorpayException;

@Configuration
@EnableAsync
@EnableScheduling
public class MuthuNewsScheduler {

	@Autowired
	PaymentService service;

	private static final Logger logger = Logger.getLogger(MuthuNewsScheduler.class);

	@Async
	@Scheduled(cron = "0 0 0 * * ?")
	public void scheduleTask() throws RazorpayException {
		logger.info("Scheduled updation process started");
		service.updatePaymentDetail();
	}

}

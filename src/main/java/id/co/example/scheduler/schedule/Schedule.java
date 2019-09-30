package id.co.example.scheduler.schedule;

import id.co.example.scheduler.service.TransactionService;
import org.apache.commons.lang3.RandomStringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.Scheduled;

@Configuration
public class Schedule {

    private static final Logger log = LoggerFactory.getLogger(Schedule.class);

    @Autowired
    private TransactionService transactionService;

    @Scheduled(cron = "${schedule.transaction.time}")
    public void scheduleTransactionService(){
        String requestId = RandomStringUtils.randomAlphanumeric(10);
        log.info("Schedule.scheduleTransactionService generateTransaction with requestId : {}", requestId);
        transactionService.generateTransaction(requestId);
        log.info("Schedule.scheduleTransactionService generateTransaction with requestId : {} done", requestId);
    }

}

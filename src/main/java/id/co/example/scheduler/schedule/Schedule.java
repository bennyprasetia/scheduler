package id.co.example.scheduler.schedule;

import id.co.example.scheduler.service.TransactionService;
import org.apache.commons.lang3.RandomStringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.scheduling.concurrent.ThreadPoolTaskScheduler;
import org.springframework.scheduling.support.CronTrigger;
import org.springframework.stereotype.Component;

@Component
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


    public void scheduleExpressionFromParameter(final String cronExpression){
        log.info("ScheduleRegister.scheduleExpressionFromParameter cron : {}", cronExpression);
        ThreadPoolTaskScheduler scheduler = new ThreadPoolTaskScheduler();
        scheduler.initialize();
        scheduler.schedule(new Runnable() {
            @Override
            public void run() {
                log.info("Scheduler running with cron : {}", cronExpression);
            }
        }, new CronTrigger(cronExpression));
        log.info("ScheduleRegister.scheduleExpressionFromParameter success register cron : {}", cronExpression);
    }
}
